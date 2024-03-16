package Animals;

import Other.BodyPats;
import Other.Cookie;

public interface Animal {
    void lie();

    void eat(Cookie cookie);

    void tryCookie(Cookie cookie);

    void support(BodyPats bodyPats, AnimalImpl animal);

    void giveToDrink(AnimalImpl animal, AnimalImpl.Beast.Bottle bottle);

}
