package Other;

//import Animals.Amphibian;

import Animals.AnimalImpl;
import Animals.Human;

public final class Tell {

    public void go(Human human, CollectionOfAllAnimals team, Cookie cookie) {
        AnimalImpl patient;

        human.tryCookie(cookie);//попробовать
        human.eat(cookie);//съесть,
        human.decrease(cookie);//уменьшилась
        human.runOutOfTheHouse();//выбежать из дома
        team.getTogether(NamePlace.YARD);//все животные оказаться во дворе
        //поиск пострадавшего, вокруг которого все будут толпиться
        try {
            patient = team.searchingForPatient();
            patient.lie();
            team.lookForGuineaPig(patient);
        } catch (CollectionOfAllAnimals.PatientIsNotReadyException exception) {
            System.out.println(exception.getMessage());
            AnimalImpl.Amphibian amphibian1 = new AnimalImpl.Amphibian("Биль", Type.TRITON, Health.WOUNDED);// в случае исключения создаем сами раненого тритона
            team.addall(amphibian1);
            /*
            patient = amphibian1;
            System.out.println("Все толпились вокруг пострадавшего " + amphibian1.getName() + ".");
            System.out.println(amphibian1.getName() + " это " + amphibian1.getSize() + " " + amphibian1.getType() + ".");
            patient.lie();
            team.lookForGuineaPig(patient);*/
            //try{
            patient = team.searchingForPatient();
            patient.lie();
            team.lookForGuineaPig(patient);
            // } catch (CollectionOfAllAnimals.PatientIsNotReadyException exception2){
            // }
        }
        System.out.println("\nСказочке конец, а кто слушал молодец!");
    }
}
