package com.leo.xmly.json;

import com.leo.xmly.bean.TypeRecomAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面最下方的广告解析
 * Created by Leo on 2015/10/31.
 */
public class JsonParseRecomAd {
    public static List<TypeRecomAd> parseJson(String json) {
        try {
            JSONObject obj1 = new JSONObject(json);
            List<TypeRecomAd> list = new ArrayList<TypeRecomAd>();
            JSONArray arr1 = obj1.getJSONArray("data");
            for (int i = 0; i < arr1.length(); i++) {
                TypeRecomAd tp = new TypeRecomAd();
                JSONObject obj2 = arr1.getJSONObject(i);
                tp.setCover(obj2.getString("cover"));
                tp.setLink(obj2.getString("link"));
                list.add(tp);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
