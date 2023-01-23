package src;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    public void setItems(ArrayList<Item> item) {
        this.items = item;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public void removeItems(Item item) {
        this.items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
