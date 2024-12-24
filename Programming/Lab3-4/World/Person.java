package World;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Person {
    String name;
    Place place;
    State state;
    List<Event> events;

    public Person(String name, Place place, State state) {
        this.name = name;
        this.place = place;
        this.state = state;
        this.events = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Place getPlace() {
        return place;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void jump() {
        System.out.println(getName() + " прыгнул(а)");
    }

    public List<Event> getEvents() {
        return events;
    }

    public abstract void reactToEvent(Event event);
    public abstract void assistJump(Person person);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                place == person.place &&
                state == person.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, state);
    }

    @Override
    public String toString() {
        return "name= " + name +
                ", state= " + state +
                ", place= " + place +
                ", events= " + events;
    }
}