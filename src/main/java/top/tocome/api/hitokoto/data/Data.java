package top.tocome.api.hitokoto.data;

/**
 * 一言响应数据格式
 */
public class Data {
    /**
     * 一言标识
     */
    public int id;
    /**
     * 一言唯一标识；
     * 可以链接到 https://hitokoto.cn?uuid=[uuid]
     * 查看这个一言的完整信息
     */
    public String uuid;
    /**
     * 一言正文。编码方式 unicode。使用 utf-8。
     */
    public String hitokoto;
    /**
     * 类型。请参考第三节参数的表格
     */
    public String type;
    /**
     * 一言的出处
     */
    public String from;
    /**
     * 一言的作者
     */
    public String from_who;
    /**
     * 添加者
     */
    public String creator;
    /**
     * 添加者用户标识
     */
    public int creator_uid;
    /**
     * 审核员标识
     */
    public int reviewer;
    /**
     * 提交方式
     */
    public String commit_from;
    /**
     * 添加时间
     */
    public String created_at;
    /**
     * 句子长度
     */
    public int length;
}
