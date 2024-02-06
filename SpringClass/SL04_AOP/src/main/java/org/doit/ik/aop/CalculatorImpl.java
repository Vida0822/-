package org.doit.ik.aop;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int x, int y) {
		long start = System.nanoTime();
		int result = x + y; // 핵심 관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("> 덧셈 처리 시간 : %d ns\n", (end - start));
		return result;
	}

	@Override
	public int sub(int x, int y) {
		long start = System.nanoTime();
		int result = x - y; // 핵심 관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("> 뺄셈 처리 시간 : %d ns\n", (end - start));
		return result;
	}

	@Override
	public int mult(int x, int y) {
		long start = System.nanoTime();
		int result = x * y; // 핵심 관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("> 곱셈 처리 시간 : %d ns\n", (end - start));
		return result;
	}

	@Override
	public int div(int x, int y) {
		long start = System.nanoTime();
		int result = x / y; // 핵심 관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("> 나눗셈 처리 시간 : %d ns\n", (end - start));
		return result;
	}

}
