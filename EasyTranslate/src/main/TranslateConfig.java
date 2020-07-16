package main;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author:lezzy
 * @Date:2020/7/10 14:14
 */
public class TranslateConfig {
    private static final String PREFIX_URL = "http://api.fanyi.baidu.com/api/trans/vip/translate";
    private static final String APP_ID = "20200709000516036";
    private static final String PRIVATE_KEY = "hNQFaiU9AVC_Vk1KhKjC";

    /**
     * @param src  翻译源
     * @param from 被翻译语音
     * @param to   目标语言
     * @return
     */
    public static String getTranslateResult(String src, String from, String to) {
        Map<String, String> map = new LinkedHashMap<String, String>() {{
            put("q", src);
            put("from", from);
            put("to", to);
            put("appid", APP_ID);
            String salt = String.valueOf(System.currentTimeMillis());
            put("salt", salt);
            String sign = MD5.md5(APP_ID + src + salt + PRIVATE_KEY);
            put("sign", sign);
        }};
        String result = HttpGet.get(PREFIX_URL, map);
        String json = JSONObject.parseObject(result).getJSONArray("trans_result").getString(0);
        return JSONObject.parseObject(json).getString("dst");

    }
}
