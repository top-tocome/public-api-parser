package top.tocome.api.asoul;

import com.alibaba.fastjson.JSON;
import top.tocome.api.PublicApi;
import top.tocome.api.asoul.data.*;
import top.tocome.io.Http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;

/**
 * [枝网查重开源项目地址](https://github.com/ASoulCnki/ASoulCnki)
 */
public class ASoulCnki extends PublicApi {
    /**
     * 项目部署站点
     */
    public static final String SiteUrl = "https://asoulcnki.asia";
    /**
     * 查重api
     */
    public static final String CheckApi = SiteUrl + "/v1/api/check/";
    /**
     * 作文展api
     */
    public static final String RankingApi = SiteUrl + "/v1/api/ranking/";

    /**
     * 查重<br>
     * 请求类型：POST<br>
     * 请求地址：{@value #CheckApi}<br>
     * Content-Type: application/json
     *
     * @param text 查重文本	长度在10-1000之间
     * @return 原生数据
     */
    public static String check(String text) {
        try {
            HttpURLConnection connection = Http.getConnection(CheckApi);
            connection.setRequestProperty("Content-Type", "application/json");
            return new String(Http.post(connection, "{ \"text\": \"" + text + "\"}"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发出请求并将数据解析为{@link Check}数据类
     *
     * @return {@link Check}
     * @see #check(String)
     */
    public static Check parseCheck(String text) {
        return JSON.parseObject(check(text), Check.class);
    }

    /**
     * 作文展<br>
     * 请求类型：GET<br>
     * 请求地址：{@value #RankingApi}<br>
     * 请求时的必要参数
     *
     * @param pageSize      {@link #pageSize(int)}
     * @param pageNum       {@link #pageNum(int)}
     * @param timeRangeMode {@link #timeRangeMode(TimeRangeMode)}
     * @param sortMode      {@link #sortMode(SortMode)}
     */
    public ASoulCnki(int pageSize, int pageNum, TimeRangeMode timeRangeMode, SortMode sortMode) {
        super(RankingApi);
        u.addParam("pageSize", String.valueOf(pageSize))
                .addParam("pageNum", String.valueOf(pageNum))
                .addParam("timeRangeMode", String.valueOf(timeRangeMode.ordinal()))
                .addParam("sortMode", String.valueOf(sortMode.ordinal()));
    }

    /**
     * 效果为修改必选参数
     *
     * @param pageSize 每页展示的评论数	目前仅支持pageSize=10
     */
    public ASoulCnki pageSize(int pageSize) {
        u.setParam("pageSize", String.valueOf(pageSize));
        return this;
    }

    /**
     * 效果为修改必选参数
     *
     * @param pageNum 评论页码	从1开始
     */
    public ASoulCnki pageNum(int pageNum) {
        u.setParam("pageNum", String.valueOf(pageNum));
        return this;
    }

    /**
     * 效果为修改必选参数
     *
     * @param timeRangeMode {@link TimeRangeMode 时间范围选择}<br>
     *                      0 全部时间<br>
     *                      1 一周内<br>
     *                      2 三天以内
     */
    public ASoulCnki timeRangeMode(TimeRangeMode timeRangeMode) {
        u.setParam("timeRangeMode", String.valueOf(timeRangeMode.ordinal()));
        return this;
    }

    /**
     * 效果为修改必选参数
     *
     * @param sortMode {@link SortMode 排序模式}<br>
     *                 0 总点赞数（参见{@link Reply#similar_like_sum related.reply.similar_like_num}）<br>
     *                 1 点赞数<br>
     *                 2 相似小作文数（引用次数）
     */
    public ASoulCnki sortMode(SortMode sortMode) {
        u.setParam("sortMode", String.valueOf(sortMode.ordinal()));
        return this;
    }

    /**
     * 可选参数，默认为全部
     *
     * @param ids 指定动态发布者（非评论）
     *            传值为uid数组 例：ids=uid1,uid2.....
     */
    public ASoulCnki ids(long... ids) {
        u.setParam("ids", Arrays.toString(ids).replaceAll("[\\[\\] ]", ""));
        return this;
    }

    /**
     * 可选参数，默认无限制条件
     *
     * @param keywords 指定关键词
     *                 传值为关键词数组 例 keywords=k1,k2,...<br>
     *                 每个关键词不超过10个字符 最多支持三个关键词
     */
    public ASoulCnki keywords(String... keywords) {
        u.setParam("keywords", Arrays.toString(keywords).replaceAll("[\\[\\] ]", ""));
        return this;
    }

    /**
     * 发出请求并将数据解析为{@link Ranking}数据类
     *
     * @return {@link Ranking}
     */
    public Ranking parseRanking() {
        return JSON.parseObject(request(), Ranking.class);
    }

    /**
     * 时间范围选择
     */
    public enum TimeRangeMode {
        /**
         * 全部时间
         */
        AllTimes,
        /**
         * 一周内
         */
        OneWeek,
        /**
         * 三天以内
         */
        ThreeDays
    }

    /**
     * 排序模式
     */
    public enum SortMode {
        /**
         * 总点赞数（参见related.reply.similar_like_num）
         */
        TotalStar,
        /**
         * 点赞数
         */
        Star,
        /**
         * 相似小作文数（引用次数）
         */
        Similar
    }
}