package com.leo.xmly.adapter;

import java.util.ArrayList;
import java.util.List;

import com.leo.xmly.R;
import com.leo.xmly.bean.Type1XBTJ1;
import com.leo.xmly.bean.Type2JPTD1;
import com.leo.xmly.bean.Type2JPTD2;
import com.leo.xmly.bean.Type3FXXQ1;
import com.leo.xmly.bean.Type3FXXQ2;
import com.leo.xmly.bean.Type4RMZB;
import com.leo.xmly.config.AllListType;
import com.leo.xmly.interf.ListTypeInterf;
import com.leo.xmly.util.GetListViewHeight;
import com.leo.xmly.util.L;
import com.leo.xmly.viewholder.ViewHolder1XBTJ;
import com.leo.xmly.viewholder.ViewHolder4RMZB;
import com.lidroid.xutils.BitmapUtils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FindListViewAdapter extends BaseAdapter {
	private Context context = null;
	private List<ListTypeInterf> list = null;
	private BitmapUtils bitmapUtils = null;

	public FindListViewAdapter(Context context) {
		super();
		this.context = context;
		list = new ArrayList<ListTypeInterf>();
		bitmapUtils = new BitmapUtils(context);
	}

	public void setData(List<ListTypeInterf> list) {
		this.list.addAll(list);
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		return list.get(position).getType();
	}

	@Override
	public int getViewTypeCount() {
		return AllListType.TYPECOUNT;
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

	/**
	 * 变数量的条目添加到listview中
	 * 
	 * @author Leo
	 *
	 */
	class ViewHolderListView2 {
		TextView textview_type2_title1;
		ListView listview_changitem2;
	}

	class ViewHolderListView3 {
		TextView textview_type3_title1;
		ListView listview_changitem3;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 定义viewholder
		ViewHolder1XBTJ v1 = null;
		ViewHolder4RMZB v4 = null;
		ViewHolderListView2 vlv2 = null;
		ViewHolderListView3 vlv3 = null;
		if (convertView == null) {
			L.i("条目类型" + getItemViewType(position));
			switch (getItemViewType(position)) {
			case 0:
				// 小编推荐类型
				v1 = new ViewHolder1XBTJ();
				convertView = LayoutInflater.from(context).inflate(R.layout.type1layout, null);
				v1.textview_type1_title1 = (TextView) convertView.findViewById(R.id.textview_type1_title1);

				v1.imageview_type1_img1 = (ImageView) convertView.findViewById(R.id.imageview_type1_img1);
				v1.imageview_type1_img2 = (ImageView) convertView.findViewById(R.id.imageview_type1_img2);
				v1.imageview_type1_img3 = (ImageView) convertView.findViewById(R.id.imageview_type1_img3);

				v1.textview_type1_t1 = (TextView) convertView.findViewById(R.id.textview_type1_t1);
				v1.textview_type1_t2 = (TextView) convertView.findViewById(R.id.textview_type1_t2);
				v1.textview_type1_t3 = (TextView) convertView.findViewById(R.id.textview_type1_t3);

				v1.textview_type1_trackTitle1 = (TextView) convertView.findViewById(R.id.textview_type1_trackTitle1);
				v1.textview_type1_trackTitle2 = (TextView) convertView.findViewById(R.id.textview_type1_trackTitle2);
				v1.textview_type1_trackTitle3 = (TextView) convertView.findViewById(R.id.textview_type1_trackTitle3);
				convertView.setTag(v1);
				break;
			case 1:
				// 精品听单类型
				vlv2 = new ViewHolderListView2();
				convertView = LayoutInflater.from(context).inflate(R.layout.type2listview, null);
				vlv2.textview_type2_title1 = (TextView) convertView.findViewById(R.id.textview_type2_title1);
				vlv2.listview_changitem2 = (ListView) convertView.findViewById(R.id.listview_changitem2);
				convertView.setTag(vlv2);
				break;
			case 2:
				vlv3 = new ViewHolderListView3();
				convertView = LayoutInflater.from(context).inflate(R.layout.type3listview, null);
				vlv3.textview_type3_title1 = (TextView) convertView.findViewById(R.id.textview_type3_title1);
				vlv3.listview_changitem3 = (ListView) convertView.findViewById(R.id.listview_changitem3);
				convertView.setTag(vlv3);
				break;
			case 3:
				v4 = new ViewHolder4RMZB();
				convertView = LayoutInflater.from(context).inflate(R.layout.type4layout, null);
				v4.imageview_type4_image2 = (ImageView) convertView.findViewById(R.id.imageview_type4_image2);
				v4.textview_type4_title2 = (TextView) convertView.findViewById(R.id.textview_type4_title2);
				convertView.setTag(v4);
				break;

			default:
				break;
			}
		} else {
			switch (getItemViewType(position)) {
			case 0:
				v1 = (ViewHolder1XBTJ) convertView.getTag();
				break;
			case 1:
				vlv2 = (ViewHolderListView2) convertView.getTag();
				break;
			case 2:
				vlv3 = (ViewHolderListView3) convertView.getTag();
				break;
			case 3:
				v4 = (ViewHolder4RMZB) convertView.getTag();
				break;

			default:
				break;
			}
		}

		switch (getItemViewType(position)) {
		case 0:
			L.i(((Type1XBTJ1) list.get(position)).getList().get(0).getCoverLarge());
			v1.textview_type1_title1.setText(((Type1XBTJ1) list.get(position)).getTitle());
			bitmapUtils.display(v1.imageview_type1_img1,
					((Type1XBTJ1) list.get(position)).getList().get(0).getCoverLarge());
			v1.textview_type1_t1.setText(((Type1XBTJ1) list.get(position)).getList().get(0).getTitle());
			v1.textview_type1_trackTitle1.setText(((Type1XBTJ1) list.get(position)).getList().get(0).getTrackTitle());

			bitmapUtils.display(v1.imageview_type1_img2,
					((Type1XBTJ1) list.get(position)).getList().get(1).getCoverLarge());
			v1.textview_type1_t2.setText(((Type1XBTJ1) list.get(position)).getList().get(1).getTitle());
			v1.textview_type1_trackTitle2.setText(((Type1XBTJ1) list.get(position)).getList().get(1).getTrackTitle());

			bitmapUtils.display(v1.imageview_type1_img3,
					((Type1XBTJ1) list.get(position)).getList().get(2).getCoverLarge());
			v1.textview_type1_t3.setText(((Type1XBTJ1) list.get(position)).getList().get(2).getTitle());
			v1.textview_type1_trackTitle3.setText(((Type1XBTJ1) list.get(position)).getList().get(2).getTrackTitle());
			break;
		case 1:
			vlv2.textview_type2_title1.setText(((Type2JPTD1) list.get(position)).getTitle());
			List<Type2JPTD2> listJptd = ((Type2JPTD1) list.get(position)).getList();
			InnerChangAdapterType2 adapter2 = new InnerChangAdapterType2(context, vlv2.listview_changitem2);
			adapter2.setData(listJptd);
			// 动态设置listview的宽度
			vlv2.listview_changitem2.setAdapter(adapter2);
			GetListViewHeight.setListViewHeightBasedOnChildren(vlv2.listview_changitem2);
			break;
		case 2:
			L.i(((Type3FXXQ1) list.get(position)).getTitle() + "标题");
			vlv3.textview_type3_title1.setText(((Type3FXXQ1) list.get(position)).getTitle());
			List<Type3FXXQ2> listFxxq = ((Type3FXXQ1) list.get(position)).getList();
			InnerChangAdapterType3 adapter3 = new InnerChangAdapterType3(context, vlv3.listview_changitem3);
			adapter3.setData(listFxxq);
			vlv3.listview_changitem3.setAdapter(adapter3);
			GetListViewHeight.setListViewHeightBasedOnChildren(vlv3.listview_changitem3);
			break;
		case 3:
			L.i("设置组件");
			if ("".equals((((Type4RMZB) list.get(position)).getCoverPath()))) {
				v4.imageview_type4_image2.setImageResource(R.drawable.category_more);
			} else {
				bitmapUtils.display(v4.imageview_type4_image2, (((Type4RMZB) list.get(position)).getCoverPath()));
			}
			v4.textview_type4_title2.setText(((Type4RMZB) list.get(position)).getTitle());
			break;

		default:
			break;
		}
		return convertView;
	}

}
