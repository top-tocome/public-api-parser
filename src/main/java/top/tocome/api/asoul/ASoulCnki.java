package top.tocome.api.asoul;

import com.alibaba.fastjson.JSON;
import top.tocome.api.asoul.data.Check;
import top.tocome.api.asoul.data.Ranking;
import top.tocome.io.Http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;

/**
 * [枝网查重开源项目地址](https://github.com/ASoulCnki/ASoulCnki)
 */
public class ASoulCnki {
    /**
     * 项目部署站点
     */
    public static final String SiteUrl = "https://asoulcnki.asia";
    /**
     * 查重api
     */
    public static final String CheckApi = SiteUrl + "/v1/api/check";
    /**
     * 作文展api
     */
    public static final String RankingApi = SiteUrl + "/v1/api/ranking";

    /**
     * 查重<br>
     * 请求类型：POST<br>
     * 请求地址：{@value #CheckApi}<br>
     * Content-Type: application/json
     *
     * @param text 查重文本	长度在10-1000之间
     * @return {@link Check}
     */
    public static Check check(String text) {
        HttpURLConnection connection = null;
        try {
            connection = Http.getConnection(CheckApi);
            connection.setRequestProperty("Content-Type", "application/json");
            String s = new String(Http.post(connection, "{ \"text\": \"" + text + "\"}"));
            return JSON.parseObject(s, Check.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 作文展<br>
     * 请求类型：GET<br>
     * 请求地址：{@value #RankingApi}
     *
     * @param pageSize      每页展示的评论数	目前仅支持pageSize=10
     * @param pageNum       评论页码	从1开始
     * @param timeRangeMode {@link TimeRangeMode 时间范围选择}<br>
     *                      0 全部时间<br>
     *                      1 一周内<br>
     *                      2 三天以内
     * @param sortMode      {@link SortMode 排序模式}<br>
     *                      0 总点赞数（参见related.reply.similar_like_num）<br>
     *                      1 点赞数<br>
     *                      2 相似小作文数（引用次数）
     * @param ids           指定动态发布者（非评论）	可选参数，默认为全部<br>
     *                      传值为uid数组 例：ids=uid1,uid2.....
     * @param keywords      指定关键词	可选参数，默认无限制条件<br>
     *                      传值为关键词数组 例 keywords=k1,k2,...<br>
     *                      每个关键词不超过10个字符 最多支持三个关键词
     * @return {@link Ranking}
     */
    public static Ranking ranking(int pageSize, int pageNum, TimeRangeMode timeRangeMode, SortMode sortMode, long[] ids, String[] keywords) {
        StringBuilder url = new StringBuilder(RankingApi);
        url.append("/?pageSize=").append(pageSize)
                .append("&pageNum=").append(pageNum)
                .append("&timeRangeMode=").append(timeRangeMode.ordinal())
                .append("&sortMode=").append(sortMode.ordinal());
        if (ids != null) url.append("&ids=").append(Arrays.toString(ids).replaceAll("[\\[\\] ]", ""));
        if (keywords != null) url.append("&keywords=").append(Arrays.toString(keywords).replaceAll("[\\[\\] ]", ""));
        String jsonString = Http.get(url.toString());
        return JSON.parseObject(jsonString, Ranking.class);
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