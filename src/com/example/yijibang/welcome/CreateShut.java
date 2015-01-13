package com.example.yijibang.welcome;


import com.example.yijibang.R;
import com.example.yijibang.StartUpActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;


public class CreateShut {
	public CreateShut(Activity activity) {
		
		Intent addIntent = new Intent(
				"com.android.launcher.action.INSTALL_SHORTCUT");
		
		addIntent.putExtra("duplicate", false);
		
		String title = activity.getResources().getString(R.string.app_name);
		
		Parcelable icon = Intent.ShortcutIconResource.fromContext(
				activity, R.drawable.ic_launcher);
		
		Intent myIntent = new Intent(activity, StartUpActivity.class);
		
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
		
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
		
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, myIntent);
		
		activity.sendBroadcast(addIntent);
	}
}
