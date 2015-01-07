package com.example.yijibang.beiwang;

import com.example.yijibang.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class beiwangActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_beiwang);
	}

}
