<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト - 本当に出ていくの？</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Creepster&display=swap');
	body {
    margin: 0;
    height: 100vh;
    background: linear-gradient(135deg, #220000, #660000);
    color: #ff0000;
    font-family: 'Creepster', cursive, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    user-select: none;
  }
  h1 {
    font-size: 5rem;
    text-shadow:
       0 0 5px #ff0000,
       0 0 10px #ff0000,
       0 0 20px #ff0000,
       0 0 40px #ff0000;
    margin-bottom: 20px;
  }
  p {
    font-size: 1.8rem;
    margin-bottom: 40px;
    text-shadow: 0 0 8px #ff0000;
  }
  button {
    background: #8b0000;
    border: 3px solid #ff0000;
    color: #ff4444;
    font-size: 2rem;
    padding: 15px 60px;
    cursor: pointer;
    box-shadow:
      0 0 10px #ff0000,
      0 0 20px #ff0000,
      0 0 30px #ff0000;
    transition: transform 0.2s ease, box-shadow 0.2s ease;
  }
  button:hover {
    animation: shake 0.5s;
    box-shadow:
      0 0 20px #ff5555,
      0 0 40px #ff5555,
      0 0 60px #ff5555;
    color: #fff;
  }
  @keyframes shake {
    0%, 100% { transform: translateX(0); }
    20%, 60% { transform: translateX(-10px); }
    40%, 80% { transform: translateX(10px); }
  }
</style>
</head>
<body>
	<h1>警告</h1>
  <p>本当にこの闇から抜け出す？<br>ログアウトすると戻れないぞ…</p>
  
  <form action="TodoLogin.jsp" method="post">
    <button type="submit">ログアウト</button>
  </form>
  
  <form action = "TodoLogin.jsp" method="post">
  	<button type ="submit">再ログイン</button>
  </form>
</body>
</html>