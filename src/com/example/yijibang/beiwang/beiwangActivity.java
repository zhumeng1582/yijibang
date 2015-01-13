package com.example.yijibang.beiwang;

import java.util.ArrayList;
import java.util.List;

import com.example.yijibang.R;


import com.example.yijibang.SlideView.ListViewCompat;
import com.example.yijibang.SlideView.MessageItem;
import com.example.yijibang.SlideView.SlideAdapter;
import com.example.yijibang.jizhang.jizhangActivity;
import com.example.yijibang.jizhang.tianjiajizhangActivity;
import com.example.yijibang.sqliteDataBase.Model.Memo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class beiwangActivity extends Activity {
	
	private GridView gridViewUnforget;
	private RelativeLayout relativieLayoutTianJiaBeiWang;

	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_beiwang);
		
		relativieLayoutTianJiaBeiWang = (RelativeLayout) findViewById(R.id.relativieLayoutTianJiaBeiWang);
		relativieLayoutTianJiaBeiWang.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(beiwangActivity.this,tianjiabeiwangActivity.class);
				startActivity(i);
				
			}
		});
		
		
		
		gridViewUnforget = (GridView) findViewById(R.id.gridViewUnforget);
		View emptyView = findViewById(R.id.empty);
		
		gridViewUnforget.setEmptyView(emptyView);
		
		
		List<Memo> array = new ArrayList<Memo>();
		
		array.add(new Memo("1111","同学婚礼(已过期)","2015-01-09 12:00","XXXXXX",R.color.red));
		array.add(new Memo("1111","老婆生日送礼物","2015-01-09 12:00","XXXXXX",R.color.shen));
		array.add(new Memo("1111","给老妈打电话","2015-01-09 12:00","XXXXXX",R.color.shen));
		array.add(new Memo("1111","帮小六接他母亲","2015-01-09 12:00","XXXXXX",R.color.shen));
		array.add(new Memo("1111","联系陈总吃饭","2015-01-09 12:00","XXXXXX",R.color.shen));
		
		MemoAdapter memoAdapter= new MemoAdapter(this, array );
		
		gridViewUnforget.setAdapter(memoAdapter);
		
		gridViewUnforget.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(beiwangActivity.this, "", Toast.LENGTH_SHORT).show();
			}
		});
		
		
	}
	
	

}
