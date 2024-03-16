package Other;

public enum NameStat {
    DELIGHT("восторг"), //ВОСТОРГ
    NORMAL("спокойное состояние"); //НОРМА
    private final String name;

    NameStat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
