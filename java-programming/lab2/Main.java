import ru.ifmo.se.pokemon.*;
import pokemons.*;

import java.security.cert.PolicyNode;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon v1 = new Heracross("Один", 1);
        Pokemon v2 = new Buneary("Два", 1);
        Pokemon v3 = new Chimchar("Три", 1);
        Pokemon r1 = new Infernape("Другой один", 1);
        Pokemon r2 = new Lopunny("Другой два", 1);
        Pokemon r3 = new Monferno("Другой три", 1);
        b.addAlly(v1);
        b.addAlly(v2);
        b.addAlly(v3);
        b.addFoe(r1);
        b.addFoe(r2);
        b.addFoe(r3);
        b.go();
    }
}