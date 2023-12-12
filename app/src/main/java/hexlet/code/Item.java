package hexlet.code;


public class Item {

    private String key;
    private Object oldValue;
    private Object newValue;

    private Status status;

    public final String getKey() {
        return key;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Object getOldValue() {
        return oldValue;
    }

    public final Object getNewValue() {
        return newValue;
    }

    public Item(String key, Status status, Object oldValue, Object newValue) {
        this.key = key;
        this.status = status;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}
