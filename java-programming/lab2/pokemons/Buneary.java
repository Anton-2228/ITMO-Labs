package pokemons;

import attacks.BabyDollEyes;
import attacks.ChargeBeam;
import attacks.QuickAttack;
import ru.ifmo.se.pokemon.*;

public class Buneary extends Pokemon {
    public Buneary(String name, int level) {
        super(name, level);
        setType(Type.NORMAL);
        setStats(55,66,44,44,56,85);
        setMove(new BabyDollEyes(), new QuickAttack(), new ChargeBeam());
    }
}
