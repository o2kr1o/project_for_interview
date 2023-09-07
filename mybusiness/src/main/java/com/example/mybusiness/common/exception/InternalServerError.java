package com.example.mybusiness.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/** HTTP500エラー用クラス */
public class InternalServerError extends ResponseStatusException {

	public InternalServerError(HttpStatus status, String reason) {
		super(status, reason);
	}

}
