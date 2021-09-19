package top.tocome.api.bilibili;

import com.alibaba.fastjson.JSON;
import top.tocome.api.PublicApi;
import top.tocome.api.bilibili.data.DynamicData;

/**
 * BiliBili动态
 */
public class Dynamic extends PublicApi {
    /**
     * api
     */
    public static final String Api = "https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/space_history";

    public Dynamic(long host_uid) {
        super(Api);
        u.addParam("host_uid", String.valueOf(host_uid));
    }

    /**
     * 设置要获取动态的目标用户
     *
     * @param host_uid 目标用户uid
     */
    public Dynamic host_uid(long host_uid) {
        u.setParam("host_uid", String.valueOf(host_uid));
        return this;
    }

    /**
     * 请求数据，并解析为{@link DynamicData}类
     */
    public DynamicData parseTimeline() {
        return JSON.parseObject(request(), DynamicData.class);
    }
}
