package techbasics.soapservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

@Aspect
@Slf4j
public class SoapBoundaryLoggerAspect {
	@Around("execution(public * techbasics.soapservice.domain.service.*.*(..))")
	public Object logSoapApiCall(ProceedingJoinPoint pjp) throws Throwable {
		StringBuilder argsPattern = new StringBuilder();
		for (int i = 0; i < pjp.getArgs().length; i++) {
			argsPattern.append("{},");
		}
		argsPattern = new StringBuilder(
				StringUtils.isEmpty(argsPattern.toString()) ? argsPattern.toString() : argsPattern.substring(0, argsPattern.length() - 1));

		String method = pjp.getSignature().getName();

		log.info("Inbound: [method=" + method + (StringUtils.isEmpty(argsPattern.toString()) ? "]" : ", args=" + argsPattern + "]"), pjp.getArgs());

		try {
			Object response = pjp.proceed();
			log.info("Outbound: [method=" + method + (response == null ? "]" : ", response={}]"), response);
			return response;
		} catch (Throwable throwable) {
			log.error("Error in method " + pjp.getSignature().getName(), throwable);
			throw throwable;
		}
	}
}
