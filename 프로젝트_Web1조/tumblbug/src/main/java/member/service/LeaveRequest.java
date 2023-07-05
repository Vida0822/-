package member.service;

import java.util.Map;

public class LeaveRequest {

	private String email;
	private String password;
	
	public LeaveRequest() {
		super();
	}
	public LeaveRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, password, "password");
	}

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
	
}
