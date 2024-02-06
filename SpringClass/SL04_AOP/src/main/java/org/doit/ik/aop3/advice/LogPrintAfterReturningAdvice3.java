package org.doit.ik.aop3.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

// 대상 객체가 핵심기능의 메서드를 예외없이 처리된 경우 호출되는 Advice
@Component
public class LogPrintAfterReturningAdvice3 implements AfterReturningAdvice {

	@Override
	public void afterReturning(
			Object returnValue // 결과값
			, Method method // 메서드
			, Object[] args // 매개변수
			, Object target // 대상객체
			) throws Throwable {
		
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() : LogPrintAfterReturningAdvice3 호출됨");
		
	}

}
