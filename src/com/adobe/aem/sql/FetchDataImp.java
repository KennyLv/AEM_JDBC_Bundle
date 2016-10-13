package com.adobe.aem.sql;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.aem.sql.model.Phone;
import com.adobe.aem.sql.model.PhoneCarrier;
import com.adobe.aem.sql.model.PhoneManufacture;
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
		String query = "Select tblmod_audx.xrefMODEL as modId, tblmod_audx.xrefAUDIO as audId, tblaudio.audNAME, tblaudio.audIMG, tblaudio.audType as audTypeId, tblaudio_types.audType"
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
		String query = "Select distinct(phCOMPANY) from tblmobileresults where phCARRIER = ? order by phCOMPANY";
		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, carrier);
			

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
	public List<Phone> getPhones(String carrier, String manufacture) {

		List<Phone> phones = new ArrayList<Phone>();
		Phone phone = null;
		//String query = "select * from tblmissphone where missCARRIER = ? and missMOD !=\"\" and upper(missMANUF) like ? order by missMOD";
		String query = "Select * from tblmobileresults where phCARRIER = ? and phCOMPANY=? order by phMODEL ASC";
		try {
			// Create a Connection object
			connect = ConnectionHelper.getConnection();
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, carrier);
			pstmt.setString(2, manufacture);
			//pstmt.setString(2, "%" + manufacture.toUpperCase() + "%");
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				phone = new Phone();
				phone.setId(rs.getInt("id"));
				phone.setCarrier(rs.getString("phCARRIER"));
				phone.setManufacture(rs.getString("phCOMPANY"));
				phone.setPhonename(rs.getString("phMODEL"));
				phone.setPhoneimg(rs.getString("phIMG"));
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
	public Array getPairingInstr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array getFAQs() {
		// TODO Auto-generated method stub
		return null;
	}
}
