package Other;

public enum NamePlace {
    YARD("На дворе"), //ДВОР
    MOUNTAIN("На горе"), //ГОРА
    DESERT("В пустыне"), //ПУСТЫНЯ
    OCEAN("В океане"), //ОКЕАН
    HOUSE("В доме"); //ДОМ
    public String titleWhere;

    NamePlace(String titleWhere) {
        this.titleWhere = titleWhere;
    }

    @Override
    public String toString() {
        return titleWhere;
    }
}
