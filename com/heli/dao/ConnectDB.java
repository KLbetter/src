package com.heli.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	/**
	 * 数据库连接
	 * @author lixiyu
	 */
	public class ConnectDB {
		/**
		 * 获取数据库连接
		 * @return Connection对象
		 */
		public static Connection getConnection(){
			Connection conn = null;
			try {
				// 加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				// 数据库连接url
				String url = "jdbc:mysql://localhost:3306/movieimformation?useUnicode=true&characterEncoding=utf-8";
				// 获取数据库连接
				conn = DriverManager.getConnection(url, "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
		/**
		 * 关闭数据库连接
		 * @param conn Connection对象
		 */
		public static void closeConnection(Connection conn){
			// 判断conn是否为空
			if(conn != null){
				try {
					conn.close();	// 关闭数据库连接
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
