package com.adobe.aem.sql.test;

import java.util.List;

import com.adobe.aem.sql.FetchDataImp;
import com.adobe.aem.sql.UpdateDataImp;
import com.adobe.aem.sql.model.PhonePairFeatureNote;
import com.adobe.aem.sql.model.PhonePairResult;
import com.adobe.aem.sql.model.PairInstStep;
import com.adobe.aem.sql.model.Phone;
import com.adobe.aem.sql.model.PhoneCarrier;
import com.adobe.aem.sql.model.PhoneManufacture;
import com.adobe.aem.sql.model.VehicleAud;
import com.adobe.aem.sql.model.VehicleModel;
import com.adobe.aem.sql.model.VehicleYear;

public class test {

	public static void main(String[] args) {
		
		 FetchDataImp fdi = new FetchDataImp();
//		 List<VehicleYear> years = fdi.getVehicleYear();
//		 System.out.println(years.get(1).getYear());
//		
//		
//		 List<VehicleModel> models = fdi.getVehicleModel("2016");
//		 System.out.println(models.get(1).getModImg());
//		
//		 List<VehicleAud> auds = fdi.getVehicleAudio(6);
//		 System.out.println(auds.get(1));
//		
//		 List<PhoneCarrier> cars = fdi.getCarriers();
//		 System.out.println(cars.get(0).getCarrier());
//		
		 List<PhoneManufacture> manus = fdi.getManufactures("AT&T");
		 System.out.println(manus.get(0).getManufacture());
//		
//		
		 List<Phone> phones = fdi.getPhones("APPLE", "AT&T");
		 System.out.println(phones.size());
//		
//		 PhonePairResult p = fdi.getPhonePairingResult(384);
//		 System.out.println(p.getPhPAIR().getFeatureNote());
		 
		
//		 PairFeatureNote x = fdi.getPairFeatureNote("sd(2025)");
//		 System.out.println(x.getResultDes());
//		 System.out.println(x.getResult());
		 
//		 List<PairInstStep> steps = fdi.getPairInst(384);
//		 System.out.println(steps.get(4).getInstruction());
		 
//		 UpdateDataImp udi = new UpdateDataImp();
//		 int keys = udi.addComments(35,9, 4, "this is other test");
//		 System.out.println(keys);
		 
		 

	}

}
