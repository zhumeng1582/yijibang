package com.example.yijibang.sqliteDataBase.Model;

import com.example.yijibang.SlideView.SlideView;

public class Memo {
	
	private String    userId;                       //��ǰAVUser��objectId
	private String    remark;                       //���������Ƶ�˵����������������
	private String    eventDate;                    //����ʱ���ʱ���
	private String    soundFilePath;                //¼���ļ���·��
	private int 	  color;
	public SlideView slideView;
	
	
	public Memo(String userId,String remark,String eventDate,String soundFilePath,int color){
		this.userId = userId;                     
		this.remark = remark;                     
		this.eventDate = eventDate;                  
		this.soundFilePath = soundFilePath; 
		this.color = color;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getSoundFilePath() {
		return soundFilePath;
	}
	public void setSoundFilePath(String soundFilePath) {
		this.soundFilePath = soundFilePath;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}

	

}
