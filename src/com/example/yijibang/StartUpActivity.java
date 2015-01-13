package com.example.yijibang;

import com.example.yijibang.welcome.NetManager;
import com.example.yijibang.welcome.SharedConfig;
import com.example.yijibang.welcome.WelcomeActivity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;

public class StartUpActivity extends Activity {
		private boolean first;	//鍒ゆ柇鏄惁绗竴娆℃墦寮�蒋浠�
		private View view;
		private Context context;
		private Animation animation;
		private SharedPreferences shared;
		private static int TIME = 200; 										// 杩涘叆涓荤▼搴忕殑寤惰繜鏃堕棿
		
		private String TAG = "StartUpActivity";

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			this.requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			
			view = View.inflate(this, R.layout.activity_startup, null);
			setContentView(view);
			context = this;							//寰楀埌涓婁笅鏂�
			shared = new SharedConfig(context).GetConfig(); 	// 寰楀埌閰嶇疆鏂囦欢
			
		}

		@Override
		protected void onResume() {
			into();
			super.onResume();
		}

		public void onPause() {
			super.onPause();
		}
		private void into() {
			Log.e(TAG, "NetManage is open");
			
			first = shared.getBoolean("First", true);
			animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
			
			view.startAnimation(animation);
			
			Log.e(TAG, "start Animation success");
			
			animation.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation arg0) {
					
				}

				@Override
				public void onAnimationRepeat(Animation arg0) {
				
				}

				@Override
				public void onAnimationEnd(Animation arg0) {
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent;
							if (first) {
								Log.e(TAG, "first");
								intent = new Intent(StartUpActivity.this,
										WelcomeActivity.class);
							} else {
								intent = new Intent(StartUpActivity.this,
										MainActivity.class);
							}
							startActivity(intent);
							
							overridePendingTransition(R.anim.in_from_right,
									R.anim.out_to_left);
							StartUpActivity.this.finish();
						}
					}, TIME);
				}
			}); 
		}
	}
