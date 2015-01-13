package com.example.yijibang.mima;

import java.util.List;



import com.example.yijibang.R;
import com.example.yijibang.sqliteDataBase.Model.Memo;
import com.example.yijibang.sqliteDataBase.Model.SecretCode;



import android.R.color;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecretCodeAdapter extends BaseAdapter{ 
        //上下文对象 
        private Context context; 
        //图片数组 
        private List<SecretCode> array;

        public  SecretCodeAdapter(Context context,List<SecretCode> array){ 
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
	            	convertView = LayoutInflater.from(context).inflate(R.layout.view_secretcode, null);
	    			viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvRemark);
	    			
	    			convertView.setTag(viewHolder);
	    			
	    			
	            }  
	            else { 
	            	viewHolder = (ViewHolder) convertView.getTag();
	            } 
	            SecretCode secretCode = array.get(position);
	            
	            viewHolder.tvName.setText(secretCode.getRemark());
	            return convertView; 
	            
        }
        
        final static class ViewHolder {
        	TextView tvName;
    		
    	}
        
} 
