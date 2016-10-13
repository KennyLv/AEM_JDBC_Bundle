package com.adobe.aem.sql.model;

public class Phone {
	   
    //Define private class members
    private int id;
    private String carrier;
    private String manufacture;
    private String phonename;
    private String phoneimg;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getPhonename() {
		return phonename;
	}
	public void setPhonename(String phonename) {
		this.phonename = phonename;
	}
	public String getPhoneimg() {
		return phoneimg;
	}
	public void setPhoneimg(String phoneimg) {
		this.phoneimg = phoneimg;
	}
}
