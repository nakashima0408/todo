<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ユーザー登録</title>
	<link rel="stylesheet" href="css/todo.list.css">
 	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
  		rel="stylesheet">
	<style>
		body {
            background-color: #fff0f5;
        }
        h2 {
            margin-top: 30px;
            margin-bottom: 20px;
        }
	</style>
</head>
<body>
	 <div class="d-flex justify-content-center align-items-center vh-100">
    <div class="card p-4" style="min-width: 320px; max-width: 400px; width: 100%;">
      <h2 class="mb-4 text-center">ユーザー登録</h2>
      <form action="TodoListUserCreateServlet" method="post">
        <div class="mb-3">
          <label for="username" class="form-label">ユーザー名：</label>
          <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">パスワード：</label>
          <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">登録</button>
      </form>
      <p class="mt-3 text-center"><a href="TodoLogin.jsp">ログインはこちら</a></p>
    </div>
  </div>
</body>
</html>
<!--d-flex justify-content-center align-items-center vh-100
→ 画面全体の高さ（viewport height 100%）の中で縦横中央揃えを実現

card p-4
→ Bootstrapのカード風ボックス＋余白パディング

min-width, max-widthでフォームの幅を制限し、スマホでも見やすく

Bootstrapのフォームクラス (form-control, form-label, btn) を使って見た目を整える

w-100 で登録ボタンをフォーム幅いっぱいに伸ばす

タイトルやリンクは text-center で中央寄せ  -->

