package src;

import src.En.Condition;

import java.util.ArrayList;

public class Fog extends Location{

    public Fog(int x, int y) {
        this.name = "туман";
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void logIn(Human a) {
        changeCoordinate(a);
        this.conditionAdd(a, Condition.Hidden);
    }

    public void putAwayItem(Item a, Inventory b) {
        // ДОБАВИТЬ ЭКСЕПШН
        if (this.inventory.getItems().contains(a)) {
            a.changeLocate(b);
        }
    }

    public void getIt(Item a) {
        if (!this.inventory.getItems().contains(a)) {
            a.changeLocate(this.inventory);
        }
    }

}
