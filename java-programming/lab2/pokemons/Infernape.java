package pokemons;

import attacks.BulkUp;
import attacks.Confide;
import attacks.SlackOff;
import attacks.WillOWisp;
import ru.ifmo.se.pokemon.*;

public class Infernape extends Pokemon {
    public Infernape(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.FIGHTING);
        setStats(76,104,71,104,71,108);
        setMove(new BulkUp(), new Confide(), new SlackOff(), new WillOWisp());
    }
}
