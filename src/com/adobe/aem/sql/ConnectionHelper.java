package com.adobe.aem.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

	private String driver; // jdbc drive name
	private String url; // conneciton url of the destination database
	private static String username; // user name for database
	private static String password; // password for database
	private static ConnectionHelper instance;

	private ConnectionHelper() {
		try {
			String proFilePath = System.getProperty("user.dir") + "\\config.properties";
			System.out.println("===========" + proFilePath); //F:\AEM\config.properties
			// InputStream in = new BufferedInputStream(new
			// FileInputStream(proFilePath));
			// ResourceBundle resourceBundle = new PropertyResourceBundle(in);
			// driver = resourceBundle.getString("jdbc.driverClassName");
			// url = resourceBundle.getString("jdbc.url");
			// username = resourceBundle.getString("jdbc.username");
			// password = resourceBundle.getString("jdbc.password");
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&autoReconnect=true";
			username = "root";
			password = "123456";
			// load the driver instance
			Class.forName(driver).newInstance();
			// } catch (InvocationTargetException e1) {
			// e1.printStackTrace();
			// } catch (IOException e1) {
			// e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			return DriverManager.getConnection(instance.url, username, password);
		} catch (SQLException e) {
			throw e;
		}
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
