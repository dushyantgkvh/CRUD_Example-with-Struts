package com.witty.struts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	private ResponseEntity<ExceptionBody> handleNotFoundException(NotFoundException exception) {
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(exception.getMessage()), HttpStatus.NOT_FOUND);
	}

	class ExceptionBody {
		private String message;

		public ExceptionBody() {
		}

		public ExceptionBody(String message) {
			this.message = message;

		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "ExceptionBody [message=" + message + "]";
		}

	}
}
