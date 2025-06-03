package controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class TodoListEditServlet
 */
@WebServlet("/TodoListEditServlet")
public class TodoListEditServlet extends HttpServlet {
	private TodoListAcsess tla = new TodoListAcsess();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		 HttpSession session = request.getSession(false);
		 if (session == null || session.getAttribute("user") == null) {
	            response.sendRedirect("TodoLogin.jsp");
	            return;
		 }
		 
		 User user = (User) session.getAttribute("user");
	        int id = Integer.parseInt(request.getParameter("id"));

	        TodoListAcsess tla = new TodoListAcsess();
	        Todo todo = tla.getTaskById(id, user.getId());

	        if (todo == null) {
	            response.sendRedirect("TodoListServlet");
	            return;
	        }

	        request.setAttribute("todo", todo);
	        request.getRequestDispatcher("TodoListEdit.jsp").forward(request, response);
	    }
		 
		 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("TodoLogin.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
        String deadlineStr = request.getParameter("deadline");
        String assignee = request.getParameter("assignee");
        String completedStr = request.getParameter("completed");
        boolean completed = "true".equals(completedStr);

        Date deadline = null;
        
        try {
        	java.util.Date parsed = new SimpleDateFormat("yyyy-MM-dd").parse(deadlineStr);
            deadline = new Date(parsed.getTime()); // ← java.sql.Dateに変換
        } catch (Exception e) {
            e.printStackTrace();
        }

        Todo todo = new Todo();
        todo.setId(id);
        todo.setName(name);
        todo.setDeadline(deadline);
        todo.setAssignee(assignee);
        todo.setCompleted(completed);
        todo.setUserId(user.getId());

        TodoListAcsess tla = new TodoListAcsess();
        tla.updateTask(todo);

        response.sendRedirect("TodoListServlet");
    }
}