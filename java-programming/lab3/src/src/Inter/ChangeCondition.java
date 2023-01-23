package src.Inter;

public interface ChangeCondition<T extends Enum<?>, V extends Object> {
    public void conditionAdd(V a, T b);
    public void conditionRemove(V a, T b);
}
