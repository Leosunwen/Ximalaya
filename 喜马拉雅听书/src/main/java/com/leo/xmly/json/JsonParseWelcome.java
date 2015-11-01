package com.leo.xmly.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 解析app欢迎页的图片
 * 
 * @author Leo
 *
 */
public class JsonParseWelcome {
	public static String parseJson(String json) {
		try {
			JSONObject obj1 = new JSONObject(json);
			JSONArray arr1 = obj1.getJSONArray("data");
			JSONObject obj2 = arr1.getJSONObject(0);
			return obj2.getString("cover");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
