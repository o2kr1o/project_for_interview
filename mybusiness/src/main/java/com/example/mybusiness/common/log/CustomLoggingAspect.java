package com.example.mybusiness.common.log;

import static com.example.mybusiness.common.constants.EnumConstants.LoggingAspectConstants.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/** ログ共通化クラス */
@Aspect
@Component
public class CustomLoggingAspect {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before(BIRTHDAY_INFO_CONTROLLER)
	public void commonStartLog(JoinPoint jp) {
		logger.info(START);
		logger.info(EXECUTE_METHOD_INFO + jp.getSignature().toString());
	}

	@Before(EXECUTE_GET_RELATED_INFO)
	public void postGetRelatedInfoLog(JoinPoint jp) {
		logger.info(EXECUTE_CALCULATE_RELATED_INFO);

	}

	@After(BIRTHDAY_INFO_CONTROLLER)
	public void commonEndLog(JoinPoint jp) {
		logger.info(END);
	}

}
