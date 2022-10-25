package pokemons;

import attacks.BabyDollEyes;
import attacks.BrutalSwing;
import attacks.ChargeBeam;
import attacks.QuickAttack;
import ru.ifmo.se.pokemon.*;

public class Lopunny extends Pokemon {
    public Lopunny(String name, int level) {
        super(name, level);
        setType(Type.NORMAL);
        setStats(65,76,84,54,96,105);
        setMove(new BabyDollEyes(), new QuickAttack(), new ChargeBeam(), new BrutalSwing());
    }
}
