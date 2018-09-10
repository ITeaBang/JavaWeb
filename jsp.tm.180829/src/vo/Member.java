package vo;

import java.util.Date;

public class Member {

	protected String id;
	protected String password;
	protected String name;
	protected Date birthday;
	protected String phone;
	protected String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public Member(String id, String password, String name, Date birthday, String phone, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
	}
	public Member() {
		super();
 	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", birthday=" + birthday + ", phone="
				+ phone + ", address=" + address + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
