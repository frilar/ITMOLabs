package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {

        Battle b = new Battle();

        Cottonee cottone = new Cottonee ("Apple", 1);
        Mesprit mesprit = new Mesprit("Cocunut", 1);
        Eelektrik eelektrik = new Eelektrik("Tomato", 1);
        Eelektross eelektross = new Eelektross("Beetroot", 1);
        Tynamo tynamo = new Tynamo("Pineapple", 1);
        Whimsicott whimsicott = new Whimsicott("Carrot", 1);

        b.addAlly(cottone);
        b.addAlly(mesprit);
        b.addAlly(eelektrik);

        b.addFoe(eelektross);
        b.addFoe(tynamo);
        b.addFoe(whimsicott);

        b.go();
    }
}