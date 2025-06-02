package controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import services.Todo;
import services.TodoListAcsess;

/**
 * Servlet implementation class TodoListAddServlet
 */
@WebServlet("/TodoListAddServlet")
public class TodoListAddServlet extends HttpServlet {
	 private TodoListAcsess tla = new TodoListAcsess();

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 新規作成フォーム表示のためのGETリクエストは taskCreate.jsp にフォワード
		request.getRequestDispatcher("TodoListAdd.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String deadlineStr = request.getParameter("deadline");
        String assignee = request.getParameter("assignee");
        String completedStr = request.getParameter("completed");
        
        //取得した completedStr（文字列）を論理値（boolean）に変換しています。
        boolean completed = "true".equals(completedStr);
        
        Date deadline = null;
        
        try {
        	java.util.Date parsed = new SimpleDateFormat("yyyy-MM-dd").parse(deadlineStr);
        	deadline = new Date(parsed.getTime());
        }catch(ParseException e) {
        	e.printStackTrace();
        }
		
        //空の Todo オブジェクトを作成し、フォームから取得した値をセットしています。
        Todo newTodo = new Todo();
        newTodo.setName(name);
        newTodo.setDeadline(deadline);
        newTodo.setAssignee(assignee);
        newTodo.setCompleted(completed);
        
        tla.insertTask(newTodo);
        
        response.sendRedirect("TodoListServlet");
	}

}
