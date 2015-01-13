package com.example.yijibang.beiwang;

import java.util.List;

import com.example.yijibang.R;
import com.example.yijibang.sqliteDataBase.Model.Memo;



import android.R.color;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MemoAdapter extends BaseAdapter{ 
        //上下文对象 
        private Context context; 
        //图片数组 
        private List<Memo> array;

        public  MemoAdapter(Context context,List<Memo> array){ 
            this.context = context; 
            this.array = array;
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
    		ViewHolder viewHolder = null; 
        	
            if (convertView == null) { 
            	viewHolder = new ViewHolder();
            	convertView = LayoutInflater.from(context).inflate(R.layout.view_memo, null);
    			viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvRemark);
    			viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tvEventDate);
    			convertView.setTag(viewHolder);
    			 
            }  
            else { 
            	viewHolder = (ViewHolder) convertView.getTag();
            } 

            
            Memo modelMemo = array.get(position);

            viewHolder.tvName.setText(modelMemo.getRemark());
            viewHolder.tvName.setTextColor(context.getResources().getColor(modelMemo.getColor()));

            viewHolder.tvTime.setText(modelMemo.getEventDate());
            viewHolder.tvTime.setTextColor(context.getResources().getColor(modelMemo.getColor()));
            
            return convertView; 
        } 
        
        final static class ViewHolder {
        	TextView tvName;
    		TextView tvTime;
    		
    	}
} 
