package com.heli.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heli.*;
import com.heli.dao.*;
@WebServlet("/NewsInsertServlet")
public class NewsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		News ne=new News();
		ne.setTitle(title);
		ne.setContent(content);
		ne.setType(type);
		ne.setName(name);
		NewsDao n=new NewsDao();
		if(n.insert1(ne)){
			request.setAttribute("info", "插入正确！");
			request.getRequestDispatcher("NewsInsert.jsp").forward(request, response);
		}
		else 
			{request.setAttribute("info1", "未成功插入！");
			request.getRequestDispatcher("NewsInsert.jsp").forward(request, response);}
		
		
		
	}

}
