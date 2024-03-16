package Other;

public class Place {
    private NamePlace namePlace;

    private final Relief relief;

    public Place(NamePlace namePlace) {
        this.namePlace = namePlace;
        relief = new Relief();
        relief.selectionOfRelief(this);


    }

    public NamePlace getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(NamePlace namePlace) {
        this.namePlace = namePlace;
        relief.selectionOfRelief(this);
    }

    public Relief getRelief() {
        return relief;
    }

}
