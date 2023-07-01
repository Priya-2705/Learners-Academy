package mypackage.models;

public class LoginModel {
	
	private String username;
	private String password;
	
	public LoginModel() {
		// TODO Auto-generated constructor stub
	}

	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
