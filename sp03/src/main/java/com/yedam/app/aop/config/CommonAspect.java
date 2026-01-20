package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yedam.app.emp.service.EmpVO;

// AOP 사용 선언
@Aspect
//@Component
public class CommonAspect {
	// 포인트 컷: 조인포인트 중에서 Advice(횡단관심)이 적용될 메서드 필터
	@Pointcut("execution(* com.yedam..*Impl.*(..))")
	public void allpointcut() {
	}

	// Weaving: 포인트 컷 + 타이밍 + Advice(횡단관심)
	@Before("allpointcut()")
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		EmpVO empVO = (EmpVO) jp.getArgs()[0];
		System.out.println();
		System.out.println("[Before] [사전처리] beforeLog : " + methodName);
		System.out.println("[Before] [사전처리] beforeLog : " + empVO.toString());
		System.out.println();
	}

	@Around("allpointcut()")
	public Object excuteTimr(ProceedingJoinPoint joinPoint) throws Throwable {
		String signaterStr = joinPoint.getSignature().toString();

		System.out.println();
		System.out.println("[Around] [핵심 기능 전 실행] " + System.currentTimeMillis());
		System.out.println("[Around] [핵심 기능 전 실행] " + signaterStr);

		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			System.out.println("[Around] [핵심 기능 후 실행] " + System.currentTimeMillis());
			System.out.println();
		}
	}

}
