package com.heli.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heli.*;
import com.heli.dao.NewsDao;

public class NewslistServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		NewsDao a=new NewsDao();
		String sql="select * from News";
		ArrayList<News> list=a.getListAll(sql);
		request.setAttribute("list", list);
		request.getRequestDispatcher("newslist.jsp").forward(request, response);
	}
	
}
