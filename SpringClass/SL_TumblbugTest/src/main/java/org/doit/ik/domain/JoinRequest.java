package org.doit.ik.domain;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequest {

	private String name;
	private String email ;
	private String confirmEmail ;
	private String password;
	private String confirmPassword;


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
