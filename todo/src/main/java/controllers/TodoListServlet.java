package controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import services.Todo;
import services.TodoListAcsess;
import services.User;

/**
 * Servlet implementation class TodoListServlet
 */
@WebServlet("/TodoListServlet")//このURLでアクセスした時にこのServletが動く。

public class TodoListServlet extends HttpServlet {
	private TodoListAcsess tla = new TodoListAcsess();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		 if (session == null || session.getAttribute("user") == null) {
	            response.sendRedirect("TodoLogin.jsp");
	            return;
	        }

	        User user = (User) session.getAttribute("user");
	        TodoListAcsess tla = new TodoListAcsess();
	        List<Todo> todos = tla.getAllTaskByUser(user.getId());

	        request.setAttribute("todos", todos);
	        request.getRequestDispatcher("TodoListAcsess.jsp").forward(request, response);
    }	

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}