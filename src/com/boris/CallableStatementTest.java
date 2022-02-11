package com.boris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CallableStatementTest {
	public static void main(String[] args) {
		try {
			int n=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
//			Statement statement = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?)");
//			n += statement.executeUpdate("insert into employee values(111,'emp1',20000)");
//			n += statement.executeUpdate("insert into employee values(222,'emp2',40000)");
//			n += statement.executeUpdate("insert into employee values(333,'emp3',60000)");
			ps.setInt(1, 444);
			ps.setString(2,"emp4");
			ps.setInt(3, 80000);
			n +=ps.executeUpdate();
			System.out.println("Number of rows affected "+n);
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
