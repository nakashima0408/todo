package controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import services.Todo;
import services.TodoListAcsess;

/**
 * Servlet implementation class TodoListServlet
 */
@WebServlet("/TodoListServlet")//このURLでアクセスした時にこのServletが動く。

public class TodoListServlet extends HttpServlet {
	private TodoListAcsess tla = new TodoListAcsess();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Todo> todos = tla.getAllTask();        
		request.setAttribute("todos", todos);
		//TodoListAcsess クラスからタスクリストを取得し、JSPに渡している。
        RequestDispatcher rd = request.getRequestDispatcher("/TodoListAcsess.jsp");
        rd.forward(request, response);
        //TodoListAcsess.jsp に画面遷移（フォワード）する。
    }	

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}