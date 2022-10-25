package pokemons;

import attacks.FuryAttack;
import attacks.RockBlast;
import attacks.RockSlide;
import attacks.StoneEdge;
import ru.ifmo.se.pokemon.*;

public class Heracross extends Pokemon {
    public Heracross(String name, int level) {
        super(name, level);
        setStats(80,125,75,40,95,85);
        setType(Type.BUG, Type.FIGHTING);
        setMove(new RockBlast(), new RockSlide(), new StoneEdge(), new FuryAttack());
    }
}
