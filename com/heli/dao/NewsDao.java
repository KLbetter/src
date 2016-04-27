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
		//SQLִ��������  Statement 
		PreparedStatement ps = null;
		//���������
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
		//SQLִ��������  Statement 
		PreparedStatement ps = null;
		//���������
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
	//�÷������𽫴��ݹ�����news�����е����� �������ݿ��С�
	public void insert(News ne){
		Connection conn = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into News (title,content,type,name) " +
				"values ('"+ne.getTitle()+"','"+ne.getContent()+"'," +
						ne.getType()+ne.getName()+")";
		try {
			ps = conn.prepareStatement(sql);
			int a = ps.executeUpdate();//����������ڸı����ݿ�����
			if(a>0){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			ConnectDB.closeRes( ps, conn);
		}
	}
	
	//�÷������𽫴��ݹ�����news�����е����� �������ݿ��С�
	public boolean insert1(News ne){
		boolean b = false;
		Connection conn = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into News (title,content,type,name) " +
				"values (?,?,?,?)";//ռλ��
		//1 ռλ����ʽЧ�ʽϸ�
		//2 ƴд��ʱ�����׳���
		//3 ��ֹSQLע��
		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1,ne.getId());
			ps.setString(1, ne.getTitle());
			ps.setString(2, ne.getContent());
			ps.setString(3, ne.getType());
			ps.setString(4, ne.getName());
			int a = ps.executeUpdate();//����������ڸı����ݿ�����
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
	//���������� �����ݹ�����news�����е�ֵ������id�������ı����ݿ��е�ֵ
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
