package services;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*") 
public class TodoAutoFilter implements Filter{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
		
		//ServletRequest や ServletResponse はフィルターの引数で、より一般的な型です。
		//WebではHTTPリクエスト・レスポンスがほとんどなので、具体的にHTTP用の型（HttpServletRequest / HttpServletResponse）にキャスト（型変換）しています。
		//これでHTTP特有のメソッド（getSession(), getRequestURI() など）が使えるようになります。

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String path = req.getRequestURI();
		HttpSession session = req.getSession(false);
		
		boolean loggedIn = session != null && session.getAttribute("user") != null;
		boolean loginRequest = path.contains("TodoLogin.jsp")||path.contains("TodoLoginServlet");
		
		if(loggedIn || loginRequest) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("TodoLogin.jsp");
		}
		
		
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
