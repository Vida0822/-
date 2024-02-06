package org.doit.ik.aop3.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class LogPrintAroundAdvice3 implements MethodInterceptor{ // 보조 기능 처리

	// 스프링 AOP : 메서드 호출
	// calc.add() 보조 기능 장착 + 로그 기록
	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		
		String methodName = method.getMethod().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() start");
		StopWatch sw = new StopWatch();
		sw.start();
		
		// 핵심 관심 사항
		Object result = method.proceed(); // calc.add()
		
		sw.stop();
		log.info("> " + methodName + "() end");
		log.info("> " + methodName + "() 처리시간 : " + sw.getTotalTimeMillis() + "ms");		
		
		return result;
	}
	
}
