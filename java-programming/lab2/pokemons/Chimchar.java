package pokemons;

import attacks.BulkUp;
import attacks.Confide;
import ru.ifmo.se.pokemon.*;

public class Chimchar extends Pokemon {
    public Chimchar(String name, int level) {
        super(name, level);
        setType(Type.FIRE);
        setStats(44,58,44,58,44,61);
        setMove(new BulkUp(), new Confide());
    }
}
