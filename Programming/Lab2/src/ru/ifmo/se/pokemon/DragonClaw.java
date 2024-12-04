package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public final class DragonClaw extends PhysicalMove {
    public DragonClaw() {
        super(Type.NORMAL, 40, 100);
    }

    @Override
    protected String describe() {
        return "Использует DragonClaw";
    }
}