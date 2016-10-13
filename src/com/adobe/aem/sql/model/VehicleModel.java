package com.adobe.aem.sql.model;

public class VehicleModel {
	   
    //Define private class members
    private int modId ;
    private String year;
    private String modName;
    private String modImg;
      
      
    public void setModId(int id)
    {
        this.modId = id;
    }
      
    public int getModId()
    {
        return this.modId;
    }

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModImg() {
		return modImg;
	}

	public void setModImg(String modImg) {
		this.modImg = modImg;
	}
}
