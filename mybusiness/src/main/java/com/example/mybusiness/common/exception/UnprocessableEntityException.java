package com.example.mybusiness.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/** HTTP422エラー用クラス */
public class UnprocessableEntityException extends ResponseStatusException {

	public UnprocessableEntityException(HttpStatus status, String reason) {
		super(status, reason);
	}

}
