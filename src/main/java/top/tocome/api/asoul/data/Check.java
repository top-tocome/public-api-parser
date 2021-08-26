package top.tocome.api.asoul.data;

public class Check {
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
         * 查重小作文的重复率	范围0-1，1为100%
         */
        public int rate;
        /**
         * 查询范围的起始时间	10位时间戳(秒)
         */
        public long start_time;
        /**
         * 查询范围的结束时间	10位时间戳(秒)，最后小作文收录的时间
         */
        public long end_time;
        /**
         * 重复文本的数组
         */
        public Related[] related;
    }

    public static class Related {
        /**
         * 原文从本评论中复制的占比	仅查重API使用
         * 范围0-1，1为100%
         */
        public int rate;
        /**
         * @see Reply
         */
        public Reply[] replies;
        /**
         * reply_url	指向该条评论的链接	该链接可以根据typeid和oid自行构造
         */
        public String reply_url;
    }
}
