package com.example.yijibang.sqliteDataBase.Model;

import java.sql.Struct;

public class EveryTimeRecond {
	
	public enum EveryTimeRecondType {
		typeOfExpendituret, //֧��
	    typeOfIncome,       //����
    }
	
	private String  				userId;                  	//��ǰAVUser��objectId,��ΪAVUSer�Ǽ̳���AVObject�ģ�����AVUSer�ļ�����objectId
	private float                 	moneyAmount;              	//����Ǯ����Ŀ,������������
	private EveryTimeRecondType   	recondType;               	//֧����������,ö��
	private String                	consumePurpose;          	//����Ŀ��   �ַ�������
	private String                	recondTime;                	//��¼ʱ���ʱ���
	private String                	remark;                 	//��ע���ַ�������
	
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
