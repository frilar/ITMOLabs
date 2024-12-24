package World;

import Interfaces.Runnable;
import Interfaces.Talkable;
import Exception.*;
import java.util.List;

public class Neznaika extends Person implements Runnable, Talkable {
    public Neznaika(String name, Place place, State state, List<Event> events) {
        super(name, place, state);
        this.events.addAll(events);
    }

    @Override
    public void run(Place destination) {
        if (destination != Place.STATION) {
            throw new MissedTrainException(getName() + " побежал не к поезду! Поезд уехал без него.");
        }
        System.out.println(getName() + " бежит к " + destination + ".");
        this.setPlace(destination);
    }

    @Override
    public void say(String message) {
        System.out.println(getName() + " говорит: " + message);
    }

    @Override
    public void assistJump(Person person) {
        System.out.println(getName() + " помогает " + person.getName() + " запрыгнуть в вагон!");
        person.setState(State.CALM);
        System.out.println(person.getName() + " теперь в состоянии: " + person.getState());
    }

    @Override
    public void reactToEvent(Event event) {
        if (events.contains(event)) {
            if (event == Event.CRASH) {
                setState(State.EXCITED);
            }
        } else {
            System.out.println(getName() + " не знает, как реагировать на событие: " + event);
        }
    }
}