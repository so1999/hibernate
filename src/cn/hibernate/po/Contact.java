package cn.hibernate.po;

public class Contact {
	private String postcode;
	private String phone;
	
	@Override
	public String toString() {
		return "Contact [postcode=" + postcode + ", phone=" + phone
				+ "]";
	}
	public Contact(){
		
	}
	public Contact(String postcode, String phone) {
		this.postcode = postcode;
		this.phone = phone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
