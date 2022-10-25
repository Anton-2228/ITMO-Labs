package attacks;

import pokemons.Heracross;
import ru.ifmo.se.pokemon.*;

public class SlackOff extends StatusMove {
    public SlackOff() {
        super(Type.NORMAL, 0.0, 0.0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, (int) p.getStat(Stat.HP)/(-2));
    }

    @Override
    protected String describe() {
        return "Use Slack Off";
    }
}
