package src;

import java.util.ArrayList;

public class Valley  extends Location{

    public Valley(int x, int y) {
        this.name = "поляна";
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
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
