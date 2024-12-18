import World.*;
import Exception.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import static World.Place.*;
import static World.State.*;

public class Main {
    public static void main(String[] args) {
        List<String> neznaikaEvents = new ArrayList<>();
        List<String> knopochkaEvents = new ArrayList<>();
        List<String> pestryenkiyEvents = new ArrayList<>();

        neznaikaEvents.add("столкновение");
        knopochkaEvents.add("паровоз");
        pestryenkiyEvents.add("машина");

        Neznaika neznaika = new Neznaika("незнайка", STATION, REGULAR, neznaikaEvents);
        Knopochka knopochka = new Knopochka("кнопочка", STATION, REGULAR, knopochkaEvents);
        Pestryenkiy pestryenkiy = new Pestryenkiy("пестренький", STATION, REGULAR, pestryenkiyEvents);
        Train train = new Train("Поезд");
        Random random = new Random();

        List<IceCream> IceCreams = new ArrayList<>();
        IceCream iceCream = new IceCream("хуевое");
        IceCreams.add(iceCream);

        List<Person> shorties = new ArrayList<>();
        shorties.add(neznaika);
        shorties.add(knopochka);
        shorties.add(pestryenkiy);

        System.out.println("С этими словами он побежал к паровозу, который уже разводил пары.");
        neznaika.run();
        train.separate();

        System.out.println("Пассажиры бросились бежать к своим вагонам. Но никто не слушал его.");
        train.move();
        System.out.println("некоторым коротышкам пришлось прыгать в вагоны на ходу");

        for (int i = 0; i < shorties.size(); i++) {
            Person shorty = shorties.get(i);
            System.out.println(shorty.getName() + " пытается запрыгнуть в вагон...");


            if (shorty.getState() == SCARED) {
                throw new TooScaredToMoveException(shorty.getName());
            }


            int baseChance = 80;
            if (i > 0) {
                Person helper = shorties.get(i - 1);
                helper.assistJump(shorty);
                baseChance += 20;
            }

            int chance = random.nextInt(100) + 1;
            System.out.println("Шанс успешного прыжка: " + baseChance + "% (Реальное значение: " + chance + ")");

            if (chance > baseChance) {
                throw new FailedToBoardWagonException(shorty.getName());
            } else {
                shorty.jump();
                shorty.setPlace(WAGON);
                System.out.println(shorty.getName() + " успешно запрыгнул(а) в вагон!");
            }
        }

        System.out.println("Вернувшись на шоссе, коротышки продолжали путешествие");
        neznaika.setPlace(HIGHWAY);
        knopochka.setPlace(HIGHWAY);
        pestryenkiy.setPlace(HIGHWAY);

        System.out.println(pestryenkiy.getName() + " по-прежнему сидел позади и ел мороженое");
        try {
            while(true) {
                if(IceCreams.isEmpty()) {
                    throw new IceCreamDepletedException();
                }
                IceCream eatenIceCream = IceCreams.remove(0);
                pestryenkiy.eat();
                System.out.println(pestryenkiy.getName() + " съел " + eatenIceCream + " и успокоился.");
                pestryenkiy.setState(CALM);
                break;
            }
        } catch(IceCreamDepletedException e) {
            System.out.println(e.getMessage());
        }

        for(String event: pestryenkiyEvents) {
            pestryenkiy.reactToEvent(event);
        }
        pestryenkiy.setState(CALM);

        for(String event: knopochkaEvents) {
            knopochka.reactToEvent(event);
        }
        knopochka.setState(REGULAR);

        for(String event: neznaikaEvents) {
            neznaika.reactToEvent(event);
        }
        neznaika.setState(EXCITED);
    }
}
