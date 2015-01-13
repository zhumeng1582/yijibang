package com.example.yijibang.jizhang.biaoqian;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.yijibang.R;
import com.example.yijibang.sqliteDataBase.Model.BiaoQian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AppAdapter extends BaseAdapter {
	private List<BiaoQian> mList;
	private Context mContext;
	public static final int APP_PAGE_SIZE = 8;
	private PackageManager pm;
	
	public AppAdapter(Context context, List<BiaoQian> list) {
		mContext = context;
		pm = context.getPackageManager();
		
		//mList = new ArrayList<Map>();
//		int i = page * APP_PAGE_SIZE;
//		int iEnd = i+APP_PAGE_SIZE;
//		while ((i<list.size()) && (i<iEnd)) {
//			mList.add(list.get(i));
//			i++;
//		}
		mList = list;
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

	@SuppressLint("NewApi")
	public View getView(final int position, View convertView, ViewGroup parent) {
		BiaoQian appInfo = mList.get(position);
		AppItem appItem;
		if (convertView == null) {
			View v = LayoutInflater.from(mContext).inflate(R.layout.app_item, null);
			
			appItem = new AppItem();
			appItem.mAppName = (TextView)v.findViewById(R.id.tuaninfo);
			
			v.setTag(appItem);
			convertView = v;
		} else {
			appItem = (AppItem)convertView.getTag();
		}

		appItem.mAppName.setText(appInfo.getText());
		
		Drawable drawable=mContext.getResources().getDrawable(appInfo.getBackGroundId());
		convertView.setBackground(drawable);
		return convertView;
	}

	/**
	 * 每个应用显示的内容，包括图标和名�?	 * @author Yao.GUET
	 *
	 */


	class AppItem {
		TextView mAppName;
	}
}
