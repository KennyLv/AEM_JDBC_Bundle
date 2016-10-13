package com.adobe.aem.sql.model;

public class VehicleYear {
	   
    //Define private class members
    private int id ;
    private String year;
      
      
    public void setId(int id)
    {
        this.id = id;
    }
      
    public int getId()
    {
        return this.id;
    }

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
