package SpringBoot_MysqlDB.com.spring.mysql.demo.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice
{

    @Around(value = "execution(* SpringBoot_MysqlDB.com.spring.mysql.demo.*.*.*(..))")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable
    {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=pjp.getSignature().getName();
        String className=pjp.getTarget().getClass().toString();
        Object[] array= pjp.getArgs();
        log.info("method invoked {} : {} ()  arguments : {}", className, methodName, mapper.writeValueAsString(array));
        Object object=pjp.proceed();
        log.info("{} : {} ()  Response : {}", className, methodName, mapper.writeValueAsString(object));

        return object;
    }
}
