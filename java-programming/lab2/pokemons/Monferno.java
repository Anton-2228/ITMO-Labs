package pokemons;

import attacks.BulkUp;
import attacks.Confide;
import attacks.SlackOff;
import ru.ifmo.se.pokemon.*;

public class Monferno extends Pokemon {
    public Monferno(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.FIGHTING);
        setStats(64,78,52,78,52,81);
        setMove(new BulkUp(), new Confide(), new SlackOff());
    }
}
