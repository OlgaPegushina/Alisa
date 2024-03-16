package Other;

//import Animals.Amphibian;

import Animals.AnimalImpl;

import java.util.ArrayList;
import java.util.List;

public class CollectionOfAllAnimals {

    private final List<AnimalImpl> team; //список животных, кроме человека

    public CollectionOfAllAnimals() {
        team = new ArrayList<>();
    }

    public void addall(AnimalImpl animalImpl) {
        team.add(animalImpl);
    } //добавляем животного в список

    public void getTogether(NamePlace namePlace) {
        System.out.println(namePlace + " собралась целая толпа мелких животных и птиц, там были:");
        for (AnimalImpl currentAnimal : this.team) {
            System.out.print(currentAnimal + ", "); //печатаем тип и имя
        }
        System.out.println();
    }

    public AnimalImpl searchingForPatient() throws PatientIsNotReadyException {

        for (AnimalImpl currentAnimal : this.team) {
            if (currentAnimal.getStatus().equals(Health.WOUNDED)) {//находим у кого статус раненый
                System.out.println("Все толпились вокруг пострадавшего " + currentAnimal.getName() + ".");
                System.out.println(currentAnimal.getName() + " это " + currentAnimal.getSize() + " " + currentAnimal.getType() + "."); //описываем кто он
                return currentAnimal;
            }
        }
        throw new PatientIsNotReadyException("\n@В списке животных не найден пострадавший. Мы сами создадим раненого тритончика, раз Вы забыли. Не волнуйтесь, сказка продолжается\n");
    }

    public void liePatients() {

        for (AnimalImpl currentAnimal : this.team) {
            if (currentAnimal.getStatus().equals(Health.WOUNDED)) {//находим у кого статус раненый
                currentAnimal.lie();
            }
        }
    }

    //ищем двух свинок и передаем раненого
    public void lookForGuineaPig(AnimalImpl animal) {
        int temp = 0;
        for (AnimalImpl currentAnimal : this.team) {
            if (currentAnimal.getType() == Type.GUINEA_PIG) {
                if (temp != 1) {
                    if (animal.getBodyPats().contains(BodyPats.HEAD)) {
                        currentAnimal.support(BodyPats.HEAD, animal);
                    }
                    temp = 1;
                } else {
                    currentAnimal.giveToDrink(animal, ((AnimalImpl.Beast) currentAnimal).getBottle());
                }

            }

        }
    }

    //вложенный класс -исключение
    class PatientIsNotReadyException extends RuntimeException {

        public PatientIsNotReadyException(String message) {
            super(message);
        }
    }
}