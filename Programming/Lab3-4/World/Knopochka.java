package World;

import Interfaces.Remember;

import java.util.List;

public class Knopochka extends Person implements Remember {
    public Knopochka(String name, Place place, State state, List<Event> events) {
        super(name, place, state);
        this.events.addAll(events);
    }

    @Override
    public void remember(Event moment) {
        System.out.println(getName() + " вспомнила, " + moment);
    }

    @Override
    public void assistJump(Person person) {
        if (this.state == State.SCARED) {
            System.out.println(getName() + " слишком испуган(а), чтобы помочь " + person.getName() + ".");
        } else {
            System.out.println(getName() + " помогает " + person.getName() + " запрыгнуть в вагон.");
            person.setState(State.CALM);
            System.out.println(person.getName() + " теперь в состоянии: " + person.getState());
        }
    }

    @Override
    public void reactToEvent(Event event) {
        if (events.contains(event)) {
            if (event == Event.LOCOMOTIVE) {
                setState(State.SCARED);
                System.out.println(getName() + " вспомнила, как она испугалась паровоза");
            }
        } else {
            System.out.println(getName() + " не знает, как реагировать на событие: " + event);
        }
    }
}