package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class ThunderWave extends StatusMove {

    public ThunderWave() {
        super(Type.ELECTRIC, 0, 90);
    }

    @Override
    public void applyOppEffects(Pokemon p) {
        Effect eff = new Effect();
        eff.paralyze(p);
        eff.attack(0.25);
        eff.stat(Stat.SPEED, (int) p.getStat(Stat.SPEED) / 2);
        p.addEffect(eff);
    }

    @Override
    protected String describe() {
        return "Использует Thunder Wave";
    }
}