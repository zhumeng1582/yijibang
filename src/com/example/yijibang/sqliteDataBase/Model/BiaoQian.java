package com.example.yijibang.sqliteDataBase.Model;

public class BiaoQian {
	private int backGroundId;
	private String text;
	
	public BiaoQian(int backGroundId,String text){
		this.backGroundId = backGroundId;
		this.text = text;
	}
	
	public int getBackGroundId() {
		return backGroundId;
	}
	public void setBackGroundId(int backGroundId) {
		this.backGroundId = backGroundId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
