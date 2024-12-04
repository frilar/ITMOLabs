package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class Mesprit extends Pokemon {
    public Mesprit(String name, int level) {

        super(name, level);
        setType(Type.PSYCHIC);
        setStats(80, 105, 105, 105, 105, 80);
        setMove(new Blizzard(), new Extrasensory(), new CalmMind(), new Psychic());

    }
}
