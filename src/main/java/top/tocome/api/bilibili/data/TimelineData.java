package top.tocome.api.bilibili.data;

/**
 * BiliBili新番时间表数据类
 */
public class TimelineData {
    /**
     * 错误码，0为成功
     */
    public int code;
    /**
     * 错误消息
     */
    public String message;
    /**
     * 响应结果
     */
    public Result[] result;


    public static class Result {
        /**
         * 日期: MM-dd
         */
        public String date;
        /**
         * ts时间
         */
        public long date_ts;
        /**
         * 周几
         */
        public int day_of_week;
        /**
         * 是否为今天
         * 1: 是
         * 0: 不是
         */
        public int is_today;
        /**
         * 番剧信息
         */
        public Season[] seasons;

        public static class Season {
            /**
             * 封面图片url链接
             */
            public String cover;
            /**
             * 未知，固定为 0
             */
            public int delay;
            /**
             * 番剧编号
             * https://www.bilibili.com/bangumi/play/ep + ep_id
             */
            public int ep_id;
            /**
             * 未知，固定为 0
             */
            public int favorites;
            /**
             * 追番情况
             * 1：已追番
             * 0：未追番
             */
            public int follow;
            /**
             * 更新情况
             * 1：已更新
             * 0：未更新
             */
            public int is_published;
            /**
             * 更新集数
             * 第xx话
             */
            public String pub_index;
            /**
             * 更新时间：hh:mm
             */
            public String pub_time;
            /**
             * ts更新时间
             */
            public long pub_ts;
            /**
             * 番剧编号
             * https://www.bilibili.com/bangumi/play/ss + season_id
             */
            public int season_id;
            /**
             * 权限
             * 13：会员专享
             * 2：普通
             */
            public int season_status;
            /**
             * 方形封面url地址
             */
            public String square_cover;
            /**
             * 番剧标题
             */
            public String title;
            /**
             * 番剧url地址
             */
            public String url;
        }

    }

}
