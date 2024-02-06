package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 기본생성자 
@NoArgsConstructor  // 모든 필드 사용한 생성자 

public class DeptDTO {
	private int deptno ;
	private String dname;
	private String loc ; 
	
	private int numberOfEmps; // 사원수 (조인해서 얻은 칼럼도 dto에 포함해도 된다) 
}
