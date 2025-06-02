<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="services.Todo" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	 <title>タスク一覧 | ToDo管理</title>
 	 <link rel="stylesheet" href="css/todo.list.css">
 	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
  		rel="stylesheet">
	<style>
		body {
            background-color: #008000;
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
	</style>
</head>
<body>
	<div class="container">
  		<h2>タスク一覧</h2>
  			<table class="table table-striped table-hover">
    			<thead>
      				<tr><th>状態</th><th>タスク名</th><th>期限</th><th>担当者</th><th>進捗</th></tr>
    			</thead>
    				<tbody>
     					 <c:choose>
     					 	
        					<c:when test="${not empty todos}"> <!--List<Todo> todos = tla.getAllTask();  --> 
            					<c:forEach var="t" items="${todos}">
               						 <tr>
                   						<td><input type="checkbox" ${t.completed ? 'checked' : ''} disabled></td>
                   						 <td><a href="TodoListEditServlet?id=${t.id}">${t.name}</a></td>
                    					<td>${t.deadline}</td>
                    					<td>${t.assignee}</td>
                    					<td>${t.completed}</td>
               						 </tr>
           						 </c:forEach>
       						 </c:when>
        					<c:otherwise>
            				<tr><td colspan="4">タスクが見つかりません</td></tr>
        					</c:otherwise>
    					</c:choose>
   					 </tbody>
 			 </table>
  		<a href="TodoListAddServlet" class="btn btn-success">新規作成</a>
  		<a href="TodoLogout" class="btn btn-dark">ログアウト</a>
</div>
</body>
</html>