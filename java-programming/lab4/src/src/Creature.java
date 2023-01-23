package src;

import src.En.Condition;
import src.Inter.EditCondition;

import java.util.ArrayList;

public abstract class Creature implements EditCondition<Condition> {
    protected ArrayList<Condition> currentCondition;
    protected int x;
    protected int y;

    @Override
    public void conditionSet(ArrayList<Condition> a) {
        currentCondition = a;
    }

    @Override
    public void conditionAdd(Condition a) throws ExistConditionException {
        if (!currentCondition.contains(a)) {
            currentCondition.add(a);
        } else {
            throw new ExistConditionException("Состояние уже присутствует");
        }
    }

    @Override
    public void conditionRemove(Condition a) {
        currentCondition.remove(a);
    }

    @Override
    public ArrayList<Condition> conditionGet() {
        return currentCondition;
    }

    public int[] getCoordinate() {
        int[] coor = new int[2];
        coor[0] = x;
        coor[1] = y;
        return coor;
    }

    public void setCoordinate(int a, int b) {
        x = a;
        y = b;
    }
}
