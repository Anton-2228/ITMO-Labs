package attacks;

import ru.ifmo.se.pokemon.*;

public class WillOWisp extends StatusMove {
    public WillOWisp() {
        super(Type.FIRE, 0.0, 85.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.burn(p);
    }

    @Override
    protected String describe() {
        return "Use Will-O-Wisp";
    }
}
