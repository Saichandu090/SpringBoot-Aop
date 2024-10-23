package SpringBoot_MysqlDB.com.spring.mysql.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Slf4j
@Aspect
public class PerformanceLogger
{
    @Around("execution(* SpringBoot_MysqlDB.com.spring.mysql.demo.*.*.*(..))")
    public Object monitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start= System.currentTimeMillis();

        Object o=proceedingJoinPoint.proceed();
        long end=System.currentTimeMillis();

        log.info("Time taken : {}", end - start);
        return o;
    }
}
