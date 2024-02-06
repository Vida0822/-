package org.doit.ik.mapper.scott;

import java.util.List;

import org.doit.ik.domain.DeptDTO;

public interface DeptMapper {
	
	List<DeptDTO> selectDept() ; 
	int insertDept(DeptDTO dto); 
	int deleteDept(int deptno); 
	
} // DeptMapper
