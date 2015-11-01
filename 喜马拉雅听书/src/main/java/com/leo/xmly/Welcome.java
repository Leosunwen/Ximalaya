package com.leo.xmly;

import com.leo.xmly.config.AllUrlPath;
import com.leo.xmly.json.JsonParseWelcome;
import com.leo.xmly.util.L;
import com.leo.xmly.util.T;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * 进入app的欢迎页面
 * 
 * @author Leo
 *
 */
public class Welcome extends Activity {

	// xUtil关联控件
	@ViewInject(R.id.imageview_welcome)
	private ImageView img_wel = null;

	private Handler handler = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		// 指定 @ViewInject 在哪个布局中找
		ViewUtils.inject(this);
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, AllUrlPath.WELCOMEPATH, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				L.i("下载失败");
				T.showShort(getApplicationContext(), "下载失败");
				enterMainActivity();
			}

			@Override
			public void onSuccess(ResponseInfo<String> str) {

				L.i(str.result);
				String cover = JsonParseWelcome.parseJson(str.result);
				BitmapUtils bit = new BitmapUtils(getApplicationContext());
				img_wel.setScaleType(ScaleType.FIT_XY);
				bit.display(img_wel, cover);
				// 设置延迟3秒进入主页面(MainActivity)
				handler = new Handler();
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						enterMainActivity();
					}
				}, 3000);
			}

			private void enterMainActivity() {
				Intent intent = new Intent(Welcome.this, MainActivity.class);
				startActivity(intent);
				finish();
			}

		});
		BitmapUtils bitmapUtils = new BitmapUtils(getApplicationContext());
		bitmapUtils.display(img_wel, "");
	}
}
