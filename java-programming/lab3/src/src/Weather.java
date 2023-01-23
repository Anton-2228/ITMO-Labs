package src;

import src.En.WorldCondition;
import src.Inter.EditCondition;

import java.util.ArrayList;

public class Weather implements EditCondition<WorldCondition> {
    //private WorldCondition[] currentWeather = new WorldCondition[1000000000];
    private ArrayList<WorldCondition> currentWeather;

    public Weather(ArrayList<WorldCondition> a) {
        currentWeather = a;
    }

    public ArrayList<WorldCondition> getCurrentWeather() {
        return currentWeather;
    }

    @Override
    public int hashCode() {
        int a = 0;
        for (WorldCondition i : currentWeather) {
            a += i.ordinal();
        }
        return a;
    }

    @Override
    public String toString() {
        String a = "";
        for (WorldCondition i : currentWeather) {
            a += i.name() + " ";
        }
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        } else {
            ArrayList<WorldCondition> a = new ArrayList<WorldCondition>();
            ArrayList<WorldCondition> b = new ArrayList<WorldCondition>();
            Weather d = (Weather) obj;
            boolean eq = true;
            if (currentWeather.size() != d.getCurrentWeather().size()) {
                return false;
            } else {
                for (WorldCondition i : currentWeather) {
                    if (!d.getCurrentWeather().contains(i)) {
                        eq = false;
                        break;
                    }
                }
                return eq;
            }
        }
    }

    @Override
    public void conditionSet(ArrayList<WorldCondition> a) {
        currentWeather = a;
    }

    @Override
    public void conditionAdd(WorldCondition a) {
        if (!currentWeather.contains(a)) {
            currentWeather.add(a);
        }
    }

    @Override
    public void conditionRemove(WorldCondition a) {
        currentWeather.remove(a);
    }

    @Override
    public ArrayList<WorldCondition> conditionGet() {
        return currentWeather;
    }
}
