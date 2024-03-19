package Animals;

import Other.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class AnimalImpl implements Animal {
    protected String name; //имя
    protected Size size; //маленький,большой или норм
    protected Place currentLocation; //локация земля,двор и т.д. со своим рельефом
    protected Type type; //тип животного
    protected Health health; //раненый или нераненый здоровье
    //protected List<Skill> skills; //навыки
    protected Set<BodyPats> bodyPats; //части тела - голова, -ноги или лапы

    public AnimalImpl(String name, Type type, Size size, NamePlace namePlace, Health health) {
        this.name = name;
        this.type = type;
        this.size = size;
        Place place = new Place(namePlace);
        this.setCurrentLocation(place);
        bodyPats = new HashSet<>();
        this.health = health;
    }

    @Override
    public void lie() {
        System.out.println(this.name + " лежал " + this.currentLocation.getRelief().getNameRelief() + ".");//лежит на какой локации с каким рельефом
    }

    @Override
    public void support(BodyPats bodyPats, AnimalImpl animal) {
        System.out.print(this.name + " поддерживала " + bodyPats + " " + animal.getName() + ", а ");
    }

    @Override
    public void giveToDrink(AnimalImpl animal, Beast.Bottle bottle) {
        System.out.println(this.name + " чем-то поила " + animal.getName() + " из" + bottle + ".");//из чего поит вторая свинка
    }

    protected void decrease(Cookie cookie) {
        if (cookie.getPart() == 0) {
            this.setSize(Size.SMALL);
        }
    }

    @Override
    public void eat(Cookie cookie) {
        int i = cookie.getPart();
        if (i == 1) {
            cookie.setPart(0); //съедено
            System.out.println("а потом просто проглотила его.");
        } else if (i == 2) {
            tryCookie(cookie);//если еще не пробовала, то сначала попробовать
            eat(cookie);//а потом уже съесть
        } else if (i == 0) {
            System.out.println(cookie + " уже было съедено");
        }
    }

    @Override
    public void tryCookie(Cookie cookie) {
        int i = cookie.getPart();
        if (i > 0) {
            cookie.setPart(1);//попробовано
            System.out.println(getName() + " сначала попробовала " + cookie + ","); //выводит имя и что попробовала
        } else {
            System.out.println(getName() + " не смогла попробовать " + cookie + ", потому что оно закончилось");
        } //выводит имя и что попробовала
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Health getStatus() {
        return health;
    }

    public void setStatus(Health health) {
        this.health = health;
    }

    public Set<BodyPats> getBodyPats() {
        return bodyPats;
    }

    public Place getCurrentLocation() {
        return currentLocation;
    } //возврат локации со своим рельефом

    public void setCurrentLocation(Place currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return type + " " + name;
    } //печатаем тип и имя

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalImpl animalImpl = (AnimalImpl) o;
        return Objects.equals(name, animalImpl.name) && size == animalImpl.size && Objects.equals(currentLocation, animalImpl.currentLocation) && type == animalImpl.type && health == animalImpl.health && Objects.equals(bodyPats, animalImpl.bodyPats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, currentLocation, type, health, bodyPats);
    }

    public static class Amphibian extends AnimalImpl {

        public Amphibian(String name, Type type) {
            super(name, type, Size.SMALL, NamePlace.YARD, Health.HEALTHY);//специально установлен здоровый тритон, чтобы проверить исключение в исключении
            super.bodyPats.add(BodyPats.HEAD);
            super.bodyPats.add(BodyPats.PAWS);
        }

        public Amphibian(String name, Type type, Health health1) {
            super(name, type, Size.SMALL, NamePlace.YARD, health1);//специально установлен здоровый тритон, чтобы проверить исключение в исключении
            super.bodyPats.add(BodyPats.HEAD);
            super.bodyPats.add(BodyPats.PAWS);
        }
    }

    public static class Bird extends AnimalImpl {
        public Bird(String name, Type type) {
            super(name, type, Size.SMALL, NamePlace.YARD, Health.HEALTHY);
            super.bodyPats.add(BodyPats.HEAD); //голова
            super.bodyPats.add(BodyPats.LEGS); //ноги
        }
    }

    public static class Beast extends AnimalImpl {
        private final Bottle bottle;

        public Beast(String name, Type type) {
            super(name, type, Size.SMALL, NamePlace.YARD, Health.HEALTHY);
            bottle = new Beast.Bottle(); //бутылка у свинки полная, у других пустая
            super.bodyPats.add(BodyPats.HEAD); //годова
            super.bodyPats.add(BodyPats.PAWS); //лапы
        }

        public Beast.Bottle getBottle() {
            return Beast.this.bottle;
        } //из чего поит

        public class Bottle {
            private int part; //2-целая, 1-начатая, 0-пустая

            public Bottle() {
                if (Beast.this.getType() != Type.GUINEA_PIG) {
                    this.part = 0;
                } else {
                    this.part = 2;
                }
            }

            public int getPart() {
                return part;
            }

            public void setPart(int part) {
                this.part = part;
            }

            @Override
            public String toString() {
                return " бутылки";
            }
        }
    }

}
