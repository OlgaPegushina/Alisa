package Animals;

import Other.*;

public class Human extends AnimalImpl {
    private final Stat stat;//состояние Алисы: восторг, спокойствие

    public Human(String name) {
        super(name, Type.HUMAN, Size.NORMAL, NamePlace.HOUSE, Health.HEALTHY);
        stat = new Stat();
        stat.setNameStat(NameStat.NORMAL); //в спокойном состоянии
        super.bodyPats.add(BodyPats.HEAD);
        super.bodyPats.add(BodyPats.LEGS);
    }

    //уменьшается и приходит в восторг, если съедено печенье
    @Override
    public void decrease(Cookie cookie) {
        if (cookie.getPart() == 0) {
            this.stat.setNameStat(NameStat.DELIGHT);
            this.setSize(Size.SMALL);
            printStat();
            noticed();
        }
    }

    //заметить
    public void noticed() {
        if (this.getSize() == Size.SMALL) {
            System.out.println(" - особенно когда заметила, что начала уменьшаться! И стала " + this.getSize() + ".");
        }
    }

    //печатает состояние
    public void printStat() {
        System.out.println(this.getName() + " пришла в " + this.stat.getNameStat()); //печать статуса -восторга
    }

    //выбежать из дома во двор
    public void runOutOfTheHouse() {
        if (this.getSize() == Size.SMALL) { //если уменьшилась
            if (this.getCurrentLocation().getNamePlace() == NamePlace.HOUSE) { //если еще в доме
                System.out.println("Как только Алиса стала такая маленькая, что смогла пройти в дверь, она выбежала из дома.");
                super.currentLocation.setNamePlace(NamePlace.YARD);//местоположение Алисы теперь двор с травой
            }
        }
    }
}
