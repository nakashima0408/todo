<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>新規タスク作成 | ToDo管理</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    body {
            background-color: #8A2BE2;
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
    <h2>新規タスク作成</h2>
    <form action="TodoListAddServlet" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">タスク名</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="deadline" class="form-label">期限</label>
            <input type="date" class="form-control" id="deadline" name="deadline" required>
        </div>
        <div class="mb-3">
            <label for="assignee" class="form-label">担当者</label>
            <input type="text" class="form-control" id="assignee" name="assignee" required>
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="completed" name="completed" value="true">
            <label class="form-check-label" for="completed">完了済み</label>
        </div>
        <button type="submit" class="btn btn-primary">作成</button>
        <a href="TodoListServlet" class="btn btn-secondary">キャンセル</a>
    </form>
</div>
</body>
</html>