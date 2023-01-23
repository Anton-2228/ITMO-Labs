package src;

import src.En.Condition;

import java.util.ArrayList;

public class Hollow extends Location{

    int width;

    public Hollow(int x, int y, int width) {
        this.name = "дупло";
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void logIn(Human a) {
        changeCoordinate(a);
        this.conditionAdd(a, Condition.Frozen);
        this.conditionRemove(a, Condition.Warm);
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
