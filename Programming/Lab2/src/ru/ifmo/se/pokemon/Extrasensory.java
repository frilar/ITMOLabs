package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class Extrasensory extends SpecialMove {

    public Extrasensory() {
        super(Type.PSYCHIC, 80, 100);
    }

    private boolean check = false;

    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() <= 0.1) {
            check = true;
            Effect.flinch(p);
        }
    }

    @Override
    protected String describe() {
        if(check) {
            return "Вам повезло! Атака Extrasensory заставляет противника вздрогнуть и наносит ему урон.";
        }
        else {
            return "Атака Extrasensory наносит урон противнику.";
        }
    }

}