package com.leo.xmly.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * 首页viewpager的解析方法
 * 
 * @author Leo
 *
 */
public class JsonParseFirstViewPager {
	public static List<String> parseJson(String json) {
		try {
			List<String> list = new ArrayList<String>();
			JSONObject obj1 = new JSONObject(json);
			JSONObject obj2 = obj1.getJSONObject("focusImages");
			JSONArray arr1 = obj2.getJSONArray("list");
			for (int i = 0; i < arr1.length(); i++) {
				JSONObject obj3 = arr1.getJSONObject(i);
				String pic = obj3.getString("pic");
				list.add(pic);
			}
			return list;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
