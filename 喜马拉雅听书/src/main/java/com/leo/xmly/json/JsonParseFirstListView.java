package com.leo.xmly.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.leo.xmly.bean.Type1XBTJ1;
import com.leo.xmly.bean.Type1XBTJ2;
import com.leo.xmly.bean.Type2JPTD1;
import com.leo.xmly.bean.Type2JPTD2;
import com.leo.xmly.bean.Type3FXXQ1;
import com.leo.xmly.bean.Type3FXXQ2;
import com.leo.xmly.bean.Type4RMZB;
import com.leo.xmly.interf.ListTypeInterf;
import com.leo.xmly.util.L;

/**
 * 首页listview的json的解析
 *
 * @author Leo
 */
public class JsonParseFirstListView {
    public static List<ListTypeInterf> parseJson(String json) {
        try {
            JSONObject obj1 = new JSONObject(json);
            List<ListTypeInterf> listAll = new ArrayList<ListTypeInterf>();

            // 小编推荐(类型1)
            JSONObject objxb1 = obj1.getJSONObject("editorRecommendAlbums");
            Type1XBTJ1 typexb1 = new Type1XBTJ1();
            typexb1.setTitle(objxb1.getString("title"));
            JSONArray arrxb1 = objxb1.getJSONArray("list");
            List<Type1XBTJ2> listXb1 = new ArrayList<Type1XBTJ2>();
            for (int i = 0; i < arrxb1.length(); i++) {
                Type1XBTJ2 typexb2 = new Type1XBTJ2();
                JSONObject objxb2 = arrxb1.getJSONObject(i);
                typexb2.setTitle(objxb2.getString("title"));
                typexb2.setTrackTitle(objxb2.getString("trackTitle"));
                typexb2.setCoverLarge(objxb2.getString("coverLarge"));
                listXb1.add(typexb2);
            }
            typexb1.setList(listXb1);
            listAll.add(typexb1);

            // 精品听单(类型2)
            JSONObject objjp1 = obj1.getJSONObject("specialColumn");
            Type2JPTD1 typejp1 = new Type2JPTD1();
            typejp1.setTitle(objjp1.getString("title"));
            List<Type2JPTD2> listjp2 = new ArrayList<Type2JPTD2>();
            JSONArray arrjp1 = objjp1.getJSONArray("list");
            for (int i = 0; i < arrjp1.length(); i++) {
                Type2JPTD2 typejp2 = new Type2JPTD2();
                JSONObject objjp2 = arrjp1.getJSONObject(i);
                typejp2.setTitle(objjp2.getString("title"));
                typejp2.setSubtitle(objjp2.getString("subtitle"));
                typejp2.setFootnote(objjp2.getString("footnote"));
                typejp2.setCoverPath(objjp2.getString("coverPath"));
                listjp2.add(typejp2);
            }
            typejp1.setList(listjp2);
            listAll.add(typejp1);

            // 发现新奇(类型3)

            JSONObject objfx1 = obj1.getJSONObject("discoveryColumns");
            Type3FXXQ1 typefx1 = new Type3FXXQ1();
            typefx1.setTitle(objfx1.getString("title"));
            JSONArray arrfx1 = objfx1.getJSONArray("list");
            List<Type3FXXQ2> listFx = new ArrayList<Type3FXXQ2>();
            for (int i = 0; i < arrfx1.length(); i++) {
                Type3FXXQ2 typefx2 = new Type3FXXQ2();
                JSONObject objfx2 = arrfx1.getJSONObject(i);
                typefx2.setTitle(objfx2.getString("title"));
                typefx2.setSubtitle(objfx2.getString("subtitle"));
                typefx2.setCoverPath(objfx2.getString("coverPath"));
                listFx.add(typefx2);
            }
            typefx1.setList(listFx);
            listAll.add(typefx1);

            // 热门推荐(类型1)
            JSONObject objrm1 = obj1.getJSONObject("hotRecommends");
            JSONArray arrrm1 = objrm1.getJSONArray("list");
            for (int i = 0; i < arrrm1.length(); i++) {
                JSONObject objrm2 = arrrm1.getJSONObject(i);
                Type1XBTJ1 typerm1 = new Type1XBTJ1();
                typerm1.setTitle(objrm2.getString("title"));
                List<Type1XBTJ2> listRm2 = new ArrayList<Type1XBTJ2>();
                JSONArray arrrm2 = objrm2.getJSONArray("list");
                for (int j = 0; j < arrrm2.length(); j++) {
                    JSONObject objrm3 = arrrm2.getJSONObject(j);
                    Type1XBTJ2 typerm2 = new Type1XBTJ2();
                    typerm2.setTitle(objrm3.getString("title"));
                    typerm2.setTrackTitle(objrm3.getString("trackTitle"));
                    typerm2.setCoverLarge(objrm3.getString("coverLarge"));
                    listRm2.add(typerm2);
                }
                typerm1.setList(listRm2);
                listAll.add(typerm1);
            }

            // 手动添加"查看更多分类"
            Type4RMZB type41 = new Type4RMZB();
            type41.setTitle("查看更多分类");
            type41.setCoverPath("");
            listAll.add(type41);

            // 热门直播(类型4)

            JSONObject objzb1 = obj1.getJSONObject("entrances");
            JSONArray arrzb1 = objzb1.getJSONArray("list");
            for (int i = 0; i < arrzb1.length(); i++) {
                Type4RMZB type42 = new Type4RMZB();
                JSONObject objzb2 = arrzb1.getJSONObject(i);
                type42.setTitle(objzb2.getString("title"));
                type42.setCoverPath(objzb2.getString("coverPath"));
                listAll.add(type42);
            }
            L.i(listAll.toString());

            return listAll;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
