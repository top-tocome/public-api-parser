package top.tocome.api.utils;

public class UrlBuilder {
    private final StringBuilder url;

    public UrlBuilder(String url) {
        this.url = new StringBuilder(url);
        this.url.append("/?");
    }

    public UrlBuilder appendParam(String key, String value) {
        url.append("&").append(key).append("=").append(value);
        return this;
    }

    public String build() {
        return url.toString();
    }
}
