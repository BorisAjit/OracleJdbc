package com.boris;

import java.sql.*;

public class JdbcTest {
	public static void main(String[] args) {
		try {
			System.out.println("connecting to database....");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			System.out.println("connection established....");
			
			Statement statement = conn.createStatement();
//			statement.executeUpdate("insert into student(id,name) values(123,'student1')");
//			statement.executeUpdate("insert into student(id,name) values(234,'student2')");
//			statement.executeUpdate("insert into student(id,name) values(345,'student3')");
			ResultSet rs = statement.executeQuery("select * from student");
			System.out.println((rs.next()));
			while(rs.next()) {
				System.out.println(rs.getInt("ID")+"-->"+rs.getString("NAME"));
			}
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
