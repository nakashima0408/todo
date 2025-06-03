package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import services.User;
import services.UserAccess;

/**
 * Servlet implementation class TodoLoginServlet
 */
@WebServlet("/TodoLoginServlet")
public class TodoLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stubzi 
        response.sendRedirect("TodoLogin.jsp");
    }
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserAccess ua = new UserAccess();
        User user = ua.findUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("TodoListServlet");
        } else {
            request.setAttribute("errorMsg", "ユーザー名またはパスワードが違います。");
            request.getRequestDispatcher("TodoLogin.jsp").forward(request, response);
        }
    }
}