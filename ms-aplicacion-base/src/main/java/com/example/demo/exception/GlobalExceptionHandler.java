package com.example.demo.exception;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
		try {
			log.error(exception.getMessage(), exception);
			String mensajeError = null;
			Optional<ObjectError> ex = exception.getBindingResult().getAllErrors().stream().findFirst();
			if (ex.isPresent()) {
				mensajeError = messageSource.getMessage(ex.get().getDefaultMessage(),null, LocaleContextHolder.getLocale());
			}
			return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;

	}

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Object> handleException(DataAccessException exception) {
		try {
			log.error("Error en BD",
					new String[] {
							exception.getMessage().concat(":").concat(exception.getMostSpecificCause().getMessage()) },
					LocaleContextHolder.getLocale(), exception);

			return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		try {
			log.error("Error general:" + exception.getMessage(), exception);
			return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}
