package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import services.UserAccess;

/**
 * Servlet implementation class TodoListUserCreateServlet
 */
@WebServlet("/TodoListUserCreateServlet")
public class TodoListUserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean success = new UserAccess().CreateUser(username, password);
		
		if(success) {
			response.sendRedirect("TodoLogin.jsp");
		}else {
			request.setAttribute("error", "ユーザー名が既に存在します。");
			request.getRequestDispatcher("TodoListUserCreate.jsp").forward(request, response);
		}
	}

}
