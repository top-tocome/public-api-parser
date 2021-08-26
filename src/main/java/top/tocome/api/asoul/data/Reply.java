package top.tocome.api.asoul.data;

public class Reply {
    /**
     * 该评论的回复ID	0以外的值为查询失败
     */
    public String rpid;
    /**
     * 评论的类型ID
     * 1：视频
     * 12：专栏
     * 11/17：动态
     */
    public int type_id;
    public String dynamic_id;
    /**
     * 评论发布者的UID
     */
    public long mid;
    /**
     * 动态/视频/专栏 发布者的UID
     */
    public long uid;
    /**
     * 动态/视频/专栏 对应的ID	对于视频是AV号
     * 对于动态是动态ID
     * 对于专栏是CV号
     */
    public String oid;
    /**
     * 评论的创建时间	10位时间戳(秒)
     */
    public long ctime;
    /**
     * 评论发布者的用户名
     */
    public String m_name;
    /**
     * 评论正文
     */
    public String content;
    /**
     * 评论获得的点赞数
     */
    public int like_num;
    /**
     * 该评论引用的评论的rpid	如果是原创，该项为 -1
     */
    public String origin_rpid;
    /**
     * 与该评论相似的评论数
     */
    public int similar_count;
    /**
     * 该评论赞数 + 所有相似评论赞数	如果该评论非原创，则不会累加
     */
    public int similar_like_sum;
}
