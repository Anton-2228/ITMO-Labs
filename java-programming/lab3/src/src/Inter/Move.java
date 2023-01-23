package src.Inter;

import src.Inventory;
import src.Item;

public interface Move<T extends Object> {
    public void move();
    public void workOut(String a);
    public void hit(String a);

    public void eat(String a, int b);
    public void goTo(T a);
    public void goOut(T a);
    public void putAwayItem(Item a, Inventory b);
    public void getIt(Item a);
}
