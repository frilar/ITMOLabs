package World;

public record IceCream(Flavour flavour) {
    @Override
    public String toString() {
        return flavour + " мороженое";
    }
}