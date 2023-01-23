package src.Inter;

import src.Creature;
import src.Human;
import src.Inventory;
import src.Location;

public interface PutGet<T extends Creature>{
    public void changeLocate(Inventory a);
}