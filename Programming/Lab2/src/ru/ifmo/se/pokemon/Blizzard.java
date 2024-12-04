package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class Blizzard extends SpecialMove {

    public Blizzard() {
        super(Type.ICE, 110, 70);
    }

    private boolean check = false;

    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() <= 0.1) {
            check = true;
            Effect.freeze(p);
        }
    }

    @Override
    protected String describe() {
        if (check) {
            return "Вам повезло! Атака Blizzard замораживает противника и наносит ему урон.";
        }
        else {
            return "Атака Blizzard наносит урон противнику.";
        }
    }

}