<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>タスク詳細・編集 | ToDo管理</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
		body {
            background-color: #FFA500;
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
<div class="container mt-5">
    <h2>タスク詳細・編集</h2>
    <form action="TodoListEditServlet" method="post">
        <input type="hidden" name="id" value="${todo.id}">
        <div class="mb-3">
            <label for="name" class="form-label">タスク名</label>
            <input type="text" class="form-control" id="name" name="name" value="${todo.name}" required>
        </div>
        <div class="mb-3">
            <label for="deadline" class="form-label">期限</label>
            <input type="date" class="form-control" id="deadline" name="deadline" value="${todo.deadline}" required>
        </div>
        <div class="mb-3">
            <label for="assignee" class="form-label">担当者</label>
            <input type="text" class="form-control" id="assignee" name="assignee" value="${todo.assignee}" required>
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="completed" name="completed" value="true" ${todo.completed ? "checked" : ""}>
            <label class="form-check-label" for="completed">完了済み</label>
        </div>
        <button type="submit" class="btn btn-primary">更新</button>
        <a href="TodoListServlet" class="btn btn-secondary">戻る</a>
    </form>
</div>
</body>
</html>