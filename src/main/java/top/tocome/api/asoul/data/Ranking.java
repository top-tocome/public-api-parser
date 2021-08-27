package top.tocome.api.asoul.data;

/**
 * 作文展响应参数<br>
 * [api文档](https://github.com/ASoulCnki/ASoulCnkiBackend/blob/master/api.md)
 */
public class Ranking {
    /**
     * 查询状态码	0以外的值为查询失败
     */
    public int code;
    /**
     * 查询状态的相关信息，默认success
     */
    public String message;
    /**
     * @see Data
     */
    public Data data;

    public static class Data {
        /**
         * @see Reply
         */
        public Reply[] replies;
        /**
         * 查到评论的总数	用于计算页数
         */
        public int all_count;
        /**
         * 评论起始时间	10位时间戳(秒)
         */
        public long start_time;
        /**
         * 评论结束时间	10位时间戳(秒)
         */
        public long end_time;
    }
}

