package World;

import Interfaces.Eatable;
import Interfaces.Talkable;
import Exception.IceCreamDepletedException;

import java.util.List;

public class Pestryenkiy extends Person implements Eatable, Talkable {

    private List<IceCream> iceCreams;

    public Pestryenkiy(String name, Place place, State state, List<Event> events, List<IceCream> iceCreams) {
        super(name, place, state);
        this.events.addAll(events);
        this.iceCreams = iceCreams;
    }

    @Override
    public void eat(IceCream iceCream) throws IceCreamDepletedException {
        if (!iceCreams.contains(iceCream)) {
            throw new IceCreamDepletedException();
        }
        iceCreams.remove(iceCream);
        System.out.println(getName() + " ест " + iceCream + " и успокаивается.");
        setState(State.CALM);
    }

    @Override
    public void say(String message) {
        System.out.println(getName() + " говорит: " + message);
    }

    @Override
    public void assistJump(Person person) {
        if (this.state == State.CALM) {
            System.out.println(getName() + " нехотя помогает " + person.getName() + " запрыгнуть в вагон.");
            person.setState(State.CALM);
            System.out.println(person.getName() + " теперь в состоянии: " + person.getState());
        } else {
            System.out.println(getName() + " не хочет помогать, потому что слишком переволновался.");
        }
    }

    @Override
    public void reactToEvent(Event event) {
        if (events.contains(event)) {
            if (event == Event.CAR) {
                say("Я так переволновался, когда вылетел из машины!");
                setState(State.OVERWHEMELED);
            }
        } else {
            System.out.println(getName() + " не знает, как реагировать на событие: " + event);
        }
    }
}