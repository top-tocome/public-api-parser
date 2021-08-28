package top.tocome.api.hitokoto;

import com.alibaba.fastjson.JSON;
import top.tocome.api.hitokoto.data.Data;
import top.tocome.io.Http;

/**
 * [api文档](https://developer.hitokoto.cn/sentence/)
 */
public class Hitokoto {
    /**
     * 网站地址
     */
    public static final String SiteUrl = "https://hitokoto.cn/";
    /**
     * v1接口地址
     * 未来将更换为v2
     */
    public static final String ApiV1 = "https://v1.hitokoto.cn";

    /**
     * 以下都为可选参数<br>
     * 有许多参数暂时不需要使用<br>
     * 推荐使用{@link #simpleGet(char)}
     *
     * @param type       句子类型<br>
     *                   a	动画
     *                   b	漫画
     *                   c	游戏
     *                   d	文学
     *                   e	原创
     *                   f	来自网络
     *                   g	其他
     *                   h	影视
     *                   i	诗词
     *                   j	网易云
     *                   k	哲学
     *                   l	抖机灵
     *                   其他	作为 动画 类型处理
     * @param encode     返回编码<br>
     *                   text	返回纯洁文本
     *                   json	返回格式化后的 JSON 文本
     *                   js	返回指定选择器的同步调用函数。默认选择器为：.hitokoto
     *                   其他	返回格式化后的 JSON 文本
     * @param charset    字符集<br>
     *                   utf-8	返回 utf-8 编码的内容
     *                   gbk	返回 gbk 编码的内容。不支持与异步函数同用
     *                   其他	返回 utf-8 编码的内容
     * @param callback   调用的异步函数<br>
     *                   如： moe
     * @param select     选择器。配合 encode=js 使用<br>
     *                   默认：.hitokoto
     * @param min_length 返回句子的最小长度（包含）<br>
     *                   默认：0
     * @param max_length 返回句子的最大长度（包含）<br>
     *                   默认：30
     * @return {@link Data}
     */
    public static Data get(char type, String encode, String charset, String callback, String select, int min_length, int max_length) {
        StringBuilder sb = new StringBuilder(ApiV1);
        sb.append("/?");
        if (type >= 97 && type <= 108) sb.append("c=").append(type);
        if (encode != null && encode.equals("js")) {
            sb.append("&encode=").append(encode);
            if (select != null) sb.append("&select=").append(select);
        }
        if (charset != null && charset.equals("gbk")) sb.append("&charset=").append(charset);
        if (callback != null) sb.append("&callback=").append(callback);
        if (min_length > 0 && min_length < 30) sb.append("&min_length=").append(min_length);
        if (max_length > 0 && max_length < 30) sb.append("&max_length=").append(max_length);
        String jsonString = Http.get(sb.toString());
        return JSON.parseObject(jsonString, Data.class);
    }

    /**
     * @param type {@link #get}
     * @return {@link Data}
     */
    public static Data simpleGet(char type) {
        StringBuilder sb = new StringBuilder(ApiV1);
        if (type >= 97 && type <= 108) sb.append("/?c=").append(type);
        String jsonString = Http.get(sb.toString());
        return JSON.parseObject(jsonString, Data.class);
    }

    /**
     * @param type {@link #get}
     * @return {@link Data}
     */
    public static String simpleGetText(char type) {
        StringBuilder sb = new StringBuilder(ApiV1);
        sb.append("/?encode=text");
        if (type >= 97 && type <= 108) sb.append("&c=").append(type);
        return Http.get(sb.toString());
    }
}
