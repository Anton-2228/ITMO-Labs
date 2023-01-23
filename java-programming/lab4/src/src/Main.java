package src;

import src.En.Condition;
import src.En.TimeOfDay;
import src.En.WorldCondition;
import src.Inter.Sentiments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Coordinate coordinate = new Coordinate();
        Day day = new Day(TimeOfDay.Night);

        ArrayList<WorldCondition> weat = new ArrayList<WorldCondition>();
        weat.add(WorldCondition.Dark);
        Weather weather = new Weather(weat);

        ArrayList<Condition> conditions = new ArrayList<Condition>();
        Leaves leaves = new Leaves("сухие листья");
        Stick stick = new Stick("палка");
        Hollow hollow = new Hollow(0, 0, 100);
        hollow.getIt(leaves);
        hollow.getIt(stick);
        hollow.items();
        TopHat topHat = new TopHat("цилиндр");
        LeftShoe leftShoe = new LeftShoe("левый ботинок");
        RightShoe rightShoe = new RightShoe("правый ботинок");
        Human Scooperfield = new Human(conditions, "Scooperfield", hollow, 170);
        Scooperfield.getIt(topHat);
        Scooperfield.getIt(rightShoe);
        Scooperfield.getIt(leftShoe);
        Scooperfield.putAwayItem(topHat, hollow.getInventory());
        hollow.items();
        Scooperfield.decide.doing("поскорей заснуть");
        try {
            Scooperfield.conditionAdd(Condition.Hunger);
        } catch (ExistConditionException e) {
            System.out.println("Человек уже голоден");
        }
        Scooperfield.getFeelings().feelPain("нога", 8);
        Scooperfield.think.doing("нога болит из-за непривычки спать в обуви");
        Scooperfield.putAwayItem(leftShoe, hollow.getInventory());
        Scooperfield.putAwayItem(rightShoe, hollow.getInventory());
        Scooperfield.getFeelings().feelPain("тело", 6);
        try {
            Scooperfield.conditionAdd(Condition.Pain);
        } catch (ExistConditionException e) {
            System.out.println("Человеку уже больно");
        }
        if (hollow.getWidth() < Scooperfield.getGrowth()) {
            try {
                Scooperfield.conditionAdd(Condition.Uncomfortable);
            } catch (ExistConditionException e) {
                System.out.println("Человеку уже некомфортно");
            }
        } else {
            Scooperfield.conditionRemove(Condition.Pain);
        }

        if (day.getCurrentTime().equals(TimeOfDay.Night)) {
            if (coordinate.compareCoordinate(Scooperfield, hollow)) {
                for (int i = 2; i > 0; i--) {
                    if (Scooperfield.conditionGet().contains(Condition.Frozen)) {
                        Scooperfield.feel();
                        Scooperfield.goOut(hollow);
                        String move;
                        if (Scooperfield.conditionGet().contains(Condition.Uncomfortable)) {
                            if (Math.random() >= 0.5) {
                                move = "бегать";
                            } else {
                                move = "прыгать";
                            }
                            Scooperfield.workOut(move);
                            Scooperfield.conditionRemove(Condition.Uncomfortable);
                        }
                        if (Scooperfield.conditionGet().contains(Condition.Hunger)) {
                            if (Math.random() >= 0.7) {
                                Scooperfield.eat("кора", 0);
                            }
                        }
                        Scooperfield.feel();
                        if (Scooperfield.conditionGet().contains(Condition.Warm)) {
                            Scooperfield.goTo(hollow);
                            try {
                                Scooperfield.conditionAdd(Condition.Uncomfortable);
                            } catch (ExistConditionException e) {
                                System.out.println("Скуперфильду уже некомфортно");
                            }
                        }
                    }
                }
            }
            day.change(TimeOfDay.Morning);
            weather.conditionAdd(WorldCondition.WeakLight);
            weather.conditionRemove(WorldCondition.Dark);
            try {
                Scooperfield.conditionAdd(Condition.Sleepiness);
            } catch (ExistConditionException e) {
                System.out.println("Человек уже сонный");
            }
            Scooperfield.conditionRemove(Condition.Frozen);
            Scooperfield.feel();
        }

        if (day.getCurrentTime().equals(TimeOfDay.Morning)) {
            Scooperfield.goOut(hollow);
            Scooperfield.conditionRemove(Condition.Uncomfortable);
            Scooperfield.conditionRemove(Condition.Pain);
            Scooperfield.move();
            if (weather.getCurrentWeather().contains(WorldCondition.WeakLight)) {
                Scooperfield.hit("дерево");
            }
        }

        Scooperfield.getFeelings().saw("снег");
        Scooperfield.move();
        Valley valley = new Valley(2, 3);
        Scooperfield.goTo(valley);
        Human.Sentiment sentiment = new Human.Sentiment();
        sentiment.awareness(Scooperfield, "снег", "туман");
        Fog fog = new Fog(2, 4);
        if (coordinate.compareCoordinate(Scooperfield, valley)) {
            Scooperfield.goTo(fog);
        }
        Scooperfield.feel();
        Scooperfield.move();
        Scooperfield.getFeelings().saw("красоту природы, которую раньше не замечал");
        sentiment.regret(Scooperfield, "не учился рисовать, и не может изобразить эту красоту");
    }
}