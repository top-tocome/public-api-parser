package top.tocome.api;

import top.tocome.api.utils.UrlBuilder;
import top.tocome.io.Http;

/**
 * get请求方式的api
 */
public class PublicApi {
    /**
     * url参数构造
     */
    protected UrlBuilder u;

    public PublicApi(String api) {
        u = new UrlBuilder(api);
    }

    /**
     * 构造好的url
     */
    public String getFullUrl() {
        return u.toString();
    }

    /**
     * 发出get请求
     *
     * @return 原生数据
     */
    public String request() {
        return Http.get(u.toString());
    }
}
