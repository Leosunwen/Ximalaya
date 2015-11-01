package com.leo.xmly.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.leo.xmly.R;
import com.leo.xmly.adapter.FindListViewAdapter;
import com.leo.xmly.bean.TypeRecomAd;
import com.leo.xmly.config.AllUrlPath;
import com.leo.xmly.interf.ListTypeInterf;
import com.leo.xmly.json.JsonParseFirstListView;
import com.leo.xmly.json.JsonParseFirstViewPager;
import com.leo.xmly.json.JsonParseRecomAd;
import com.leo.xmly.util.L;
import com.leo.xmly.util.T;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {

    private ListView listview_find_all = null;
    private ViewPager viewPagerUp = null;
    private ViewPager viewPagerDown = null;
    private PagerAdapter pagerAdapter = null;
    private List<ListTypeInterf> listFindAll;
    private HttpUtils util = null;
    private LinearLayout linear_find_point_up = null;
    private LinearLayout linear_find_point_down = null;
    private int lastPointUp = 0;
    private int lastPointDown = 0;


    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.find, null);
        listview_find_all = (ListView) view.findViewById(R.id.listview_find_all);
        View viewHeadView = LayoutInflater.from(getActivity()).inflate(R.layout.findviewpagerup, null);
        viewPagerUp = (ViewPager) viewHeadView.findViewById(R.id.viewpager_find_up);
        linear_find_point_up = (LinearLayout) viewHeadView.findViewById(R.id.linear_find_point_up);
        // 设置listview的Footer的viewpager
        View viewFooterView = LayoutInflater.from(getActivity()).inflate(R.layout.findviewpagerdown, null);
        linear_find_point_down = (LinearLayout) viewFooterView.findViewById(R.id.linear_find_point_down);
        viewPagerDown = (ViewPager) viewFooterView.findViewById(R.id.viewpager_find_down);
        listview_find_all.addHeaderView(viewHeadView);
        listview_find_all.addFooterView(viewFooterView);
        // 下载首页的所有的数据
        util = new HttpUtils();
        util.send(HttpMethod.GET, AllUrlPath.FindPageAllData, new RequestCallBack<String>() {

            private List<ImageView> listImage;

            @Override
            public void onFailure(HttpException arg0, String arg1) {
                T.showShort(getActivity(), "下载失败");
            }


            @Override
            public void onSuccess(ResponseInfo<String> arg0) {
                String json = arg0.result;
                L.i(json);
                List<String> listPath = JsonParseFirstViewPager.parseJson(json);
                L.i(listPath.size() + "");
                BitmapUtils bitmapUtils = new BitmapUtils(getActivity());
                listImage = new ArrayList<ImageView>();
                for (int i = 0; i < listPath.size(); i++) {
                    L.i("下载图片");
                    ImageView imageView = new ImageView(getActivity());
                    bitmapUtils.display(imageView, listPath.get(i));
                    imageView.setScaleType(ScaleType.FIT_XY);
                    listImage.add(imageView);

                    // 动态添加点
                    ImageView point = new ImageView(getActivity());
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMarginEnd(30);
                    point.setLayoutParams(params);
                    point.setBackgroundResource(R.drawable.point_bg);
                    if (0 == i) {
                        point.setEnabled(true);
                    } else {
                        point.setEnabled(false);
                    }
                    linear_find_point_up.addView(point);
                }
                pagerAdapter = new PagerAdapter() {

                    @Override
                    public boolean isViewFromObject(View view, Object object) {
                        return view == object;
                    }

                    @Override
                    public int getCount() {
                        return listImage.size();
                    }

                    @Override
                    public Object instantiateItem(ViewGroup container, int position) {
                        container.addView(listImage.get(position));
                        return listImage.get(position);
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position, Object object) {
                        container.removeView(listImage.get(position));
                    }
                };
                // viewpager滑动的监听事件
                viewPagerUp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        linear_find_point_up.getChildAt(position).setEnabled(true);
                        linear_find_point_up.getChildAt(lastPointUp).setEnabled(false);
                        lastPointUp = position;
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

                viewPagerUp.setAdapter(pagerAdapter);

                listFindAll = JsonParseFirstListView.parseJson(arg0.result);

                L.i("listFindAll" + listFindAll.toString());
                FindListViewAdapter adapter = new FindListViewAdapter(getActivity());
                L.i("适配器添加数据");
                adapter.setData(listFindAll);
                L.i("添加适配器");
                listview_find_all.setAdapter(adapter);
            }
        });

        util.send(HttpMethod.GET, AllUrlPath.FindPageAd, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json = responseInfo.result;
                List<TypeRecomAd> list = JsonParseRecomAd.parseJson(json);
                final List<ImageView> listImage = new ArrayList<ImageView>();
                BitmapUtils bitmap = new BitmapUtils(getActivity());
                for (int i = 0; i < list.size(); i++) {
                    ImageView iv = new ImageView(getActivity());
                    bitmap.display(iv, list.get(i).getCover());
                    iv.setScaleType(ScaleType.FIT_XY);
                    listImage.add(iv);

                    // 动态添加点
                    ImageView point = new ImageView(getActivity());
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMarginEnd(30);
                    point.setLayoutParams(params);
                    point.setBackgroundResource(R.drawable.point_bg);
                    if (0 == i) {
                        point.setEnabled(true);
                    } else {
                        point.setEnabled(false);
                    }
                    linear_find_point_down.addView(point);
                }

                pagerAdapter = new PagerAdapter() {
                    @Override
                    public int getCount() {
                        return listImage.size();
                    }

                    @Override
                    public boolean isViewFromObject(View view, Object object) {
                        return view == object;
                    }

                    @Override
                    public Object instantiateItem(ViewGroup container, int position) {
                        container.addView(listImage.get(position));
                        return listImage.get(position);
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position, Object object) {
                        container.removeView(listImage.get(position));
                    }
                };


                // viewpager滑动的监听事件
                viewPagerDown.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        linear_find_point_down.getChildAt(position).setEnabled(true);
                        linear_find_point_down.getChildAt(lastPointDown).setEnabled(false);
                        lastPointDown = position;
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });


                viewPagerDown.setAdapter(pagerAdapter);

            }

            @Override
            public void onFailure(HttpException e, String s) {
                L.i("广告下载失败");
            }
        });

        return view;
    }

}
