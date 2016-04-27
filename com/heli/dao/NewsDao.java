package com.heli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.heli.*;
import com.heli.dao.ConnectDB;

public class NewsDao {
	
	public ArrayList<News> getList(){
		ArrayList<News> ar = new ArrayList<News>();
		Connection conn = ConnectDB.getConnection();
		//SQL执行器对象  Statement 
		PreparedStatement ps = null;
		//结果集对象
		ResultSet rs = null;
		try {
			String sql = "select * from News";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				News ne = new News();
				ne.setId(rs.getInt("id"));
				ne.setTitle(rs.getString("title"));
				ne.setContent(rs.getString("content"));
				ne.setType(rs.getString("type"));
				ar.add(ne);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			ConnectDB.closeRes(rs, ps, conn);
		}
		return ar;
		
	}
	public ArrayList<News> getListAll(String sql){
		ArrayList<News> ar = new ArrayList<News>();
		Connection conn = ConnectDB.getConnection();
		//SQL执行器对象  Statement 
		PreparedStatement ps = null;
		//结果集对象
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from News");
//					+ ", user " +
//					" where booklist.id = user.id");
			rs = ps.executeQuery();
			while(rs.next()){
				News ne = new News();
				ne.setId(rs.getInt("id"));
				ne.setTitle(rs.getString("title"));
				ne.setContent(rs.getString("content"));
				ne.setType(rs.getString("type"));
				ne.setName(rs.getString("name"));
				ar.add(ne);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectDB.closeRes(rs, ps, conn);
		}
		return ar;
		
	}
	//该方法负责将传递过来的news对象中的数据 存入数据库中。
	public void insert(News ne){
		Connection conn = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into News (title,content,type,name) " +
				"values ('"+ne.getTitle()+"','"+ne.getContent()+"'," +
						ne.getType()+ne.getName()+")";
		try {
			ps = conn.prepareStatement(sql);
			int a = ps.executeUpdate();//这个方法用于改变数据库数据
			if(a>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			ConnectDB.closeRes( ps, conn);
		}
	}
	
	//该方法负责将传递过来的news对象中的数据 存入数据库中。
	public boolean insert1(News ne){
		boolean b = false;
		Connection conn = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into News (title,content,type,name) " +
				"values (?,?,?,?)";//占位符
		//1 占位符方式效率较高
		//2 拼写的时候不容易出错
		//3 防止SQL注入
		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1,ne.getId());
			ps.setString(1, ne.getTitle());
			ps.setString(2, ne.getContent());
			ps.setString(3, ne.getType());
			ps.setString(4, ne.getName());
			int a = ps.executeUpdate();//这个方法用于改变数据库数据
			if(a>0){
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			ConnectDB.closeRes( ps, conn);
		}
		return b;
	}
	//本方法用于 将传递过来的news对象中的值，根据id主键，改变数据库中的值
	public boolean update(News ne){
		boolean b = false;
		Connection conn = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "update News set title = ?,content = ?,type = ?,name = ? " +
				" where id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ne.getTitle());
			ps.setString(2, ne.getContent());
			ps.setString(3, ne.getType());
			ps.setString(4, ne.getName());
			ps.setInt(5, ne.getId());
			int a = ps.executeUpdate();
			if(a>0){
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			ConnectDB.closeRes( ps, conn);
		}
		return b;
	}
	
	public boolean delete(String q){
		boolean b = false;
		Connection conn = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from News where title = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, q);
			int a = ps.executeUpdate();
			if(a>0){
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectDB.closeRes( ps, conn);
		}
		return b;
	}
}
