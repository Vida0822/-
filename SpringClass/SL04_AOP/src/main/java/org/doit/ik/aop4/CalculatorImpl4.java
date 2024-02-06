package org.doit.ik.aop4;

import org.doit.ik.aop.Calculator;
import org.springframework.stereotype.Component;

@Component("calc4")
public class CalculatorImpl4 implements Calculator {

	// 공통 관심 사항 제거
	@Override
	public int add(int x, int y) {
		// 전				
		int result = x + y; // 핵심 관심 사항(core concern)
		// 후
		return result;
	}

	@Override
	public int sub(int x, int y) {
		// 전
		int result = x - y; // 핵심 관심 사항(core concern)
		// 후
		return result;
	}

	@Override
	public int mult(int x, int y) {
		// 전
		int result = x * y; // 핵심 관심 사항(core concern)
		// 후
		return result;
	}

	@Override
	public int div(int x, int y) {
		// 전
		int result = x / y; // 핵심 관심 사항(core concern)
		// 후
		return result;
	}

}
