package com.yucaijr.form;

public class CommentForm {

	private String username;
	
	private String createTime;
	
	private String message;
	
	private String taskName;
	
	

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommentForm(String username, String createTime, String message,String taskName) {
		super();
		this.username = username;
		this.createTime = createTime;
		this.message = message;
		this.taskName=taskName;
	}
	
	
}
