package com.adobe.aem.sql;

import java.util.List;

import com.adobe.aem.sql.model.FAQ;
import com.adobe.aem.sql.model.PairInstStep;
import com.adobe.aem.sql.model.Phone;
import com.adobe.aem.sql.model.PhoneCarrier;
import com.adobe.aem.sql.model.PhoneManufacture;
import com.adobe.aem.sql.model.PhonePairResult;
import com.adobe.aem.sql.model.VehicleAud;
import com.adobe.aem.sql.model.VehicleModel;
import com.adobe.aem.sql.model.VehicleYear;

public interface FetchDataInterface {
	// Adds a new customer record in the Customer table
	// public int injestCustData(String firstName, String lastName, String
	// address, String desc);

	public List<VehicleYear> getVehicleYear();

	// Select * from tblyr;

	public List<VehicleModel> getVehicleModel(String year);

	// Select tblmodels.id as modId, tblyr.yrYEAR as yr, tblmodels.modNAME,
	// tblmodels.modIMG from tblmodels inner join tblyr on
	// tblmodels.modRefYR=tblyr.id where tblyr.yrYEAR = 2016;

	public List<VehicleAud> getVehicleAudio(int modId);

	// Select tblmodels.modNAME, tblmodels.modIMG, tblaudio.audTYPE,
	// tblaudio.audIMG, tblaudio.audNAME from tblmod_audx, tblaudio,tblmodels
	// where tblmod_audx.xrefAUDIO=tblaudio.id and tblmod_audx.xrefMODEL =
	// tblmodels.id;

	// Select tblaudio.id, tblaudio.audDESC, tblaudio.audNAME,
	// tblaudio_types.audTYPE, tblaudio.audIMG, tblaudio.audINST,
	// tblaudio.audPAIRid from tblaudio inner join tblaudio_types on
	// tblaudio.audTYPE = tblaudio_types.id order by audNAME;
	// Select * from tblmod_audx, tblaudio,tblmodels where
	// tblmod_audx.xrefAUDIO=tblaudio.id and tblmod_audx.xrefMODEL =
	// tblmodels.id;

	// select * from
	// (Select tblmodels.id as modelid, tblmodels.modNAME, tblmodels.modIMG,
	// tblaudio.audTYPE, tblaudio.audIMG, tblaudio.audNAME
	// from tblmod_audx, tblaudio,tblmodels where
	// tblmod_audx.xrefAUDIO=tblaudio.id and tblmod_audx.xrefMODEL =
	// tblmodels.id) as tblmod_audio
	// where tblmod_audio.modelid=1;

	public List<PhoneCarrier> getCarriers();
	// select distinct(phCARRIER) from tblmobileresults where phCARRIER != \"\"
	// order by phCARRIER ASC

	public List<PhoneManufacture> getManufactures(String carrier);
	// Select distinct(phCOMPANY) from tblmobileresults where phCARRIER = ?
	// order by phCOMPANY

	public List<Phone> getPhones(String carrier, String manufacture);
	// Select * from tblmobileresults where phCARRIER = ? and phCOMPANY=? GROUP
	// BY phMODEL order by phMODEL ASC

	public PhonePairResult getPhonePairingResult(int recordId);
	// Select * from tblmobileresults where id = ?

	public List<PairInstStep> getPairInst(int pairId);
	// Select * from tblpairinst where refId = 384 ORDER BY refORD ASC

	public List<FAQ> getFAQs();
	// select * from tblfaq;
}
