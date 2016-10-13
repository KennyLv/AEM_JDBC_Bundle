package com.adobe.aem.sql.test;

import java.util.List;

import com.adobe.aem.sql.FetchDataImp;
import com.adobe.aem.sql.model.Phone;
import com.adobe.aem.sql.model.PhoneCarrier;
import com.adobe.aem.sql.model.PhoneManufacture;
import com.adobe.aem.sql.model.VehicleAud;
import com.adobe.aem.sql.model.VehicleModel;
import com.adobe.aem.sql.model.VehicleYear;

public class test {

	public static void main(String[] args) {

		FetchDataImp fdi = new FetchDataImp();
		List<VehicleYear> years = fdi.getVehicleYear();
		System.out.println(years.get(1).getYear());
		

		List<VehicleModel> models = fdi.getVehicleModel("2016");
		System.out.println(models.get(1).getModImg());

		List<VehicleAud> auds = fdi.getVehicleAudio(6);
		System.out.println(auds.get(1));

		List<PhoneCarrier> cars = fdi.getCarriers();
		System.out.println(cars.get(0).getCarrier());

		List<PhoneManufacture>  manus = fdi.getManufactures("AT&T");
		System.out.println(manus.get(0).getManufacture());
		

		List<Phone>  phones = fdi.getPhones("T-Mobile", "samsung");
		System.out.println(phones.get(0).getPhonename());
		
		
	}

}


