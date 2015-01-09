package com.example.yijibang.mima;

import java.util.ArrayList;
import java.util.List;

import com.example.yijibang.R;
import com.example.yijibang.beiwang.MemoAdapter;
import com.example.yijibang.sqliteDataBase.Model.Memo;
import com.example.yijibang.sqliteDataBase.Model.SecretCode;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;

public class mimaActivity extends Activity {

	private GridView gridViewUnforget;
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mima);
		
		gridViewUnforget = (GridView) findViewById(R.id.gridViewUnforget);
		View emptyView = findViewById(R.id.empty);
		
		gridViewUnforget.setEmptyView(emptyView);
		
		gridViewUnforget.setEmptyView(emptyView);
		
		
		List<SecretCode> array = new ArrayList<SecretCode>();
		
		array.add(new SecretCode("1111","QQ","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","Œ¢≤©","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","ÃÏ√®","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","Œ¢–≈","2015-01-09 12:00","XXXXXX", null));
		array.add(new SecretCode("1111","ª®∞Í","2015-01-09 12:00","XXXXXX", null));
		
		SecretCodeAdapter SecretCodeAdapter= new SecretCodeAdapter(this, array );
		
		gridViewUnforget.setAdapter(SecretCodeAdapter);
	}

}
