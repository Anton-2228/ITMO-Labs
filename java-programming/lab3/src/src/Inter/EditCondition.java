package src.Inter;

import src.ExistConditionException;

import java.util.ArrayList;

//+ condition_set(enum[]): void
//+ condition_add(enum): void
//+ condition_remove(enum): void
//+ condition_get(): enum[]

public interface EditCondition<T extends Enum<?>> {
    public void conditionSet(ArrayList<T> a);
    public void conditionAdd(T a) throws ExistConditionException;
    public void conditionRemove(T a);
    public ArrayList<T> conditionGet();

}
