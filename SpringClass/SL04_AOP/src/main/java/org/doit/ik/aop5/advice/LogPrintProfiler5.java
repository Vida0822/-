package org.doit.ik.aop5.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("logPrintProfiler5")
@Aspect
public class LogPrintProfiler5 {
	
	// <aop:pointcut expression="execution(* org.doit.ik.aop..*.*(*,*))" id="publicMethod"/>
	@Pointcut("execution(* org.doit.ik.aop..*.*(*,*))")
	private void publicMethod() {}

	// 1. AroundAdvice p222
	@Around("publicMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();
		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() start");
		StopWatch sw = new StopWatch();
		sw.start();
		
		// 핵심 관심 사항
		Object result = joinPoint.proceed(); // calc.add()
		
		sw.stop();
		log.info("> " + methodName + "() end");
		log.info("> " + methodName + "() 처리시간 : " + sw.getTotalTimeMillis() + "ms");		
		
		return result;
	}
	
	// 2. BeforeAdvice
	@Before("publicMethod()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() : LogPrintProfiler5.before 호출됨");
	}
	
	// 3. AfterAdvice
	@After("publicMethod()")
	public void afterFinally(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() : LogPrintProfiler5.afterFinally 호출됨");
	}
	
}
