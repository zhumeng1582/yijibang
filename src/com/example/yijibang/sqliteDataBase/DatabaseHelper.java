package com.example.yijibang.sqliteDataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{  
    private static final int VERSION = 1;  
    private static final String SWORD="SWORD";
    private static final String DBNAME = "yijibang.db";

    private static DatabaseHelper mInstance = null;  
    
    private DatabaseHelper(Context context) {  
        super(context, DBNAME, null, VERSION);  
          
    } 
    public synchronized static DatabaseHelper getInstance(Context context) {  
    	if (mInstance == null) {
    		mInstance = new DatabaseHelper(context); 
    	}
    	
    	return mInstance;
    }  
    
    //�������ݿ�  
    public void onCreate(SQLiteDatabase db) {  
        Log.i(SWORD,"create a Database");  
        //�������ݿ�sql���  
        //Create Table EveryTimeRecond(userId Text Primary Key,moneyAmount float,recondType Integer,consumePurpose Text,recondTime Text,remark Text);
        //Create Table Memo(userId Text Primary Key,remark Text,eventDate Text,soundFilePath Text);
        //Create Table SecretCode(userId Text Primary Key,remark Text,accountName Text,secretCode Text,soundFilePath Text);
        String EveryTimeRecond = "Create Table EveryTimeRecond(userId Text Primary Key,moneyAmount float,recondType Integer,consumePurpose Text,recondTime Text,remark Text);";  
        String Memo = "Create Table Memo(userId Text Primary Key,remark Text,eventDate Text,soundFilePath Text);";  
        String SecretCode = "Create Table SecretCode(userId Text Primary Key,remark Text,accountName Text,secretCode Text,soundFilePath Text);";
        //ִ�д������ݿ����  
        db.execSQL(EveryTimeRecond);  
        db.execSQL(Memo);  
        db.execSQL(SecretCode);  
    }  
    
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
        //�����ɹ�����־�����ʾ  
    	
        Log.i(SWORD,"update a Database");  
    }  
    public boolean deleteDatabase(Context context) {  
        return context.deleteDatabase(DBNAME);
    }   
}
