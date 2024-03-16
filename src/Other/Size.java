package Other;

public enum Size {
    SMALL("маленький"),
    NORMAL("нормального размера"),
    BIG("большой");

    private final String name;

    Size(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
