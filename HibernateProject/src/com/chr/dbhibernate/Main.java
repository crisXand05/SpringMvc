package com.chr.dbhibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userdb= "SYSTEM";
		String pass = "piespi3010";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userdb, pass);
			System.out.println("Conexion exitosa");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
