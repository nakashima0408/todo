<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.todo.model.Task" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	 <title>タスク一覧 | ToDo管理</title>
 	 <link rel="stylesheet" href="css/todo.list.css">
 	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
  		rel="stylesheet">
</head>
<body class="bg-dark-subtle">
	<div class="container">
  		<h2>タスク一覧</h2>
  			<table class="table table-striped table-hover">
    			<thead>
      				<tr><th>状態</th><th>タスク名</th><th>期限</th><th>担当者</th></tr>
    			</thead>
    				<tbody>
     					 <%
        					List<Task> tasks = (List<Task>) request.getAttribute("tasks");
        					for(Task t : tasks){
      						%>
      				<tr>
        				<td><input type="checkbox" <%= t.isCompleted() ? "checked" : "" %> disabled></td>
        				<td><a href="taskDetail?id=<%= t.getId() %>"><%= t.getName() %></a></td>
        				<td><%= t.getDeadline() %></td>
        				<td><%= t.getAssignee() %></td>
      				</tr>
     					 <% } %>
   					 </tbody>
 			 </table>
  		<a href="taskCreate" class="btn btn-success">新規作成</a>
  		<a href="logout" class="btn btn-dark">ログアウト</a>
</div>
</body>
</html>