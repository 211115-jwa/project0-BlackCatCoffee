package com.revature.utils;

import java.io.IOException;


public class ConnectionUtil {
	private static ConnectionUtil connUtil;
	private static Properties databaseProps;

	private ConnectionUtil() {
		databaseProps = new Properties();

		try {
			InputStream propertiesFileStream = ConnectionUtil.class.getClassLoader()
					.getResourceAsStream("database.properties");
			databaseProps.load(propertiesFileStream);
		} catch (OIException e) {
			e.printStackTrace();
		}
	}

	public static synchronized ConnectionUtil getConnectionUtil() {
		if (connUtil == null)
			connUtil = new ConnectionUtil();
		return connUtil;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(databaseProps.getProperty("drv"));
			conn = DriverManager.getConnection(databaseProps.getProperty("url"), databaseProps.getProperty("usr"),
					databaseProps.getProperty("psw"));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
