package member.service;

import java.util.Map;

public class JoinRequest {

	private String name;
	private String email ;
	private String confirmEmail ;
	private String password;
	private String confirmPassword;

	

	public JoinRequest() {
		super();
	}

	// getter , setter 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isPasswordEqualToConfirm() { // 비밀번호 확인란에 입력한 비밀번호 값이랑 일치하는지 확인
		return password != null && password.equals(confirmPassword);
	}

	public void validate(Map<String, Boolean> errors) {
		// 입력 여부 체크를 서버에서 하는거 (이전엔 js에서 구현해줌)
		/* checkEmpty(errors, id, "id"); */
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
