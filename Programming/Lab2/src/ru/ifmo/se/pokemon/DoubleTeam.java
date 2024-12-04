package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class DoubleTeam extends StatusMove {

    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect eff = new Effect();
        eff = eff.stat(Stat.EVASION, +1);
        eff = eff.turns(1);
        p.addEffect(eff);
    }

    @Override
    protected String describe() {
        return "Использует на себя Double Team.";
    }

}