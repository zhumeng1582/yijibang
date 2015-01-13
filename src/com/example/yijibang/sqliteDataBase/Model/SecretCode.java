package com.example.yijibang.sqliteDataBase.Model;

public class SecretCode {
	
	private String   userId;                       //当前AVUser的objectId
	private String   remark;                       //密码的名称的说明，例如QQ密码，招行信用卡密码
	private String   accountName;					//账号
	private String   secretCode;                   //密码，
	private String   soundFilePath;                //录音文件的路径

	
	public SecretCode(String userId,String remark,String accountName,String secretCode,String soundFilePath){
		this.userId=userId;                       //当前AVUser的objectId
		this.remark=remark;                       //密码的名称的说明，例如QQ密码，招行信用卡密码
		this.accountName=accountName;					//账号
		this.secretCode=secretCode;                   //密码，
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
