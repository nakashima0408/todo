package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if ("root".equals(username) && "root".equals(password)) {
        	//認証成功した場合、ここでユーザー用のセッションを取得または生成します。
        	//getSession() は現在のセッションを返すか、なければ新しく作ります。
        	//セッションはブラウザごとに一時的にサーバー側でユーザー情報を保持する仕組み。
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            //ログイン成功後、ユーザーをタスクリスト表示のサーブレットにリダイレクトします。
            //sendRedirect はクライアントに別URLへの再アクセスを促すHTTPレスポンスを返します。
            //これにより、ブラウザは「TodoListServlet」に再度リクエストし、ログイン後の画面を表示します。
            response.sendRedirect("TodoListServlet");
        }else {
        	request.setAttribute("error", "ユーザー名またはパスワードが違います。");
        	request.getRequestDispatcher("TodoLogin.jsp").forward(request, response);
        }
            
	}

}
