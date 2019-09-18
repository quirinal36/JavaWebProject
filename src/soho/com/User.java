package soho.com;

import java.util.logging.Logger;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.JSONException;
import org.json.JSONObject;

public class User {
	int id;
	String login;
	String password;
	String phone;
	String email;
	String address;
	String username;

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
	
	public static User parse(JSONObject input) {
		User user = new User();
		if(input.has("address")) {
			try {
				user.setAddress(input.getString("address"));
			}catch(JSONException e) {
				e.printStackTrace();
			}
		}
		if(input.has("email")) {
			try {
				user.setEmail(input.getString("email"));
			}catch(JSONException e) {
				e.printStackTrace();
			}
		}
		if(input.has("login")) {
			try {
				user.setLogin(input.getString("login"));
			}catch(JSONException e) {
				e.printStackTrace();
			}
		}
		if(input.has("phone")) {
			try {
				user.setPhone(input.getString("phone"));
			}catch(JSONException e) {
				e.printStackTrace();
			}
		}
		if(input.has("username")) {
			try {
				user.setUsername(input.getString("username"));
			}catch(JSONException e) {
				e.printStackTrace();
			}
		}
		if(input.has("password")) {
			try {
				user.setPassword(input.getString("password"));
			}catch(JSONException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}
