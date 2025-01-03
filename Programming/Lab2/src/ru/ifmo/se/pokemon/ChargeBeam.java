package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class ChargeBeam extends SpecialMove {

    public ChargeBeam() {
        super(Type.ELECTRIC, 50, 90);
    }

    @Override
    public void applySelfEffects(Pokemon p) {
        if (Math.random() <= 0.7) {
            p.setMod(Stat.SPECIAL_ATTACK, 1);
        }
    }

    @Override
    protected String describe() {
        return "Использует Charge Beam";
    }
}