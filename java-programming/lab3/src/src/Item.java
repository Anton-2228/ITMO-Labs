package src;

import src.Inter.PutGet;

import java.util.ArrayList;

public abstract class Item<T> implements PutGet<Human> {
    protected String name;

    protected Inventory location;

    @Override
    public void changeLocate(Inventory a) {
        //Добавить эксепшн
        if (this.location != null) {
            this.location.removeItems(this);
        }
        this.location = a;
        a.addItems(this);
    }

    public String getName() {
        return name;
    }

    public Inventory getLocation() {
        return location;
    }

}
