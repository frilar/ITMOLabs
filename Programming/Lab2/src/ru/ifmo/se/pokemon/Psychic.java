package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class Psychic extends SpecialMove {

    public Psychic() {
        super(Type.PSYCHIC, 90, 100);
    }

    private boolean check = false;

    @Override
    protected void applyOppEffects(Pokemon p) {
        if(Math.random() <= 0.1) {
            check = true;
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

    @Override
    protected String describe() {
        if(check) {
            return "Вам повезло! Атака Psychic снижает специальную защиту противника на 1 и наносит ему урон.";
        }
        else {
            return "Атака Psychic наносит противнику урон.";
        }
    }

}
