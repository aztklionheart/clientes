package com.creditas.clientes.errorhandling;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;

import lombok.extern.java.Log;

@RestControllerAdvice
@Log
public class ErrorResolver {

	@ExceptionHandler(SQLException.class)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ErrorDescriptor resolveUncategorizedSqlException(HttpServletRequest request, SQLException e) {

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(request.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(BadSqlGrammarException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	public ErrorDescriptor resolveBadSqlGrammarException(HttpServletRequest req, BadSqlGrammarException e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		errorDescriptor.setError(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		errorDescriptor.setMessage("Incorrect SQL");
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(UncategorizedSQLException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorDescriptor resolveUncategorizedSqlException(HttpServletRequest request,
			UncategorizedSQLException e) {

		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.UNAUTHORIZED.value());
		errorDescriptor.setError(HttpStatus.UNAUTHORIZED.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(request.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorDescriptor resolveHttpMessageNotReadableException(HttpServletRequest req,
			HttpMessageNotReadableException e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		String message = e.getMessage();
		int index = message.indexOf(':');
		message = message.substring(0, index);

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setMessage(message);
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorDescriptor resolveMethodArgumentNotValidException(HttpServletRequest req,
			MethodArgumentNotValidException e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setPath(req.getRequestURI());

		Map<String, List<String>> groupedErrors = new HashMap<>();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			String message = fieldError.getDefaultMessage();
			String field = fieldError.getField();

			List<String> fieldsByMessage = groupedErrors.get(message);
			if (fieldsByMessage == null) {
				fieldsByMessage = new ArrayList<>();
				groupedErrors.put(message, fieldsByMessage);
			}
			fieldsByMessage.add(field);
		}

		if (!groupedErrors.isEmpty()) {
			errorDescriptor.setMessage(groupedErrors.toString());
		}

		return errorDescriptor;
	}
	//

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDescriptor resolveDataIntegrityViolationException(HttpServletRequest req,
			DataIntegrityViolationException e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());
		return errorDescriptor;
	}

	@ExceptionHandler(NoContentException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public @ResponseBody ErrorDescriptor resolveNoContentException(HttpServletRequest req, NoContentException e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.NO_CONTENT.value());
		errorDescriptor.setError(HttpStatus.NO_CONTENT.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDescriptor resolveNumberFormatException(HttpServletRequest req, NumberFormatException e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDescriptor resolveException(HttpServletRequest req, Exception e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDescriptor.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody

	public ErrorDescriptor resolveBadRequestException(HttpServletRequest req, Exception e) {
		log.info(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}
}