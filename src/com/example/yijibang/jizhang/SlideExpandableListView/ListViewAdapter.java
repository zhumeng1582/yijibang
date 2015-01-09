package com.example.yijibang.jizhang.SlideExpandableListView;

import java.util.List;

import com.example.yijibang.R;
import com.example.yijibang.SlideView.ListViewCompat;
import com.example.yijibang.SlideView.MessageItem;
import com.example.yijibang.SlideView.SlideAdapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
public class ListViewAdapter extends BaseAdapter{
    
    private Context mContext;
    private List<SeletorDataInfo> roomList;
    private List<List<MessageItem>> allList;
    private LayoutInflater mInflater;
    private int mLcdWidth = 0;  
    private float mDensity = 0; 
    private final int itemWidth;
    
    public ListViewAdapter(Context mContext, List<SeletorDataInfo> roomList, List<List<MessageItem>> allList){
        this.mContext = mContext;
        this.roomList = roomList;
        this.allList = allList;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();  
        mLcdWidth = dm.widthPixels;  
        mDensity = dm.density; 
        //这里我每个列表项高度是61dp。
        itemWidth = (int) (61 * mDensity);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if(null == roomList)
            return 0;
        else {
            return roomList.size();
        }
    }

    @Override
    public SeletorDataInfo getItem(int position) {
        // TODO Auto-generated method stub
        if(null == roomList)
            return null;
        else {
            return roomList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
    	ViewHolder viewHolder = null;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.list_item_layout, null);

            viewHolder.name = (TextView) convertView
                    .findViewById(R.id.listview_item_name);
            
            viewHolder.lv = (ListViewCompat) convertView
                    .findViewById(R.id.listview_item_lv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SeletorDataInfo mSelfData = roomList.get(position);
        if (null != mSelfData) {
            viewHolder.name.setText(mSelfData.getName());
            
            viewHolder.lv.setAdapter(new SlideAdapter(mContext, allList.get(position)));

            //viewHolder.lv.setAdapter(new ItemAdapter(mContext, allList.get(position)));
        }
      //**********************************************************************************************************
        RelativeLayout footer = (RelativeLayout) convertView.findViewById(R.id.expandable); 
        //不明白为什么宽度被设成：屏宽减去10dp(mLcdWidth - 10 * mDensity)，不过不去深究这个，因为我们关心的是高度。
        int widthSpec = MeasureSpec.makeMeasureSpec((int) (mLcdWidth - 10 * mDensity), MeasureSpec.EXACTLY);
        //然后，调用measure()方法，宽度被设成上面的widthSpec，而高度传了个0，不过没有关系因为高度下面才会设置
        footer.measure(widthSpec, 0);  
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) footer.getLayoutParams();
        //在此设置高度为：该组(Group)的项目数 * 每一项的高度。
        //本来我参看的那篇博文用的是params.bottomMargin = -footer.getMeasuredHeight(); 
        //但我使用时取footer.getMeasuredHeight(); 总出问题，第一次取只有listView一项的高度，后面高度也不匹配
        //不知道是listView缓存机制带来的问题还是什么，这里如果知道没一个列表项的高度，照现在的写法也没有问题。
        params.height = (allList.get(position).size() * itemWidth);
        if(roomList.get(position).state == 0) {
            params.bottomMargin = - params.height;
            footer.setVisibility(View.GONE);
        } else {
            params.bottomMargin = 0;
            footer.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
    
    private class ViewHolder {
       
        TextView name;
        ListViewCompat lv;
    }

}
