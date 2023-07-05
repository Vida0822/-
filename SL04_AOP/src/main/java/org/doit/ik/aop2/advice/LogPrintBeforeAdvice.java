package org.doit.ik.aop2.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class LogPrintBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(
			Method method // add()
			, Object[] args // (4, 2)
			, Object target // 대상 객체(실제 객체 calc)
			) throws Throwable {
		
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() : LogPrintBeforeAdvice 호출됨");
		
	}

}
