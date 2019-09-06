package soho.com;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User {
	int id;
	String login;
	String password;
	String phone;
	String email;
	String address;
	String username;

	public boolean signIn(User user) {
		System.out.println("로그인 했습니다.");
		return true;
	}
	
	public boolean signOut(User user) {
		System.out.println("로그아웃 했습니다.");
		return true;
	}
	
	public int signUp(User user) {
		System.out.println("회원가입 했습니다.");
		return 1;
	}
	
	public int edit(User user) {
		System.out.println(user.username + "님의 정보 변경 했습니다.");
		return 1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
