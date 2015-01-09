package com.example.yijibang.sqliteDataBase.Bll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yijibang.sqliteDataBase.DatabaseHelper;

public class EveryTimeRecond {
	
	private DatabaseHelper helper;
	private SQLiteDatabase db;
	
	public EveryTimeRecond(Context context){
		
		helper = DatabaseHelper.getInstance(context);
		
        db = helper.getWritableDatabase();
	}
	
	public int insert(com.example.yijibang.sqliteDataBase.Model.EveryTimeRecond modelEveryTimeRecond){
		ContentValues values = new ContentValues(); 
		
		values.put("userId", modelEveryTimeRecond.getUserId());
		values.put("moneyAmount", modelEveryTimeRecond.getMoneyAmount());
		values.put("recondType", modelEveryTimeRecond.getEveryTimeRecondTypeValue());
		values.put("consumePurpose", modelEveryTimeRecond.getConsumePurpose());
		values.put("recondTime", modelEveryTimeRecond.getRecondTime());
		values.put("remarks", modelEveryTimeRecond.getRemark());
		
		
		db.insert("EveryTimeRecond", null, values); 
		return 0;
	}
	
	public int update(com.example.yijibang.sqliteDataBase.Model.EveryTimeRecond modelEveryTimeRecond){
		
		ContentValues values = new ContentValues(); 
		
		values.put("userId", modelEveryTimeRecond.getUserId());
		values.put("moneyAmount", modelEveryTimeRecond.getMoneyAmount());
		values.put("recondType", modelEveryTimeRecond.getEveryTimeRecondTypeValue());
		values.put("consumePurpose", modelEveryTimeRecond.getConsumePurpose());
		values.put("recondTime", modelEveryTimeRecond.getRecondTime());
		values.put("remarks", modelEveryTimeRecond.getRemark());
		
		
		db.update("EveryTimeRecond", values, null, null);
		return 0;
	}
	public Cursor query(){
        Cursor c=db.rawQuery("select * from EveryTimeRecond", null);
        return c;
    }
}
