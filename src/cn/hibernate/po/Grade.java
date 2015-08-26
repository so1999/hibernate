package cn.hibernate.po;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grade {
	private int gid;
	private String gname;
	private String gdesc;
	private Set<Student> student=new HashSet<Student>();
	public Grade(){
		
	}
	
	

	public Set<Student> getStudent() {
		return student;
	}



	public void setStudent(Set<Student> student) {
		this.student = student;
	}



	public Grade(int gid, String gname, String gdesc) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
	}

	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
}
