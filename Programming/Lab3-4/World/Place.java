package World;

public enum Place {
    STATION("станция"),
    WAGON("вагон"),
    HIGHWAY("шоссе"),
    UNKNOWN("неизвестно");

    private final String description;

    Place(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}