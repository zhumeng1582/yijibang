package com.example.yijibang.jizhang.biaoqian;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.yijibang.R;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AppAdapter extends BaseAdapter {
	private List<Map> mList;
	private Context mContext;
	public static final int APP_PAGE_SIZE = 8;
	private PackageManager pm;
	
	public AppAdapter(Context context, List<Map> list, int page) {
		mContext = context;
		pm = context.getPackageManager();
		
		mList = new ArrayList<Map>();
		int i = page * APP_PAGE_SIZE;
		int iEnd = i+APP_PAGE_SIZE;
		while ((i<list.size()) && (i<iEnd)) {
			mList.add(list.get(i));
			i++;
		}
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Map appInfo = mList.get(position);
		AppItem appItem;
		if (convertView == null) {
			View v = LayoutInflater.from(mContext).inflate(R.layout.app_item, null);
			
			appItem = new AppItem();
			//appItem.mAppIcon = (ImageView)v.findViewById(R.id.imgdetail);
			appItem.mAppName = (Button)v.findViewById(R.id.tuaninfo);
			
			v.setTag(appItem);
			convertView = v;
		} else {
			appItem = (AppItem)convertView.getTag();
		}
		// set the icon
		//appItem.mAppIcon.setImageResource(R.drawable.icon);
		// set the app name
		appItem.mAppName.setText(appInfo.get("name").toString());
		
		return convertView;
	}

	/**
	 * 每个应用显示的内容，包括图标和名�?	 * @author Yao.GUET
	 *
	 */
	class AppItem {
		//ImageView mAppIcon;
		Button mAppName;
	}
}
