package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class Whimsicott extends Cottonee {
    public Whimsicott(String name, int level) {

        super(name, level);
        setType(Type.GRASS, Type.FAIRY);
        setStats(60, 67, 85, 77, 75, 116);
        setMove(new DoubleTeam(), new DreamEater(), new Growth(), new Psychic());

    }
}

