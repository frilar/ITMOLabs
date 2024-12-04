package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public class Eelektrik extends Tynamo {
    public Eelektrik(String name, int level) {

        super(name, level);
        setType(Type.ELECTRIC);
        setStats(65, 85, 70, 75, 70, 40);
        setMove(new ThunderWave(), new ChargeBeam(), new AcidSpray());

    }
}
