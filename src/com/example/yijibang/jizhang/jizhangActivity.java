package com.example.yijibang.jizhang;

import com.example.yijibang.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class jizhangActivity extends Activity {
	
	private TextView  tVjiyibi;
	private RoundProgressBar roundProgressBarShouRu;
	private RoundProgressBar roundProgressBarZhiChu;
	private RoundProgressBar roundProgressBarJieYu;
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_jizhang);
		
		tVjiyibi = (TextView) findViewById(R.id.tVjiyibi);
		
		tVjiyibi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(jizhangActivity.this,jizhangmingxiActivity.class);
				startActivity(i);
			}
		});
		
		roundProgressBarShouRu = (RoundProgressBar) findViewById(R.id.roundProgressBarShouRu);
		roundProgressBarShouRu.setMax(8800);
		roundProgressBarShouRu.setProgress(8800);
		
		roundProgressBarZhiChu = (RoundProgressBar) findViewById(R.id.roundProgressBarZhiChu);
		roundProgressBarZhiChu.setMax(8800);
		roundProgressBarZhiChu.setProgress(2200);
		
		roundProgressBarJieYu = (RoundProgressBar) findViewById(R.id.roundProgressBarJieYu);
		roundProgressBarJieYu.setMax(8800);
		roundProgressBarJieYu.setProgress(6600);
		
	}
}
