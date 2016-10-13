package com.adobe.aem.sql;

import java.sql.Array;
import java.util.List;

import com.adobe.aem.sql.model.Phone;
import com.adobe.aem.sql.model.PhoneCarrier;
import com.adobe.aem.sql.model.PhoneManufacture;
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

	// select * from tblmissphone order by missCARRIER DESC;
	// select distinct(missCARRIER) from tblmissphone where missCARRIER != ""
	// order by missCARRIER ASC

	public List<PhoneManufacture> getManufactures(String carrier);

	// select * from tblmissphone;
	// select distinct missMANUF from tblmissphone where missCARRIER = "AT&T";

	public List<Phone> getPhones(String carrier, String manufacture);

	// select * from tblmissphone;
	// select * from tblmissphone where missCARRIER = "T-Mobile" and missMOD
	// !="" and upper(missMANUF) like "%SAMSUNG%" order by missMOD;

	public Array getPairingInstr();

	// Select * from tblpairinst;

	public Array getFAQs();
	// select * from tblfaq;
}
