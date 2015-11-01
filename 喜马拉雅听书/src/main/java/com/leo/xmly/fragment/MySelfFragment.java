package com.leo.xmly.fragment;

import com.leo.xmly.util.L;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MySelfFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView tv = new TextView(getActivity());
		tv.setTextSize(40);
		tv.setTextColor(Color.GREEN);
		Bundle bundle = getArguments();
		String content = bundle.getString("content");
		tv.setText(content);
		L.i("执行了2");
		return tv;
	}
}
