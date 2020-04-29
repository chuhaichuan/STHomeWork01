package com.itheima;

public class Student {
	//学号
	private String id;
	//姓名
	private String name;
	//班级
	private String classRoom;
	//科目
	private String subject;
	
	//成绩
	private float result;
	
	public Student() {
		
	}

	

	public Student(String id, String name, String classRoom, String subject, float result) {
		super();
		this.id = id;
		this.name = name;
		this.classRoom = classRoom;
		this.subject = subject;
		this.result = result;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	public float getResult() {
		return result;
	}



	public void setResult(float result) {
		this.result = result;
	}

	
	
}
