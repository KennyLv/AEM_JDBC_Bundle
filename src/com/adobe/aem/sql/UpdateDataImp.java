package com.adobe.aem.sql;

public class UpdateDataImp implements UpdateDataInterface {

	@Override
	public int injestVehicleData(int year, String lastName, String address,
			String desc) {
		// TODO Auto-generated method stub//
//		Connection c = null;
//		int rowCount = 0;
//		try {
//
//			// Create a Connection object
//			c = ConnectionHelper.getConnection();
//
//			ResultSet rs = null;
//			Statement s = c.createStatement();
//			Statement scount = c.createStatement();
//
//			// Use prepared statements to protected against SQL injection
//			// attacks
//			PreparedStatement pstmt = null;
//			PreparedStatement ps = null;
//
//			// Set the query and use a preparedStatement
//			String query = "Select * FROM Customer";
//			pstmt = c.prepareStatement(query);
//			rs = pstmt.executeQuery();
//
//			while (rs.next())
//				rowCount++;
//
//			// Set the PK value
//			int pkVal = rowCount + 2;
//
//			String insert = "INSERT INTO Customer(custId,custFirst,custLast,custAddress,custDesc) VALUES(?, ?, ?, ?, ?);";
//			ps = c.prepareStatement(insert);
//			ps.setInt(1, pkVal);
//			ps.setString(2, firstName);
//			ps.setString(3, lastName);
//			ps.setString(4, address);
//			ps.setString(5, desc);
//			ps.execute();
//			return pkVal;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionHelper.close(c);
//		}
		return 0;
	}

	@Override
	public int injestPhoneData(String carrier, String manufacture,
			String phonemodel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePairResult(String phonemodel, String vehicle,
			String results) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePairInstr(String phonemodel, String vehicle, String steps) {
		// TODO Auto-generated method stub
		return 0;
	}

}
