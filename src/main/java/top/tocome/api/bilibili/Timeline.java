package top.tocome.api.bilibili;

import com.alibaba.fastjson.JSON;
import top.tocome.api.PublicApi;
import top.tocome.api.bilibili.data.TimelineData;

/**
 * BiliBili新番时间表
 */
public class Timeline extends PublicApi {
    /**
     * 新番时间表api
     */
    public static final String Api = "https://bangumi.bilibili.com/web_api/timeline_global";

    public Timeline() {
        super(Api);
    }

    /**
     * 设置访问者uid,会影响{@link top.tocome.api.bilibili.data.TimelineData.Result.Season#follow 追番情况}等参数
     *
     * @param visitor_uid 用户uid
     */
    public Timeline visitor_uid(long visitor_uid) {
        u.setParam("visitor_uid", String.valueOf(visitor_uid));
        return this;
    }

    /**
     * 请求数据，并解析为{@link TimelineData}类
     */
    public TimelineData parseTimeline() {
        return JSON.parseObject(request(), TimelineData.class);
    }
}
