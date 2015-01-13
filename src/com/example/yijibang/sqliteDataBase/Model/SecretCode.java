package com.example.yijibang.sqliteDataBase.Model;

public class SecretCode {
	
	private String   userId;                       //��ǰAVUser��objectId
	private String   remark;                       //��������Ƶ�˵��������QQ���룬�������ÿ�����
	private String   accountName;					//�˺�
	private String   secretCode;                   //���룬
	private String   soundFilePath;                //¼���ļ���·��

	
	public SecretCode(String userId,String remark,String accountName,String secretCode,String soundFilePath){
		this.userId=userId;                       //��ǰAVUser��objectId
		this.remark=remark;                       //��������Ƶ�˵��������QQ���룬�������ÿ�����
		this.accountName=accountName;					//�˺�
		this.secretCode=secretCode;                   //���룬
		this.soundFilePath=soundFilePath;         

		
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
	public String getSecretCode() {
		return secretCode;
	}
	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
	public String getSoundFilePath() {
		return soundFilePath;
	}
	public void setSoundFilePath(String soundFilePath) {
		this.soundFilePath = soundFilePath;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
