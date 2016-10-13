package com.adobe.aem.sql;

public interface UpdateDataInterface {
    public int injestVehicleData(int year, String lastName, String address, String desc);
    public int injestPhoneData(String carrier, String manufacture, String phonemodel);
    public int updatePairResult(String phonemodel, String vehicle, String results);
    public int updatePairInstr(String phonemodel, String vehicle, String steps);
}
