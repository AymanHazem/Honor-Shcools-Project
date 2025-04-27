package com.ayman.Honor.Schools.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
public class LoggerAspect
{
    @Around("execution(* com.ayman.Honor.Schools..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable
    {
        log.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        Object returnObj = joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute " + joinPoint.getSignature().toString() + " method is : "+timeElapsed);
        log.info(joinPoint.getSignature().toString() + " method execution end");
        return returnObj;
    }

    @AfterThrowing(value = "execution(* com.ayman.Honor.Schools.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex)
    {
        log.error(joinPoint.getSignature()+ " An exception happened due to : "+ex.getMessage());
    }
}
