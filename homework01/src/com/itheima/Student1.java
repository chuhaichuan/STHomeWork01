package com.itheima;

public class Student {
	//ѧ��
	private String id;
	//����
	private String name;
	//�༶
	private String classRoom;
	//��Ŀ
	private String subject;
	
	//�ɼ�
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
