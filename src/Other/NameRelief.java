package Other;

public enum NameRelief {
    GRASS("на травке"), //ТРАВА
    SAND("на песке"), //ПЕСОК
    STONE("на камне"), //КАМЕНЬ
    WATER("в воде"), //ВОДА
    NONE(" ");
    private final String name;

    NameRelief(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
