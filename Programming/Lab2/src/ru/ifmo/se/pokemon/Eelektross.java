package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.Pokemon;


public final class Eelektross extends Eelektrik {
    public Eelektross(String name, int level) {

        super(name, level);
        setType(Type.ELECTRIC);
        setStats(85, 115, 80, 105, 80, 50);
        setMove(new ThunderWave(), new ChargeBeam(), new AcidSpray(), new DragonClaw());

    }
}
