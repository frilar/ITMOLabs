package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public class Cottonee extends Pokemon {
    public Cottonee(String name, int level) {

        super(name, level);
        setType(Type.GRASS, Type.FAIRY);
        setStats(40, 27, 60, 37, 50, 66);
        setMove(new DoubleTeam(), new DreamEater(), new Growth());

    }
}