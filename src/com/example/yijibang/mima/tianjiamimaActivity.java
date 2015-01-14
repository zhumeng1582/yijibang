package com.example.yijibang.mima;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.example.yijibang.R;

public class tianjiamimaActivity  extends Activity {
	
	

	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_mima_tianjia);
		
		
	}
}
