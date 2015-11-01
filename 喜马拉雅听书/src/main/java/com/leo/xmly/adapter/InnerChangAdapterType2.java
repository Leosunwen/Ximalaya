package com.leo.xmly.adapter;

import java.util.ArrayList;
import java.util.List;

import com.leo.xmly.R;
import com.leo.xmly.bean.Type2JPTD2;
import com.leo.xmly.util.GetListViewHeight;
import com.leo.xmly.viewholder.ViewHolder2JPTD;
import com.lidroid.xutils.BitmapUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class InnerChangAdapterType2 extends BaseAdapter {
	private Context context;
	private List<Type2JPTD2> list = null;
	private BitmapUtils bitmapUtils = null;
	private ListView listview_changitem2 = null;

	public InnerChangAdapterType2(Context context, ListView listview_changitem2) {
		super();
		this.context = context;
		list = new ArrayList<Type2JPTD2>();
		this.listview_changitem2 = listview_changitem2;
		bitmapUtils = new BitmapUtils(context);
	}

	public void setData(List<Type2JPTD2> list) {
		this.list.addAll(list);
		notifyDataSetChanged();
		GetListViewHeight.setListViewHeightBasedOnChildren(listview_changitem2);
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
		ViewHolder2JPTD v2 = null;
		if (convertView == null) {
			v2 = new ViewHolder2JPTD();
			convertView = LayoutInflater.from(context).inflate(R.layout.type2layout, parent, false);
			v2.imageview_type2_image1 = (ImageView) convertView.findViewById(R.id.imageview_type2_image1);
			v2.textview_type2_title = (TextView) convertView.findViewById(R.id.textview_type2_title);
			v2.textview_type2_subtitle = (TextView) convertView.findViewById(R.id.textview_type2_subtitle);
			v2.textview_type2_num = (TextView) convertView.findViewById(R.id.textview_type2_num);
			convertView.setTag(v2);
		} else {
			v2 = (ViewHolder2JPTD) convertView.getTag();
		}

		bitmapUtils.display(v2.imageview_type2_image1, list.get(position).getCoverPath());
		v2.textview_type2_title.setText(list.get(position).getTitle());
		v2.textview_type2_subtitle.setText(list.get(position).getSubtitle());
		v2.textview_type2_num.setText(list.get(position).getFootnote());

		return convertView;
	}
}
