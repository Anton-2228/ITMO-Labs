package attacks;

import ru.ifmo.se.pokemon.*;

public class QuickAttack extends PhysicalMove {
    public QuickAttack() {
        super(Type.NORMAL, 40.0, 100.0);
    }

    @Override
    protected String describe() {
        return "Use Quick Attack";
    }
}
