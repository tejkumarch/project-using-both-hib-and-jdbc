package com.dxc.beans;

public class Mark {
	String examid;
	int studentid;
	int mark1;
	int mark2;
	int mark3;
	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mark(String examid, int studentid, int mark1, int mark2, int mark3) {
		super();
		this.examid = examid;
		this.studentid = studentid;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public int getMark3() {
		return mark3;
	}
	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	@Override
	public String toString() {
		return "Mark [examid=" + examid + ", studentid=" + studentid + ", mark1=" + mark1 + ", mark2=" + mark2
				+ ", mark3=" + mark3 + "]";
	}
	
	

}
