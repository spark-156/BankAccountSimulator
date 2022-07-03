package Money;

public enum Currency {
    EURO("€"),
    DOLLAR("$"),
    YEN("¥");
    public final String label;
    Currency(String label) {
        this.label = label;
    }
}
