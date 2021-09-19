package top.tocome.api.utils;

import java.util.ArrayList;

/**
 * url get请求参数构造器
 */
public class UrlBuilder {
    /**
     * 接口主地址
     */
    private final String api;
    /**
     * 参数键值对
     */
    protected ArrayList<KeyValue> keyValues = new ArrayList<>();

    public UrlBuilder(String api) {
        this.api = api;
    }

    /**
     * 添加一对参数 &key=value
     * 相同key会重复添加
     */
    public UrlBuilder addParam(String key, String value) {
        keyValues.add(new KeyValue(key, value));
        return this;
    }

    /**
     * 添加或设置一对参数 &key=value
     * 相同key会覆盖上次value
     */
    public UrlBuilder setParam(String key, String value) {
        for (KeyValue k : keyValues) {
            if (k.getKey().equals(key)) {
                k.setValue(value);
                return this;
            }
        }
        keyValues.add(new KeyValue(key, value));
        return this;
    }

    /**
     * 清空已设置的键值对
     */
    public void clear() {
        keyValues.clear();
    }

    @Override
    public String toString() {
        StringBuilder u = new StringBuilder(api);
        u.append("?");
        for (KeyValue k : keyValues) {
            u.append("&").append(k.getKey()).append("=").append(k.getValue());
        }
        return u.toString();
    }
}
