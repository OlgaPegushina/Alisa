package Other;

public class Relief {
    private NameRelief nameRelief;

    public NameRelief getNameRelief() {
        return nameRelief;
    }

    public void setNameRelief(NameRelief nameRelief) {
        this.nameRelief = nameRelief;
    }

    public void selectionOfRelief(Place place) {
        switch (place.getNamePlace()) {
            case NamePlace.YARD:
                this.setNameRelief(NameRelief.GRASS);
                break;
            case NamePlace.MOUNTAIN:
                this.setNameRelief(NameRelief.STONE);
                break;
            case NamePlace.DESERT:
                this.setNameRelief(NameRelief.SAND);
                break;
            case NamePlace.OCEAN:
                this.setNameRelief(NameRelief.WATER);
                break;
            default:
                this.setNameRelief(NameRelief.NONE);
        }
    }
}
