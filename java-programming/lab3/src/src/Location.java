package src;

import src.En.Condition;
import src.En.WorldCondition;
import src.Inter.ChangeCondition;

import java.util.ArrayList;

public abstract class Location implements ChangeCondition<Condition, Human> {

    protected String name;
    protected Inventory inventory = new Inventory();
    protected int x;
    protected int y;

    public void items() {
        String a = "";
        for (Item i : this.inventory.getItems()) {
            a += i.getName() + ", ";
        }
        System.out.println("В " + this.name + " " + a);
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void conditionAdd(Human a, Condition b) {
        try {
            a.conditionAdd(b);
        } catch (ExistConditionException e) {
            //System.out.println("Состояние " + b + " уже добавлено");
            System.out.println(e);
        }
    }

    @Override
    public void conditionRemove(Human a, Condition b) {
        a.conditionRemove(b);
    }

    public void logIn(Human a) {
        changeCoordinate(a);
    }

    public int[] getCoordinate() {
        int[] coor = new int[2];
        coor[0] = x;
        coor[1] = y;
        return coor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        } else {
            Location a = (Location) obj;
            if (this.x == a.x && this.y == a.y) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int hashCode() {
        int a = 0;
        a += Math.pow(this.x,2) + Math.pow(this.y, 2);
        return a;
    }
    public void changeCoordinate(Human a) {
        a.setCoordinate(x,y);
    }

}
