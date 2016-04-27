package com.heli.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heli.News;
import com.heli.dao.NewsDao;

@WebServlet("/NewsUpdateServlet")
public class NewsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String id1= request.getParameter("id");
		int id=Integer.parseInt(id1);
	    String title = request.getParameter("title");
	    String content = request.getParameter("contnet");
	    String type = request.getParameter("type");
	    String name = request.getParameter("name");
	    News ne=new News();
	    ne.setId(id);
	    ne.setTitle(title);
	    ne.setContent(content);
	    ne.setType(type);
	    ne.setName(name);
	    NewsDao n=new NewsDao();
	    if(n.update(ne)){
	    	request.setAttribute("info", "成功修改！");
			request.getRequestDispatcher("NewsUpdate.jsp").forward(request, response);
		}
		else 
			{request.setAttribute("info1", "修改失败");
			request.getRequestDispatcher("NewsUpdate.jsp").forward(request, response);}
	    }
	    
	    
	    
	    
	}


