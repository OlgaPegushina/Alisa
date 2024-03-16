import Animals.AnimalImpl;
import Animals.Human;
import Other.CollectionOfAllAnimals;
import Other.Cookie;
import Other.Tell;
import Other.Type;

public class Main {
    public static void main(String[] args) {

        Cookie cookie = new Cookie();
        //создаем человека, птиц, 1 амфибию и минимум 2 свинки
        Human human1 = new Human("Алиса");

        AnimalImpl.Bird bird1 = new AnimalImpl.Bird("Каркуша", Type.CROW);
        AnimalImpl.Bird bird2 = new AnimalImpl.Bird("Ластёна", Type.MARTIN);
        AnimalImpl.Bird bird3 = new AnimalImpl.Bird("Филя", Type.OWL);

        //AnimalImpl.Amphibian amphibian1 = new AnimalImpl.Amphibian("Биль", Type.TRITON);  //РЕМАРИМ ДЛЯ ИСКЛЮЧЕНИЯ

        AnimalImpl.Beast beast1 = new AnimalImpl.Beast("Ксюша", Type.GUINEA_PIG);
        AnimalImpl.Beast beast2 = new AnimalImpl.Beast("Хрюша", Type.GUINEA_PIG);

        //собираем всех кроме человека в толпу
        CollectionOfAllAnimals team = new CollectionOfAllAnimals();
        team.addall(bird1);
        team.addall(bird2);
        team.addall(bird3);
        team.addall(beast1);
        team.addall(beast2);
        //team.addall(amphibian1);

        //запускаем рассказ
        Tell tell1 = new Tell();
        tell1.go(human1, team, cookie); //передается объект человека и список всех животных


    }

}
