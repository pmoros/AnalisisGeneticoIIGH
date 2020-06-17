package Business;

/**
 *
 * @author pmoro
 */
public enum RequestPriority implements java.io.Serializable, Comparable<RequestPriority> {
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
    
    public int compare_to(RequestPriority o){
        if(this.numVal < o.numVal) return - 1;
        else if(this.numVal > o.numVal) return 1;
        else{
            return 0;
        }
    }
    
}
