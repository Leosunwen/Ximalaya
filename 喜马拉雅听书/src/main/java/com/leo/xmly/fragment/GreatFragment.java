package com.leo.xmly.fragment;

import com.leo.xmly.R;
import com.leo.xmly.util.L;
import com.leo.xmly.view.MyTextView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 主要的fragment 下方的四个按钮按下时new GreatFragment();
 * 
 * @author Leo
 *
 */
public class GreatFragment extends Fragment {

	// 通过LayoutInflater的布局的view
	private View view = null;
	private FragmentPagerAdapter fragmentPagerAdapter = null;
	/**
	 * 发现页面的控件
	 */
	// 标题的父布局
	private LinearLayout linearlayout_find_title = null;
	// 每个条目对应一个fragment
	private MyTextView lastTvFind = null;
	private ViewPager viewpager_find_great;

	/**
	 * 定制听页面的控件
	 */
	// 标题的父布局
	private LinearLayout linearlayout_custom_title = null;
	// 每个条目对应一个fragment
	private MyTextView lastTvCustom = null;
	private ViewPager viewpager_custom_great = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Bundle bundle = getArguments();
		int code = bundle.getInt("code");
		switch (code) {
		case 1:
			view = doFindFragment();
			break;
		case 2:
			view = doCustomFragment();
			break;
		case 3:
			view = doDownLoadFragment();
			break;
		case 4:
			view = doMyFragment();
			break;
		default:
			break;
		}
		return view;
	}

	/**
	 * "我的"fragment的处理
	 */
	@SuppressLint("InflateParams")
	private View doMyFragment() {
		L.i("doMyFragment");
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_find, null);
		return view;
	}

	/**
	 * "下载听"fragment的处理
	 */
	@SuppressLint("InflateParams")
	private View doDownLoadFragment() {
		L.i("doDownLoadFragment");
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_download, null);
		return view;
	}

	/**
	 * "定制听"fragment的处理
	 */
	@SuppressLint("InflateParams")
	private View doCustomFragment() {
		L.i("doCustomFragment");
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_custom, null);
		linearlayout_custom_title = (LinearLayout) view.findViewById(R.id.linearlayout_custom_title);
		viewpager_custom_great = (ViewPager) view.findViewById(R.id.viewpager_custom_great);
		((MyTextView) (linearlayout_custom_title.getChildAt(0))).setTextColor(0xfff86442);
		((MyTextView) (linearlayout_custom_title.getChildAt(0))).setFlag(true);

		lastTvCustom = (MyTextView) (linearlayout_custom_title.getChildAt(0));

		fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {

			@Override
			public int getCount() {
				return linearlayout_custom_title.getChildCount();
			}

			@Override
			public android.support.v4.app.Fragment getItem(int position) {
				CustomFragment customFragment = new CustomFragment();
				Bundle bundle = new Bundle();
				bundle.putString("content", "Custom");
				customFragment.setArguments(bundle);
				return customFragment;
			}
		};

		// 主viewpager的滑动事件
		viewpager_custom_great.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				L.i("viewpager滑动了");
				((MyTextView) (linearlayout_custom_title.getChildAt(position))).setTextColor(0xfff86442);
				((MyTextView) (linearlayout_custom_title.getChildAt(position))).setFlag(true);
				lastTvCustom.setTextColor(0xff686868);
				lastTvCustom.setFlag(false);
				lastTvCustom = ((MyTextView) (linearlayout_custom_title.getChildAt(position)));
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
		viewpager_custom_great.setAdapter(fragmentPagerAdapter);

		return view;
	}

	/**
	 * "发现"fragment的处理
	 */
	@SuppressLint("InflateParams")
	private View doFindFragment() {

		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_find, null);
		linearlayout_find_title = (LinearLayout) view.findViewById(R.id.linearlayout_find_title);
		viewpager_find_great = (ViewPager) view.findViewById(R.id.viewpager_find_great);
		
		((MyTextView) (linearlayout_find_title.getChildAt(0))).setTextColor(0xfff86442);
		((MyTextView) (linearlayout_find_title.getChildAt(0))).setFlag(true);

		lastTvFind = (MyTextView) (linearlayout_find_title.getChildAt(0));

		fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {

			@Override
			public int getCount() {
				return linearlayout_find_title.getChildCount();
			}

			@Override
			public android.support.v4.app.Fragment getItem(int position) {
				FindFragment findFragment = new FindFragment();
				Bundle bundle = new Bundle();
				bundle.putString("content", "Find");
				findFragment.setArguments(bundle);
				L.i("执行了1");
				return findFragment;
			}
		};

		// 主viewpager的滑动事件
		viewpager_find_great.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				L.i("viewpager滑动了");
				((MyTextView) (linearlayout_find_title.getChildAt(position))).setTextColor(0xfff86442);
				((MyTextView) (linearlayout_find_title.getChildAt(position))).setFlag(true);
				lastTvFind.setTextColor(0xff686868);
				lastTvFind.setFlag(false);
				lastTvFind = ((MyTextView) (linearlayout_find_title.getChildAt(position)));
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
		viewpager_find_great.setAdapter(fragmentPagerAdapter);
		return view;
	}

	/**
	 * 回调实现在fragment----find中相应title(推荐 分类 直播)的点击事件
	 */
	public void findCallToFragment(View v) {
		L.i("findCallToFragment" + this.toString());
		int childClick = linearlayout_find_title.indexOfChild(v);
		L.i("childClick---" + childClick);
		L.i("childClick---" + v);
		L.i("childClick---" + linearlayout_find_title);
		for (int i = 0; i < linearlayout_find_title.getChildCount(); i++) {
			((MyTextView) (linearlayout_find_title.getChildAt(i))).setTextColor(0xff686868);
			((MyTextView) (linearlayout_find_title.getChildAt(i))).setFlag(false);
		}
		((MyTextView) (linearlayout_find_title.getChildAt(childClick))).setTextColor(0xfff86442);
		((MyTextView) (linearlayout_find_title.getChildAt(childClick))).setFlag(true);
		viewpager_find_great.setCurrentItem(childClick);
	}

	/**
	 * 回调实现在fragment----custom中相应title(关注 收藏 历史)的点击事件
	 */
	public void customCallToFragment(View view) {
		if (view == null) {
			L.i("空");
		} else {
			L.i("CustomCallToFragment");
			int childClick = linearlayout_custom_title.indexOfChild(view);
			for (int i = 0; i < linearlayout_custom_title.getChildCount(); i++) {
				((MyTextView) (linearlayout_custom_title.getChildAt(i))).setTextColor(0xff686868);
				((MyTextView) (linearlayout_custom_title.getChildAt(i))).setFlag(false);
			}
			((MyTextView) (linearlayout_custom_title.getChildAt(childClick))).setTextColor(0xfff86442);
			((MyTextView) (linearlayout_custom_title.getChildAt(childClick))).setFlag(true);
			viewpager_custom_great.setCurrentItem(childClick);

		}
	}
}
