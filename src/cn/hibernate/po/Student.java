package cn.hibernate.po;

import java.util.Date;

public class Student {
	private int id;
	private String username;
	private Date birthday;
	private String address;
	private String detail;
	private float score;

	public Student() {

	}

	public Student(int id, String username, Date birthday, String address,
			String detail, float score) {
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.address = address;
		this.detail = detail;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username
				+ ", birthday=" + birthday + ", address="
				+ address + ", detail=" + detail + ", score="
				+ score + "]";
	}

}
