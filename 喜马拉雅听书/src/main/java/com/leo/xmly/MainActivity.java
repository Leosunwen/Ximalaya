package com.leo.xmly;

import com.leo.xmly.fragment.GreatFragment;
import com.leo.xmly.util.L;
import com.leo.xmly.util.T;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * welcome之后的第一个页面
 * 
 * @author Leo
 *
 */
public class MainActivity extends FragmentActivity {

	@ViewInject(R.id.rg_main_comeon)
	private RadioGroup radioGroup = null;

	@ViewInject(R.id.rb_main_find)
	private RadioButton radioButtonFind = null;
	@ViewInject(R.id.relative_main)
	private RelativeLayout relative_main = null;
	// 管理碎片
	// private FragmentManager manager = null;

	private GreatFragment fragment = null;
	private GreatFragment sendFragment = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);

		supportFragmentManager = getSupportFragmentManager();

		// 获取fragment管理器
		// manager = getFragmentManager();

		// 默认加载"发现fragment"
		fragment = new GreatFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("code", 1);
		fragment.setArguments(bundle);
		supportFragmentManager.beginTransaction().replace(R.id.framelayout_main_container, fragment)
				.addToBackStack(null).commit();
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			private GreatFragment fragment = null;
			private Bundle bundle = null;

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				switch (checkedId) {

				case R.id.rb_main_find:
					relative_main.setVisibility(View.VISIBLE);
					fragment = new GreatFragment();
					bundle = new Bundle();
					bundle.putInt("code", 1);
					fragment.setArguments(bundle);
					sendFragment = fragment;
					break;
				case R.id.rb_main_custom:
					relative_main.setVisibility(View.GONE);
					fragment = new GreatFragment();
					bundle = new Bundle();
					bundle.putInt("code", 2);
					fragment.setArguments(bundle);
					sendFragment = fragment;
					break;
				case R.id.rb_main_download:
					relative_main.setVisibility(View.GONE);
					fragment = new GreatFragment();
					bundle = new Bundle();
					bundle.putInt("code", 3);
					fragment.setArguments(bundle);
					sendFragment = fragment;
					break;
				case R.id.rb_main_myself:
					relative_main.setVisibility(View.GONE);
					fragment = new GreatFragment();
					bundle = new Bundle();
					bundle.putInt("code", 4);
					fragment.setArguments(bundle);
					sendFragment = fragment;
					break;

				default:
					break;
				}
				// 链式编程 将碎片加入framelayout中去
				supportFragmentManager.beginTransaction().replace(R.id.framelayout_main_container, fragment)
						.addToBackStack(null).commit();
			}
		});

	}

	/**
	 * Find ---- 标题的点击事件(推荐 分类 直播......)回调到GreatFragment中执行
	 *
	 * @param view
	 */

	public void findTitleOnClick(View view) {
		// 转移点击事件到Fragment中执行
		L.i("FindTitleOnClick");
		if (fragment == null) {
			return;
		} else {
			fragment.findCallToFragment(view);
		}
	}

	/**
	 * Custom ---- 标题的点击事件(......)回调到GreatFragment中执行
	 *
	 * @param view
	 */
	public void customTitleOnClick(View view) {
		// 转移点击事件到Fragment中执行
		L.i("CustomTitleOnClick");
		if (sendFragment == null) {
			return;
		} else {
			sendFragment.customCallToFragment(view);
		}
	}

	// 以下是设置按两次根据时间退出(2s)
	private long exitTime = 0;

	private android.support.v4.app.FragmentManager supportFragmentManager;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exit();
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void exit() {
		if ((System.currentTimeMillis() - exitTime) > 2000) {
			T.showShort(getApplicationContext(), "再按一次退出程序");
			exitTime = System.currentTimeMillis();
		} else {
			finish();
			System.exit(0);
		}
	}
}
