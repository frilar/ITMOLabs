package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class Growth extends StatusMove {

    public Growth() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, 1);
        p.setMod(Stat.SPECIAL_ATTACK, 1);
    }

    @Override
    protected String describe() {
        return "Использует способность Growth";
    }

}
