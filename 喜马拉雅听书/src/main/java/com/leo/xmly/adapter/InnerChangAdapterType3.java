package com.leo.xmly.adapter;

import java.util.ArrayList;
import java.util.List;

import com.leo.xmly.R;
import com.leo.xmly.bean.Type2JPTD2;
import com.leo.xmly.bean.Type3FXXQ2;
import com.leo.xmly.util.GetListViewHeight;
import com.leo.xmly.util.L;
import com.leo.xmly.viewholder.ViewHolder3FXXQ;
import com.lidroid.xutils.BitmapUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class InnerChangAdapterType3 extends BaseAdapter {
	private Context context = null;
	private List<Type3FXXQ2> list = null;
	private BitmapUtils bitmapUtils = null;
	private ListView listview_changitem3 = null;

	public InnerChangAdapterType3(Context context, ListView listview_changitem3) {
		super();
		this.context = context;
		this.listview_changitem3 = listview_changitem3;
		list = new ArrayList<Type3FXXQ2>();
		bitmapUtils = new BitmapUtils(context);
	}

	public void setData(List<Type3FXXQ2> list) {
		this.list.addAll(list);
		notifyDataSetChanged();
		// 动态设置listview的宽度
		 GetListViewHeight.setListViewHeightBasedOnChildren(listview_changitem3);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder3FXXQ v3 = null;
		if (convertView == null) {
			L.i("ViewHolder3FXXQ" + "运行!@#*()");
			v3 = new ViewHolder3FXXQ();
			convertView = LayoutInflater.from(context).inflate(R.layout.type3layout, parent, false);
			v3.imageview_type3_image1 = (ImageView) convertView.findViewById(R.id.imageview_type3_image1);
			v3.textview_type3_title = (TextView) convertView.findViewById(R.id.textview_type3_title);
			v3.textview_type3_subtitle = (TextView) convertView.findViewById(R.id.textview_type3_subtitle);
			convertView.setTag(v3);
		} else {
			v3 = (ViewHolder3FXXQ) convertView.getTag();
		}

		bitmapUtils.display(v3.imageview_type3_image1, list.get(position).getCoverPath());
		v3.textview_type3_title.setText(list.get(position).getTitle());
		v3.textview_type3_subtitle.setText(list.get(position).getSubtitle());

		return convertView;
	}
}
