package com.java.ex.DB;

import java.sql.*;

import javax.swing.JLabel;

public class Ingredient {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://Localhost:3307/gimal2020";          // lecture ��� �ڽ��� �����ͺ��̽� ���̺��̸� ������. ��Ʈ��ȣ �����Ѱ��ֱ�
	static String uid = "root";                                        // ������DB ���̵�
	static String pwd = "1234";                                        // ������DB ��й�ȣ

//	public static void main(String[] args) {
//		Customer();
//	}
	
	public static String Customer() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		String query1 = "select * from ingredient";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			rsmd = rs.getMetaData();

			while(rs.next()) {
				String c = rs.getString(3);
				JLabel w = new JLabel(c + "��");
				w.setBounds(300,32,60,20);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;

	}

}

	
//	public static void Customer(int Count) {
//		try {
//			Connection con = getConnection();
//			String query1 = "update into ingredient (Count) VALUE" + "'" + Count + "'";
//			PreparedStatement update = con.prepareStatement(query1);
//			update.executeUpdate();
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	public static void CountTable(int Count) {
//		try {
//			Connection con = getConnection();
//			Statement stmt = null;
//			ResultSet rs = null;
//			ResultSetMetaData rsmd = null;
//			String query1 = "select * from ingredient";
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(query1);
//			rsmd = rs.getMetaData();
//			
//			while(rs.next()) {
//				String c = rs.getString("Count");
//				
//				System.out.println(c + "��");
//			}
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	public static Connection getConnection() {
//		try {
//			String driver = "org.mariadb.jdbc.Driver";
//			String url = "jdbc:mariadb://Localhost:3307/test";          // lecture ��� �ڽ��� �����ͺ��̽� ���̺��̸� ������. ��Ʈ��ȣ �����Ѱ��ֱ�
//			String uid = "root";                                        // ������DB ���̵�
//			String pwd = "1234";                                        // ������DB ��й�ȣ
//			
//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url,uid,pwd);
//			return con;
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}
//
//}