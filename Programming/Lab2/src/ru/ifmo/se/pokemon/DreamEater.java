package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class DreamEater extends SpecialMove {

    public DreamEater() {
        super(Type.PSYCHIC, 100, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon p, double power) {
        if (p.getCondition() == Status.SLEEP) {
            super.applyOppDamage(p, power);
        }
    }

    @Override
    protected void applySelfDamage(Pokemon p, double power) {
        p.setMod(Stat.HP, (int) - (power / 2));
    }

    @Override
    protected String describe() {
        return "Использует способность Dream Eater";
    }
}