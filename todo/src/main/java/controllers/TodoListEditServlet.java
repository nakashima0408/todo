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
 * Servlet implementation class TodoListEditServlet
 */
@WebServlet("/TodoListEditServlet")
public class TodoListEditServlet extends HttpServlet {
	private TodoListAcsess tla = new TodoListAcsess();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");// URLパラメータ「id」を取得
		if(idStr == null){			// idが無ければ一覧へリダイレクト
			response.sendRedirect("TodoListServlet");
			return;
		}
		
		int id = Integer.parseInt(idStr);// idをintに変換
		Todo todo = tla.getTaskById(id);// サービスから該当タスクを取得
		if(todo == null) {
			response.sendRedirect("TodoListServlet");// タスクがなければリダイレクト
			return;
		}
		
		request.setAttribute("todo", todo);// 取得したタスクをリクエスト属性にセット
		//setAttribute(String name, Object o) は、リクエストオブジェクトに
		//任意の名前（name）でデータ（o）を保存（属性としてセット）するメソッドです。
		request.getRequestDispatcher("TodoListEdit.jsp").forward(request, response);// 編集用JSPへ
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
        String deadlineStr = request.getParameter("deadline");
        String assignee = request.getParameter("assignee");
        String completedStr = request.getParameter("completed");

        boolean completed = "true".equals(completedStr);

        Date deadline = null;
        
        try {
        	java.util.Date parsed = new SimpleDateFormat("yyyy-MM-dd").parse(deadlineStr);
            deadline = new Date(parsed.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Todo todo = new Todo(id, name, deadline, assignee, completed);
        tla.updateTask(todo);
        
        response.sendRedirect("TodoListServlet");
	}

}