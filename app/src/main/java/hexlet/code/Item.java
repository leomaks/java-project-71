package hexlet.code;

public class Item {

    private String key;
    private String status;
    private Object oldValue;
    private Object newValue;
    public final String getKey() {
        return key;
    }

    public final String getStatus() {
        return status;
    }

    public final Object getOldValue() {
        return oldValue;
    }

    public final Object getNewValue() {
        return newValue;
    }

    public Item(String key, String status, Object oldValue, Object newValue) {
        this.key = key;
        this.status = status;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}
