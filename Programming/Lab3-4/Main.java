import Exception.*;
import World.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static World.Place.*;
import static World.State.*;

public class Main {
    public static void main(String[] args) {
        // События для каждого персонажа
        List<Event> neznaikaEvents = new ArrayList<>();
        List<Event> knopochkaEvents = new ArrayList<>();
        List<Event> pestryenkiyEvents = new ArrayList<>();

        neznaikaEvents.add(Event.CRASH);
        knopochkaEvents.add(Event.LOCOMOTIVE);
        pestryenkiyEvents.add(Event.CAR);

        // Создание персонажей
        Neznaika neznaika = new Neznaika("Незнайка", UNKNOWN, REGULAR, neznaikaEvents);
        Knopochka knopochka = new Knopochka("Кнопочка", UNKNOWN, REGULAR, knopochkaEvents);
        Pestryenkiy pestryenkiy = new Pestryenkiy("Пестренький", UNKNOWN, REGULAR, pestryenkiyEvents, new ArrayList<>());

        // Создание поезда
        Train train = new Train("Поезд");
        Random random = new Random();

        // Добавление мороженого
        List<IceCream> iceCreams = new ArrayList<>();
        iceCreams.add(new IceCream(Flavour.CHOCOLATE));
        iceCreams.add(new IceCream(Flavour.VANILE));

        // Список персонажей
        List<Person> shorties = new ArrayList<>();
        shorties.add(neznaika);
        shorties.add(knopochka);
        shorties.add(pestryenkiy);

        try {
            System.out.println("С этими словами он побежал к паровозу, который уже разводил пары.");
            neznaika.run(STATION);
            train.separate();

            System.out.println("Пассажиры бросились бежать к своим вагонам.");
            train.move();

            System.out.println("Некоторым коротышкам пришлось прыгать в вагоны на ходу.");
            for (int i = 0; i < shorties.size(); i++) {
                Person shorty = shorties.get(i);
                System.out.println(shorty.getName() + " пытается запрыгнуть в вагон...");

                // Проверка состояния
                if (shorty.getState() == SCARED) {
                    throw new TooScaredToMoveException(shorty.getName());
                }

                // Шанс успешного прыжка
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

            System.out.println("Вернувшись на шоссе, коротышки продолжали путешествие.");
            shorties.forEach(shorty -> shorty.setPlace(HIGHWAY));

            // Пестренький ест мороженое
            System.out.println(pestryenkiy.getName() + " по-прежнему сидел позади и ел мороженое.");
            while (!iceCreams.isEmpty()) {
                IceCream iceCream = iceCreams.remove(0);
                pestryenkiy.eat(iceCream);
                System.out.println(pestryenkiy.getName() + " съел " + iceCream + " и успокоился.");
                pestryenkiy.setState(CALM);
            }



        } catch (MissedTrainException | FailedToBoardWagonException | TooScaredToMoveException e) {
            System.out.println(e.getMessage());
        } catch (IceCreamDepletedException e) {
            System.out.println(e.getMessage());
        }
        pestryenkiyEvents.forEach(pestryenkiy::reactToEvent);
        pestryenkiy.setState(CALM);
        pestryenkiy.say("что то говорит");

        knopochkaEvents.forEach(knopochka::reactToEvent);
        knopochka.setState(REGULAR);
        knopochka.remember(Event.LOCOMOTIVE);

        neznaikaEvents.forEach(neznaika::reactToEvent);
        neznaika.setState(EXCITED);
        neznaika.say("рассказывает, как он сообразил в самый последний момент повернуть машину");
    }
}