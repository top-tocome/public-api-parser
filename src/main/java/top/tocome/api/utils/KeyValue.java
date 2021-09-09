package top.tocome.api.utils;

/**
 * url参数键值对
 */
public class KeyValue {
    protected String key;
    protected String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
