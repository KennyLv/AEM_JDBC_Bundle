package com.adobe.aem.sql.model;

public class VehicleAud {
	   
    //Define private class members
    private int audId ;
    private String audName;
    private String audImg;
    private int audTypeId;
    private String audType;
    private int audPairInstId;
    
    
	public int getAudId() {
		return audId;
	}
	public void setAudId(int audId) {
		this.audId = audId;
	}
	public String getAudName() {
		return audName;
	}
	public void setAudName(String audName) {
		this.audName = audName;
	}
	public String getAudImg() {
		return audImg;
	}
	public void setAudImg(String audImg) {
		this.audImg = audImg;
	}
	public int getAudTypeId() {
		return audTypeId;
	}
	public void setAudTypeId(int audTypeId) {
		this.audTypeId = audTypeId;
	}
	public String getAudType() {
		return audType;
	}
	public void setAudType(String audType) {
		this.audType = audType;
	}
	public int getAudPairInstId() {
		return audPairInstId;
	}
	public void setAudPairInstId(int audPairInstId) {
		this.audPairInstId = audPairInstId;
	}
}
