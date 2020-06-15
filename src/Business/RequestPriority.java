package Business;

public enum RequestPriority implements java.io.Serializable {
    COMMON(0),
    IMPORTANT(1),
    URGENT(2);    

    private final int numVal;

    RequestPriority(int numVal) {
        this.numVal = numVal;
    }

    public int get_value() {
        return numVal;
    }
}
