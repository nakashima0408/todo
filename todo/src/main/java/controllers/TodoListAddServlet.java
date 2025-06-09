package controllers;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class TodoListAddServlet
 */
@WebServlet("/TodoListAddServlet")
public class TodoListAddServlet extends HttpServlet {
	 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//URLで TodoListAddServlet にアクセスすると TodoListAdd.jsp が表示される仕組み
		request.getRequestDispatcher("TodoListAdd.jsp").forward(request, response);
	}

	//タスク新規作成フォームから送られたデータを処理して、DBに追加します。
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);

		request.setCharacterEncoding("UTF-8");
		
		if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("TodoLogin.jsp");
             return;
        }

		//name, deadline, assignee, completed は、フォームで入力された値。
		String name = request.getParameter("name");
		String deadlineStr = request.getParameter("deadline");
        String assignee = request.getParameter("assignee");
        String completedStr = request.getParameter("completed");
        
        //取得した completedStr（文字列）を論理値（boolean）に変換しています。
        boolean completed = "true".equals(completedStr);
        Date deadline = null;
        
        try {
        	deadline = Date.valueOf(deadlineStr); // yyyy-MM-dd形式前提
        }catch(IllegalArgumentException e) {
        	e.printStackTrace();
        }
        
        User user = (User) session.getAttribute("user");
        
        //空の Todo オブジェクトを作成し、フォームから取得した値をセットしています。
        Todo newTodo = new Todo();
        newTodo.setName(name);
        newTodo.setDeadline(deadline);
        newTodo.setAssignee(assignee);
        newTodo.setCompleted(completed);
        newTodo.setUserId(user.getId());  // ユーザーIDをセット

        TodoListAcsess tla = new TodoListAcsess();
        tla.insertTask(newTodo);
        
        response.sendRedirect("TodoListServlet");
	}

}