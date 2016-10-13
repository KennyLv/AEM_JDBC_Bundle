package com.adobe.aem.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adobe.aem.sql.model.FAQ;
import com.adobe.aem.sql.model.PairInstStep;
import com.adobe.aem.sql.model.Phone;
import com.adobe.aem.sql.model.PhoneCarrier;
import com.adobe.aem.sql.model.PhoneManufacture;
import com.adobe.aem.sql.model.PhonePairFeatureNote;
import com.adobe.aem.sql.model.PhonePairResult;
import com.adobe.aem.sql.model.VehicleAud;
import com.adobe.aem.sql.model.VehicleModel;
import com.adobe.aem.sql.model.VehicleYear;

public class FetchDataImp implements FetchDataInterface {
	Connection connect = null;

	@Override
	public List<VehicleYear> getVehicleYear() {
		List<VehicleYear> years = new ArrayList<VehicleYear>();
		VehicleYear year = null;
		String query = "Select * from tblyr";
		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			// Statement s = connect.createStatement();
			// Statement scount = connect.createStatement();
			PreparedStatement pstmt = connect.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				year = new VehicleYear();
				year.setId(rs.getInt("id"));
				year.setYear(rs.getString("yrYEAR"));
				years.add(year);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return years;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<VehicleModel> getVehicleModel(String year) {
		List<VehicleModel> models = new ArrayList<VehicleModel>();
		VehicleModel mode = null;
		String query = "Select tblmodels.id as modId, tblyr.yrYEAR as year, tblmodels.modNAME, tblmodels.modIMG "
				+ "from tblmodels inner join tblyr on tblmodels.modRefYR=tblyr.id where tblyr.yrYEAR = ?";
		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, year);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				mode = new VehicleModel();
				mode.setModId(rs.getInt("modId"));
				mode.setYear(rs.getString("year"));
				mode.setModName(rs.getString("modNAME"));
				mode.setModImg(rs.getString("modIMG"));
				models.add(mode);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return models;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<VehicleAud> getVehicleAudio(int modId) {

		List<VehicleAud> auds = new ArrayList<VehicleAud>();
		VehicleAud aud = null;
		String query = "Select tblmod_audx.xrefMODEL as modId, tblmod_audx.xrefAUDIO as audId, tblaudio.audNAME, tblaudio.audIMG, tblaudio.audType as audTypeId, tblaudio_types.audType, tblaudio.audPAIRid"
				+ "	from (tblmod_audx right join tblaudio on tblmod_audx.xrefAUDIO = tblaudio.id )"
				+ " right join tblaudio_types on tblaudio_types.id = tblaudio.audTYPE where tblmod_audx.xrefMODEL = ?";

		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, modId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				aud = new VehicleAud();
				aud.setAudId(rs.getInt("audId"));
				aud.setAudName(rs.getString("audNAME"));
				aud.setAudImg(rs.getString("audIMG"));
				aud.setAudTypeId(rs.getInt("audTypeId"));
				aud.setAudType(rs.getString("audType"));
				aud.setAudPairInstId(rs.getInt("audPAIRid"));
				auds.add(aud);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return auds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PhoneCarrier> getCarriers() {
		List<PhoneCarrier> carriers = new ArrayList<PhoneCarrier>();
		PhoneCarrier carrier = null;
		String query = "select distinct(phCARRIER) from tblmobileresults where phCARRIER != \"\" order by phCARRIER ASC";

		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				carrier = new PhoneCarrier();
				carrier.setCarrier(rs.getString("phCARRIER"));
				carriers.add(carrier);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return carriers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PhoneManufacture> getManufactures(String carrier) {

		List<PhoneManufacture> manufactures = new ArrayList<PhoneManufacture>();
		PhoneManufacture manufacture = null;
		String query = "Select distinct(phCOMPANY) from tblmobileresults where phCARRIER LIKE ?  order by phCOMPANY";
		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, "%" + carrier + "%");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				manufacture = new PhoneManufacture();
				manufacture.setManufacture(rs.getString("phCOMPANY"));
				manufactures.add(manufacture);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return manufactures;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Phone> getPhones(String manufacture, String carrier) {
		
		List<Phone> phones = new ArrayList<Phone>();
		Phone phone = null;
		// String query = "select * from tblmissphone where missCARRIER = ? and
		// missMOD !=\"\" and upper(missMANUF) like ? order by missMOD";
		String query = "Select * from tblmobileresults where phCOMPANY=? and phCARRIER LIKE ? GROUP BY phMODEL order by phMODEL ASC";

		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, manufacture);
			pstmt.setString(2, carrier);
			// pstmt.setString(2, "%" + manufacture.toUpperCase() + "%");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				phone = new Phone();
				phone.setId(rs.getInt("id")); // id
				phone.setCarrier(rs.getString("phCARRIER"));
				phone.setManufacture(rs.getString("phCOMPANY"));
				phone.setPhonename(rs.getString("phMODEL"));
				phone.setPhoneimg(rs.getString("phIMG"));
				phone.setPhonePairId(rs.getInt("phPAIRid")); // phone pair id
				phones.add(phone);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return phones;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PhonePairResult getPhonePairingResult(int id) {
		PhonePairResult pairResult = new PhonePairResult();
		String query = "Select * from tblmobileresults where id = ?";

		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			// pstmt.setString(2, "%" + manufacture.toUpperCase() + "%");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pairResult.setResultId(rs.getInt("id"));
				pairResult.setPhCOMPANY(rs.getString("phCOMPANY"));
				pairResult.setPhCARRIER(rs.getString("phCARRIER"));
				pairResult.setPhMODEL(rs.getString("phMODEL"));
				pairResult.setPhVERSION(rs.getString("phVERSION")); // 2.0.1
				pairResult.setPhIMG(rs.getString("phIMG")); // IPhone_4mw1r.gif
				pairResult.setPhANNOUNCE(rs.getString("phANNOUNCE")); // 2011

				pairResult.setPhRESULT(rs.getString("phRESULT")); // Passed /
																	// Failed

				pairResult.setPhPAIR(getPairFeatureNote(rs.getString("phPAIR"))); // YES
																					// (id)
																					// /
																					// NO
				pairResult.setPhCONNECT(getPairFeatureNote(rs.getString("phCONNECT"))); // YES
																						// (id)
																						// /
																						// NO
				pairResult.setPhHFT(getPairFeatureNote(rs.getString("phHFT"))); // YES
																				// (id)
																				// /
																				// NO
				pairResult.setPhHUC(getPairFeatureNote(rs.getString("phHUC")));
				pairResult.setPhTTP(getPairFeatureNote(rs.getString("phTTP")));
				pairResult.setPhCALLID(getPairFeatureNote(rs.getString("phCALLID")));
				pairResult.setPhREDIAL(getPairFeatureNote(rs.getString("phREDIAL")));
				pairResult.setPhMCH(getPairFeatureNote(rs.getString("phMCH")));
				pairResult.setPhIBS(getPairFeatureNote(rs.getString("phIBS")));
				pairResult.setPhAPD(getPairFeatureNote(rs.getString("phAPD")));
				pairResult.setPhSTREAM(getPairFeatureNote(rs.getString("phSTREAM")));

				pairResult.setPhICC(rs.getString("phICC"));
				pairResult.setPhOGC(rs.getString("phOGC"));
				pairResult.setPhAUDIOX(rs.getString("phAUDIOX"));
				pairResult.setPhHANG(rs.getString("phHANG"));
				pairResult.setPhPB_DEV(rs.getString("phPB_DEV"));
				pairResult.setPhPB_SIM(rs.getString("phPB_SIM"));
				pairResult.setPh3WAY(rs.getString("ph3WAY"));
				pairResult.setPhRCP(rs.getString("phRCP"));
				pairResult.setPhROR(rs.getString("phROR"));
				pairResult.setPhHOLD(rs.getString("phHOLD"));
				pairResult.setPhWAIT(rs.getString("phWAIT"));
				pairResult.setPhIDA(rs.getString("phIDA"));
				pairResult.setPhTYPE(rs.getInt("phTYPE"));
				pairResult.setPhHIDE(rs.getInt("phHIDE"));
			}
			connect.close();
			// return convertToString(toXml(custList));
			return pairResult;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<PairInstStep> getPairInst(int pairId) {
		List<PairInstStep> steps = new ArrayList<PairInstStep>();
		String query = "Select * from tblpairinst where refId = ? ORDER BY refORD ASC";
		try {
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, pairId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PairInstStep step = new PairInstStep();
				step.setStepOrder(rs.getInt("refORD")); // id
				step.setStepGroup(rs.getInt("refSTEP"));
				step.setInstruction(rs.getString("refINST"));
				steps.add(step);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return steps;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FAQ> getFAQs() {
		List<FAQ> faqs = new ArrayList<FAQ>();
		String query = "Select * from tblfaq";
		try {
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				FAQ faq = new FAQ();
				faq.setId(rs.getInt("faqID")); // id
				faq.setOrder(rs.getInt("faqORD"));
				faq.setFaqShow(rs.getInt("faqSHOW"));
				faq.setFaqQuestion(rs.getString("faqQUEST"));
				faq.setFaqAnswer(rs.getString("faqANSW"));
				faqs.add(faq);
			}
			connect.close();
			// return convertToString(toXml(custList));
			return faqs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private PhonePairFeatureNote getPairFeatureNote(String result) {
		PhonePairFeatureNote des = new PhonePairFeatureNote();
		des.setFeturePairResult(result);
		if (result != null && result != "") {

			Pattern p = Pattern.compile("([0-9]*)");
			Matcher m = p.matcher(result);
			String InstrId = null;
			while (m.find()) {
				if (!m.group().trim().equals("")) {
					InstrId = m.group(1);
					break;
				}
			}
			System.out.println("insId" + InstrId);
			if (InstrId != null) {
				String query = "Select * from tblfn where fnREF = ?";
				try {
					// Create a Connection object
					connect = ConnectionHelper.getConnection();
					PreparedStatement pstmt = connect.prepareStatement(query);
					pstmt.setString(1, InstrId);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						des.setFeatureNote(rs.getString("fnTEXT"));
					}
					connect.close();
				} catch (Exception e) {
					e.printStackTrace();
					des.setFeatureNote(null);
				}
			} else {
				des.setFeatureNote(null);
			}
		} else {
			des.setFeatureNote(null);
		}
		return des;
	}
	// private String updateSQLQuery(String qureyStr){
	// return qureyStr.replaceAll("&", "\\&");
	// }

}
