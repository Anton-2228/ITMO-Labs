package attacks;

import ru.ifmo.se.pokemon.*;

public class BabyDollEyes extends StatusMove {
    public BabyDollEyes() {
        super(Type.FAIRY, 0.0, 100.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -1);
    }

    @Override
    protected String describe() {
        return "Use Baby-Doll Eyes";
    }
}
