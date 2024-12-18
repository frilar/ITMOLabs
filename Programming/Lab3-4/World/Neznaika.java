package World;

import Interfaces.Runnable;
import Interfaces.Talkable;

import java.util.List;

public class Neznaika extends Person implements Runnable, Talkable {
    public Neznaika(String name, Place place, State state, List<String> events) {
        super(name, place, state);
        this.events.addAll(events);
    }

    @Override
    public void run() {
        System.out.println(getName() + " бежит");
    }

    @Override
    public void say() {
        System.out.println(getName() + " с увлечением рассказывал, как он сообразил в самый последний момент повернуть машину");
    }

    @Override
    public void assistJump(Person person) {
        System.out.println(getName() + " помогает " + person.getName() + " запрыгнуть в вагон!");
        person.setState(State.CALM);
        System.out.println(person.getName() + " теперь в состоянии: " + person.getState());
    }

    @Override
    public void reactToEvent(String event) {
        if (events.contains(event)) {
            if (event.contains("столкновение")) {
                say();
            }
        }
        else {
            System.out.println(getName() + " не знает, как реагировать на событие: " + event);
        }
    }
}
