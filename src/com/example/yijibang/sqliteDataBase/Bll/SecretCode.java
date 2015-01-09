package com.example.yijibang.sqliteDataBase.Bll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yijibang.sqliteDataBase.DatabaseHelper;

public class SecretCode {
	
	private DatabaseHelper helper;
	private SQLiteDatabase db;
	
	public SecretCode(Context context){
		
		helper = DatabaseHelper.getInstance(context);
		
        db = helper.getWritableDatabase();
	}
	
	public int insert(com.example.yijibang.sqliteDataBase.Model.SecretCode modelSecretCode){
		ContentValues values = new ContentValues(); 
		
		values.put("userId", modelSecretCode.getUserId());
		values.put("remark", modelSecretCode.getRemark());
		values.put("accountName",modelSecretCode.getAccountName());
		values.put("secretCode",modelSecretCode.getSecretCode());
		values.put("soundFilePath",modelSecretCode.getSoundFilePath());

		db.insert("SecretCode", null, values); 
		return 0;
	}
	
	public int update(com.example.yijibang.sqliteDataBase.Model.SecretCode modelSecretCode){
		ContentValues values = new ContentValues(); 
		
		values.put("userId", modelSecretCode.getUserId());
		values.put("remark", modelSecretCode.getRemark());
		values.put("accountName",modelSecretCode.getAccountName());
		values.put("secretCode",modelSecretCode.getSecretCode());
		values.put("soundFilePath",modelSecretCode.getSoundFilePath());

		db.insert("SecretCode", null, values); 
		return 0;
	}
	public Cursor query(){
        Cursor c=db.rawQuery("select * from SecretCode", null);
        return c;
    }


}
