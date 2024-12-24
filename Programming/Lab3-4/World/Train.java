package World;

import Interfaces.Movable;

public class Train implements Movable {
    private String name;

    public Train(String name) {
        this.name = name;
    }

    public void separate() {
        System.out.println(name + " разводит пары");
    }

    @Override
    public void move() {
        System.out.println(name + " тронулся");
    }
}
