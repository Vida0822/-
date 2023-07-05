package org.doit.ik;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.doit.ik.mapper.scott.EmpMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
 

@Controller
@Log4j 
@RequestMapping("/scott/*") // 클래스 위에 이렇게 매핑을 주면 밑에 scott 지워도 됨
public class ScottController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
//	@Setter(onMethod=@__({@Autowired}))
	@Autowired
	private DeptMapper deptMapper ;
	
	@Autowired
	private EmpMapper empMapper ;

	@GetMapping("/dept") 	//@RequestMapping(value = "/scott/dept", method = RequestMethod.GET)
	public void dept(Locale locale, Model model) { // 핸들러 
		log.info(">/dept get...");
		List<DeptDTO> list = this.deptMapper.selectDept() ; // this == ScottController 
	// 	list.forEach(dto -> log.info(dto)); 
		model.addAttribute("list", list);  // request.setAttribute() 대체 
	} // dept
	
	
	@PostMapping("/emp")   //@RequestMapping(value = "/scott/emp", method = RequestMethod.GET)
// ?deptno=10&deptno=20 
//	public void emp(String[] deptnos) {  // request.getParameterAll() 대신 이걸로 
//	public void emp(ArrayList<Integer> deptnos ) { // 자료형도 맘대로 바꿔서, 담는 방식도 다양하게 파라미터값을 얻어올 수 있다
	public String emp(@RequestParam(value="deptno") ArrayList<Integer> deptnos, Model model) { // 넘겨져 오는 parameter 값들 중 name인 deptno 인 애들을 ArrayList로 받겠다 (파라미터 지정도 가능) 
		log.info(">/emp post...");
		List<EmpDTO> list = this.empMapper.selectEmp(deptnos);
		model.addAttribute("list", list);
		return "/scott/emp" ; 
	} // emp
 	
}
