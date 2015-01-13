package com.example.yijibang.beiwang;

import java.util.List;

import com.example.yijibang.R;
import com.example.yijibang.SlideView.SlideView;
import com.example.yijibang.SlideView.SlideView.OnSlideListener;
import com.example.yijibang.sqliteDataBase.Model.Memo;







import android.R.color;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MemoAdapter1 extends BaseAdapter{ 
        
	private LayoutInflater mInflater;
	//上下文对象 
    private Context mContext; 
    //图片数组 
    private List<Memo> array;
    public  MemoAdapter1(Context context,List<Memo> array){ 
    	this.mContext = context;
    	this.array = array;
    	mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    } 
    public int getCount() { 
    	return array.size();
    }
    
    public Object getItem(int item) { 
    	return item; 
    } 
    
    public long getItemId(int id) { 
    	return id; 
    } 
         
        //创建View方法 
    public View getView(int position, View convertView, ViewGroup parent) { 
    	ViewHolder holder;
        SlideView slideView = (SlideView) convertView;
        if (slideView == null) {
            View itemView = mInflater.inflate(R.layout.view_memo, null);

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
        Memo modelMemo = array.get(position);
        modelMemo.slideView = slideView;
        modelMemo.slideView.shrink();
        

        holder.tvName.setText(modelMemo.getRemark());
        holder.tvName.setTextColor(mContext.getResources().getColor(modelMemo.getColor()));

        holder.tvTime.setText(modelMemo.getEventDate());
        holder.tvTime.setTextColor(mContext.getResources().getColor(modelMemo.getColor()));
        
        holder.deleteHolder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(mContext, "sdf", Toast.LENGTH_SHORT).show();
				
			}
		});

        return slideView;
    	
    	
    	
    	
//    	ViewHolder viewHolder = null; 
//    	
//        if (convertView == null) { 
//        	viewHolder = new ViewHolder();
//        	convertView = LayoutInflater.from(mContext).inflate(R.layout.view_memo, null);
//			viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvRemark);
//			viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tvEventDate);
//			convertView.setTag(viewHolder);
//			 
//        }  
//        else { 
//        	viewHolder = (ViewHolder) convertView.getTag();
//        } 
//
//        
//        Memo modelMemo = array.get(position);
//
//        viewHolder.tvName.setText(modelMemo.getRemark());
//        viewHolder.tvName.setTextColor(mContext.getResources().getColor(modelMemo.getColor()));
//
//        viewHolder.tvTime.setText(modelMemo.getEventDate());
//        viewHolder.tvTime.setTextColor(mContext.getResources().getColor(modelMemo.getColor()));
//        
//        return convertView; 
    } 
    
    final static class ViewHolder {
		public TextView tvName;
	    public TextView tvTime;
	    public ViewGroup deleteHolder;
		
	    ViewHolder(View view) {
            
	    	tvName = (TextView) view.findViewById(R.id.tvRemark);
            tvTime = (TextView) view.findViewById(R.id.tvEventDate);
            deleteHolder = (ViewGroup)view.findViewById(R.id.holder);
        }
        
		
	}
} 
