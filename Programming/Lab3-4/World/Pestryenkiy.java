package World;

import Interfaces.Eatable;
import Interfaces.Talkable;

import java.util.List;

public class Pestryenkiy extends Person implements Eatable, Talkable {

    public Pestryenkiy(String name, Place place, State state, List<String> events) {
        super(name, place, state);
        this.events.addAll(events);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " ест");
    }

    @Override
    public void say() {
        System.out.println(getName() + " говорил, что очень переволновался, когда вылетел из машины, а мороженое успокоительно действует на него");
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
    public void reactToEvent(String event) {
        if (events.contains(event)) {
            if (event.contains("машина")) {
                say();
                this.state = State.SCARED;
            }
        }
        else {
            System.out.println(getName() + " не знает, как реагировать на событие: " + event);
        }
    }

}
