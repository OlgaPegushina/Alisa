package Other;

public class Cookie {

    private int part; //2-целое печенье, 1-попробованное, 0-съеденное

    public Cookie() {
        this.part = 2;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return " печеньице";
    }
}
