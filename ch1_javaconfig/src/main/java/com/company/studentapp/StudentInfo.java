package com.company.studentapp;

public class StudentInfo {
	private Student student;

	private void StudentInfo() {
		System.out.println("StudentInfo ��ü ���� - �⺻������");

	}
	public StudentInfo(Student student) {
		super();
		this.student = student;
		System.out.println("StudentInfo ��ü ���� - ���ڸ� �޴� ������");
	}
	
	public void setStudent(Student student) {
		this.student = student;
		System.out.println("Student ��ü ���� - setter");
	}
	
	public void getStudentInfo() {
		if(student!=null) {
			System.out.println("=========================");
			System.out.println("�̸� : "+student.getName());
			System.out.println("���� : "+student.getAge());
			System.out.println("�г� : "+student.getGradeName());
			System.out.println("�� : "+student.getClassNum());
			System.out.println("=========================");
		}
	}
}
