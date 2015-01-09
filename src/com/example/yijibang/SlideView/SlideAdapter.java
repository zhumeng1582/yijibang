package com.example.yijibang.SlideView;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yijibang.R;
import com.example.yijibang.SlideView.SlideView.OnSlideListener;

public class SlideAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    
    private List<MessageItem> mMessageItems = new ArrayList<MessageItem>();
    
    private Context mContext;

    public SlideAdapter(Context mContext,List<MessageItem> mMessageItems2) {
        super();
        this.mContext = mContext;
        this.mMessageItems = mMessageItems2;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mMessageItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mMessageItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        SlideView slideView = (SlideView) convertView;
        if (slideView == null) {
            View itemView = mInflater.inflate(R.layout.list_item, null);

            slideView = new SlideView(mContext);
            slideView.setContentView(itemView);

            holder = new ViewHolder(slideView);
            slideView.setOnSlideListener(new OnSlideListener() {
				
				@Override
				public void onSlide(View view, int status) {
					// TODO 自动生成的方法存根
					
				}
			});
            slideView.setTag(holder);
        } else {
            holder = (ViewHolder) slideView.getTag();
        }
        MessageItem item = mMessageItems.get(position);
        item.slideView = slideView;
        item.slideView.shrink();

        holder.tvTitle1.setText(item.tvTitle1);
        holder.listview_item_name.setText(item.listview_item_name);
        holder.deleteHolder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(mContext, "sdf", Toast.LENGTH_SHORT).show();
				
			}
		});

        return slideView;
    }
    
    private static class ViewHolder {
        
        public TextView tvTitle1;
        public TextView listview_item_name;
        public ViewGroup deleteHolder;

        ViewHolder(View view) {
            
            tvTitle1 = (TextView) view.findViewById(R.id.tvTitle1);
            listview_item_name = (TextView) view.findViewById(R.id.listview_item_name);
            deleteHolder = (ViewGroup)view.findViewById(R.id.holder);
        }
    }

}