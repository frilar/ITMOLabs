package World;

public record IceCream(String flavor) {
    @Override
    public String toString() {
        return flavor + " мороженое";
    }
}