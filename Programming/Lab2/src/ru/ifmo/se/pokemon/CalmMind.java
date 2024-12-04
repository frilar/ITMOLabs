package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class CalmMind extends StatusMove {

    public CalmMind() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect eff = new Effect();
        eff = eff.stat(Stat.SPECIAL_ATTACK, 1);
        eff = eff.turns(1);
        eff = eff.stat(Stat.SPECIAL_DEFENSE, 1);
        eff = eff.turns(1);
        p.addEffect(eff);
    }

    @Override
    protected String describe() {
        return "Использует на себя Calm Mind.";
    }

}