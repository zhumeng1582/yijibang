package com.example.yijibang.mima;

import java.util.ArrayList;
import java.util.List;

import com.example.yijibang.R;
import com.example.yijibang.beiwang.MemoAdapter;
import com.example.yijibang.jizhang.jizhangActivity;
import com.example.yijibang.jizhang.tianjiajizhangActivity;
import com.example.yijibang.sqliteDataBase.Model.Memo;
import com.example.yijibang.sqliteDataBase.Model.SecretCode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class mimaActivity extends Activity {

	private GridView gridViewUnforget;
	private RelativeLayout relativieLayout3;
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mima);
		
		relativieLayout3 = (RelativeLayout) findViewById(R.id.relativieLayout3);
		relativieLayout3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(mimaActivity.this,tianjiamimaActivity.class);
				startActivity(i);
			}
		});
		
		gridViewUnforget = (GridView) findViewById(R.id.gridViewUnforget);
		View emptyView = findViewById(R.id.empty);
		
		gridViewUnforget.setEmptyView(emptyView);
		
		gridViewUnforget.setEmptyView(emptyView);
		
		
		final List<SecretCode> array = new ArrayList<SecretCode>();
		
		array.add(new SecretCode("1111","QQ","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","Œ¢≤©","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","ÃÏ√®","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","Œ¢–≈","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","ª®∞Í","2015-01-09 12:00","XXXXXX", null));
		
		final SecretCodeAdapter SecretCodeAdapter= new SecretCodeAdapter(this, array );
		
		gridViewUnforget.setAdapter(SecretCodeAdapter);
		gridViewUnforget.setOnItemClickListener(new OnItemClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				array.clear();
				
				array.add(new SecretCode("1111","QQ","2015-01-09 12:00","XXXXXX", null));
				array.add(new SecretCode("1111","Œ¢≤©","2015-01-09 12:00","XXXXXX", null));
				array.add(new SecretCode("1111","ÃÏ√®","2015-01-09 12:00","XXXXXX", null));
				array.add(new SecretCode("1111","Œ¢–≈","2015-01-09 12:00","XXXXXX", null));
				array.add(new SecretCode("1111","ª®∞Í","2015-01-09 12:00","XXXXXX", null));
				
				SecretCodeAdapter.notifyDataSetChanged();

			}
		});
		
		
	}

}
