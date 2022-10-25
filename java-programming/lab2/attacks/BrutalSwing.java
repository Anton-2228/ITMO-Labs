package attacks;

import ru.ifmo.se.pokemon.*;

public class BrutalSwing extends PhysicalMove {
    public BrutalSwing() {
        super(Type.DARK, 60.0, 100.0);
    }

    @Override
    protected String describe() {
        return "Use Brutal Swing";
    }
}
