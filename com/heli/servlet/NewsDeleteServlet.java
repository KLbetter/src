package com.heli.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heli.News;
import com.heli.dao.NewsDao;

@WebServlet("/NewsDeleteServlet")
public class NewsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String title = request.getParameter("title");
		News ne=new News();
		ne.setTitle(title);
		NewsDao n=new NewsDao();
		if(n.delete(title)){
			request.setAttribute("info", "�ɹ�ɾ����");
			request.getRequestDispatcher("NewsDelete.jsp").forward(request, response);
		}
		else 
			{request.setAttribute("info1", "ɾ��ʧ�ܣ�������û��������ȷ�ı���");
			request.getRequestDispatcher("NewsDelete.jsp").forward(request, response);}
		}
	}


