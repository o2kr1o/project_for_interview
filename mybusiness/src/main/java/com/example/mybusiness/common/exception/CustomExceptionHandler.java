package com.example.mybusiness.common.exception;

import static com.example.mybusiness.common.constants.EnumConstants.*;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

/** エラーハンドリング共通化クラス */
@ControllerAdvice
public class CustomExceptionHandler {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<CustomErrorResponse> UnprocessableEntityExceptionHandler(Exception ex, WebRequest request) {
		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

		logger.error(UNPROCESSABLE_ENTITY.getValue());

		return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<CustomErrorResponse> InternalServerErrorHandler(Error er, WebRequest request) {
		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(er.getMessage());
		errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

		logger.error(INTERNAL_SERVER_ERROR.getValue());

		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	public ResponseEntity<CustomErrorResponse> HttpMessageNotReadableExceptionHandler(Exception ex,
			WebRequest request) {
		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());

		logger.error(BAD_REQUEST.getValue());

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NoHandlerFoundException.class })
	public ResponseEntity<CustomErrorResponse> NoHandlerFoundExceptionHandler(Exception ex, WebRequest request) {
		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.NOT_FOUND.value());

		logger.error(NOT_FOUND.getValue());

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<CustomErrorResponse> HttpRequestMethodNotSupportedExceptionHandler(Exception ex,
			WebRequest request) {
		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());

		logger.error(METHOD_NOT_ALLOWED.getValue());

		return new ResponseEntity<>(errors, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
	public ResponseEntity<CustomErrorResponse> HttpMediaTypeNotSupportedExceptionHandler(Exception ex,
			WebRequest request) {
		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());

		logger.error(UNSUPPORTED_MEDIA_TYPE.getValue());

		return new ResponseEntity<>(errors, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

}
