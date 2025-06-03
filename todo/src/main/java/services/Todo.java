package services;

import java.sql.Date;

public class Todo {

	private int id;
    private String name;
    private Date deadline;  // 例えば "2025-04-25"
    private String assignee;
    private boolean completed;
    
    public Todo() {
    	
    }
    
    public Todo(int id, String name, Date deadline, String assignee, boolean completed) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.assignee = assignee;
        this.completed = completed;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
    
    

}