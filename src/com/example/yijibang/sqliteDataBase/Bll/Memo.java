package com.example.yijibang.sqliteDataBase.Bll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yijibang.sqliteDataBase.DatabaseHelper;

public class Memo {
	
	private DatabaseHelper helper;
	private SQLiteDatabase db;
	
	public Memo(Context context){
		
		helper = DatabaseHelper.getInstance(context);
		
        db = helper.getWritableDatabase();
	}
	
	public int insert(com.example.yijibang.sqliteDataBase.Model.Memo modelMemo){
		ContentValues values = new ContentValues(); 
		
		values.put("userId", modelMemo.getUserId());
		values.put("remark", modelMemo.getRemark());
		values.put("eventDate",modelMemo.getEventDate());
		values.put("soundFilePath",modelMemo.getSoundFilePath());

		db.insert("Memo", null, values); 
		return 0;
	}
	
	public int update(com.example.yijibang.sqliteDataBase.Model.Memo modelMemo){
		ContentValues values = new ContentValues(); 
		
		values.put("userId", modelMemo.getUserId());
		values.put("remark", modelMemo.getRemark());
		values.put("eventDate",modelMemo.getEventDate());
		values.put("soundFilePath",modelMemo.getSoundFilePath());

		db.update("Memo", values, null, null);
		return 0;
	}
	public Cursor query(){
        Cursor c=db.rawQuery("select * from Memo", null);
        return c;
    }
}
