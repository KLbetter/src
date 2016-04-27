package com.heli.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	/**
	 * ���ݿ�����
	 * @author lixiyu
	 */
	public class ConnectDB {
		/**
		 * ��ȡ���ݿ�����
		 * @return Connection����
		 */
		public static Connection getConnection(){
			Connection conn = null;
			try {
				// ��������
				Class.forName("com.mysql.jdbc.Driver");
				// ���ݿ�����url
				String url = "jdbc:mysql://localhost:3306/movieimformation?useUnicode=true&characterEncoding=utf-8";
				// ��ȡ���ݿ�����
				conn = DriverManager.getConnection(url, "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
		/**
		 * �ر����ݿ�����
		 * @param conn Connection����
		 */
		public static void closeConnection(Connection conn){
			// �ж�conn�Ƿ�Ϊ��
			if(conn != null){
				try {
					conn.close();	// �ر����ݿ�����
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void closeRes(ResultSet rs,PreparedStatement ps,Connection conn){
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void closeRes(PreparedStatement ps,Connection conn){
			try {
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
