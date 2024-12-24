package Interfaces;

import World.IceCream;
import Exception.IceCreamDepletedException;

public interface Eatable {
    void eat(IceCream iceCream) throws IceCreamDepletedException;
}