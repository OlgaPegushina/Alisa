package Other;

public enum BodyPats {
    HEAD("голову"), //ГОЛОВА
    PAWS("лапы"), //ЛАПЫ
    LEGS("ноги"); //НОГИ
    private final String name;

    BodyPats(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
