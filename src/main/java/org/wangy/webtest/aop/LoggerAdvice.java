package org.wangy.webtest.aop;

import org.aspectj.lang.JoinPoint;

public class LoggerAdvice {


    public void logBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }
}