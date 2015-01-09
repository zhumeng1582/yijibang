package com.example.yijibang.sqliteDataBase.Model;

import java.sql.Struct;

public class EveryTimeRecond {
	
	public enum EveryTimeRecondType {
		typeOfExpendituret, //支出
	    typeOfIncome,       //收入
    }
	
	private String  				userId;                  	//当前AVUser的objectId,因为AVUSer是继承自AVObject的，所以AVUSer的键就是objectId
	private float                 	moneyAmount;              	//花的钱的数目,浮点数据类型
	private EveryTimeRecondType   	recondType;               	//支出还是收入,枚举
	private String                	consumePurpose;          	//消费目的   字符串类型
	private String                	recondTime;                	//记录时间的时间戳
	private String                	remark;                 	//备注，字符串类型
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public float getMoneyAmount() {
		return moneyAmount;
	}
	public void setMoneyAmount(float moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	public EveryTimeRecondType getRecondType() {
		return recondType;
	}
	public int getEveryTimeRecondTypeValue(){
		int value=0;
		switch(recondType) {
		case typeOfExpendituret:
			value=0;
		   break;
		case typeOfIncome:
			value=1;
		   break;
		default: break;
		}
		return value;
	}
	
	public void setRecondType(EveryTimeRecondType recondType) {
		this.recondType = recondType;
	}
	public String getConsumePurpose() {
		return consumePurpose;
	}
	public void setConsumePurpose(String consumePurpose) {
		this.consumePurpose = consumePurpose;
	}
	public String getRecondTime() {
		return recondTime;
	}
	public void setRecondTime(String recondTime) {
		this.recondTime = recondTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}
