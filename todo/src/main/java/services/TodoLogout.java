package services;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TodoLogout {

	@WebServlet("/logout")
	public class LogoutServlet extends HttpServlet {
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession(false); // セッションがあれば破棄
	        if (session != null) {
	            session.invalidate();
	        }
	        response.sendRedirect("Todologin.jsp");
	    }
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
