package com.boris;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CurdTest {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			
			int n;
			
//			CallableStatement call = conn.prepareCall("call insertEmployee(?,?,?)");
//			call.setInt(1, 555);
//			call.setString(2, "emp5");
//			call.setInt(3, 100000);
//			
//			n = call.executeUpdate();
//			System.out.println("Number of rows affected "+n);
			
			CallableStatement call2 = conn.prepareCall("call getEmployee(?,?,?)");
			call2.setInt(1, 111);
			call2.registerOutParameter(2, java.sql.Types.VARCHAR);
			call2.registerOutParameter(3, java.sql.Types.INTEGER);
			
			n = call2.executeUpdate();
			System.out.println("Number of rows affected "+n);
			
			System.out.println(call2.getString(2)+"--->"+call2.getInt(3));
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
