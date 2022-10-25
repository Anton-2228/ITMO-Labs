package attacks;

import ru.ifmo.se.pokemon.*;

public class FuryAttack extends PhysicalMove {
    public FuryAttack() {
        super(Type.NORMAL, 15.0, 85.0);
    }

    @Override
    protected void applyOppDamage(Pokemon p, double damage) {
        for (double i : new double[] {1.0, 0.375, 0.375, 0.125, 0.125}) {
            if (Math.random() <= i) {
                p.setMod(Stat.HP, (int) Math.round(damage));
            } else {
                break;
            }
        }
    }

    @Override
    protected String describe() {
        return "Use Fury Attack";
    }
}
