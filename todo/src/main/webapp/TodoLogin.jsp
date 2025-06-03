<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ログイン画面:Todo</title>
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	 <style>
		body {
            background-color: #FFFDD0;
        }
        h2 {
            margin-top: 30px;
            margin-bottom: 20px;
        }
        
        .table td, .table th {
            vertical-align: middle;
        }
        .badge {
            font-size: 0.9em;
        }
        .btn {
            margin-right: 10px;
        }
        .top-right-link {
    		position: absolute;   
    		top: 10px;            /* 上から10px */
    		right: 10px;          /* 右から10px */
    		font-weight: bold;    /* 好みで文字太く */
 		 }
	</style>
</head>
<body>
	<p class = "top-right-link">
	<a href="TodoListUserCreate.jsp">新規ユーザー登録</a>
	</p>
	
	<div class = "container mt-5">
		<h2 class = "mb-4">ログイン</h2>
		<form action="TodoLoginServlet" method = "post"><!--ログイン処理はサーブレット TodoLoginServlet が担当 -->
			<div class = "mb-3">
				<label for= "username" class = "form-label">ユーザー名</label>
				<input type ="text" class = "form-control" id="username" name="username" required>
			</div>
			
			<div class ="mb-3">
				 <label for="password" class="form-label">パスワード</label>
                <input type="password" class="form-control" id="password" name="password" required>
			</div>
			 <button type="submit" class="btn btn-primary">ログイン</button>	 
		</form>
		 <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">${error}</div>
        </c:if>
	</div>

</body>
</html>