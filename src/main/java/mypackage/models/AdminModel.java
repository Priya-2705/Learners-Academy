package mypackage.models;

public class AdminModel {

	private String username;
	private String password;

	public AdminModel() {
		// TODO Auto-generated constructor stub
	}

	public AdminModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	// Getters and Setters
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
