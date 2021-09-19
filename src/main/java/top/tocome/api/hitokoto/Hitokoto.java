package top.tocome.api.hitokoto;

import com.alibaba.fastjson.JSON;
import top.tocome.api.PublicApi;
import top.tocome.api.hitokoto.data.Data;

/**
 * [一言api文档](https://developer.hitokoto.cn/sentence/)
 */
public class Hitokoto extends PublicApi {
    /**
     * 网站地址
     */
    public static final String SiteUrl = "https://hitokoto.cn";
    /**
     * v1接口地址
     * 未来将更换为v2
     */
    public static final String ApiV1 = "https://v1.hitokoto.cn/";

    public Hitokoto() {
        super(ApiV1);
    }

    /**
     * 可选参数,句子类型
     *
     * @param type a	动画
     *             b	漫画
     *             c	游戏
     *             d	文学
     *             e	原创
     *             f	来自网络
     *             g	其他
     *             h	影视
     *             i	诗词
     *             j	网易云
     *             k	哲学
     *             l	抖机灵
     *             其他	随机
     */
    public Hitokoto type(char type) {
        u.setParam("c", String.valueOf(type));
        return this;
    }

    /**
     * 可选参数,返回编码
     *
     * @param encode false:  json	返回格式化后的 JSON 文本<br>
     *               true:   js	返回指定选择器的同步调用函数。默认选择器为：.hitokoto<br>
     *               text:	返回纯洁文本,由{@link #simpleGetText(char)}单独处理<br>
     *               其他	返回格式化后的 JSON 文本
     */
    public Hitokoto encode(String encode) {
        u.setParam("encode", encode);
        return this;
    }

    /**
     * 可选参数,字符集
     *
     * @param charset false: utf-8	返回 utf-8 编码的内容<br>
     *                true:  gbk	返回 gbk 编码的内容。不支持与异步函数同用<br>
     *                其他	返回 utf-8 编码的内容
     */
    public Hitokoto charset(String charset) {
        u.setParam("charset", charset);
        return this;
    }

    /**
     * @param callback 调用的异步函数<br>
     *                 如：moe
     */
    public Hitokoto callback(String callback) {
        u.setParam("callback", callback);
        return this;
    }

    /**
     * @param select 选择器。
     *               配合 encode = js
     *               使用<br>
     *               默认：.hitokoto
     */
    public Hitokoto select(String select) {
        u.setParam("select", select);
        return this;
    }

    /**
     * @param min_length 返回句子的最小长度（包含）<br>
     *                   默认：0
     */
    public Hitokoto min_length(int min_length) {
        u.setParam("min_length", String.valueOf(min_length));
        return this;
    }

    /**
     * @param max_length 返回句子的最大长度（包含）<br>
     *                   默认：30
     */
    public Hitokoto max_length(int max_length) {
        u.setParam("max_length", String.valueOf(max_length));
        return this;
    }

    /**
     * 发出请求并将数据解析为{@link Data}数据类
     *
     * @return {@link Data}
     */
    public Data parseData() {
        return JSON.parseObject(request(), Data.class);
    }

    /**
     * 封装常用的简单请求
     *
     * @param type {@link #type(char)}
     * @return {@link Data}
     */
    public static Data simpleGet(char type) {
        return new Hitokoto().type(type).parseData();
    }

    /**
     * 获取纯洁文本
     *
     * @param type {@link #type(char)}
     */
    public static String simpleGetText(char type) {
        return new Hitokoto().encode("text").type(type).request();
    }
}
