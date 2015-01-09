package com.example.yijibang.beiwang;

import java.util.ArrayList;
import java.util.List;

import com.example.yijibang.R;


import com.example.yijibang.SlideView.ListViewCompat;
import com.example.yijibang.SlideView.MessageItem;
import com.example.yijibang.SlideView.SlideAdapter;
import com.example.yijibang.sqliteDataBase.Model.Memo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;

public class beiwangActivity extends Activity {
	
	private GridView gridViewUnforget;

	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_beiwang);
		
		gridViewUnforget = (GridView) findViewById(R.id.gridViewUnforget);
		View emptyView = findViewById(R.id.empty);
		
		gridViewUnforget.setEmptyView(emptyView);
		
		
		List<Memo> array = new ArrayList<Memo>();
		
		array.add(new Memo("1111","同学婚礼(已过期)","2015-01-09 12:00","XXXXXX"));
		array.add(new Memo("1111","老婆生日送礼物","2015-01-09 12:00","XXXXXX"));
		array.add(new Memo("1111","给老妈打电话","2015-01-09 12:00","XXXXXX"));
		array.add(new Memo("1111","帮小六接他母亲","2015-01-09 12:00","XXXXXX"));
		array.add(new Memo("1111","联系陈总吃饭","2015-01-09 12:00","XXXXXX"));
		
		MemoAdapter memoAdapter= new MemoAdapter(this, array );
		
		gridViewUnforget.setAdapter(memoAdapter);
		
		
	}
	
	

}
