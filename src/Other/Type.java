package Other;

public enum Type {
    CROW("ворона"),
    MARTIN("ласточка"),
    OWL("филин"),
    TRITON("тритон"),
    GUINEA_PIG("морская свинка"),
    HUMAN("человек");
    private final String name;

    Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
