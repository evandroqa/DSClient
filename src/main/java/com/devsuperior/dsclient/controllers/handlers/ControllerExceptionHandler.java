package com.devsuperior.dsclient.controllers.handlers;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dsclient.dto.MsgErrorDTO;
import com.devsuperior.dsclient.dto.ValidFieldErrorDTO;
import com.devsuperior.dsclient.services.exceptions.ServiceExceptionNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ServiceExceptionNotFound.class)
	public ResponseEntity<MsgErrorDTO> resouceNotFound(ServiceExceptionNotFound e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		MsgErrorDTO err = new MsgErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MsgErrorDTO> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidFieldErrorDTO err = new ValidFieldErrorDTO(Instant.now(), status.value(), "Corrija os erros !", request.getRequestURI());
		
		e.getBindingResult().getFieldErrors().forEach(f -> err.addError(f.getField(), f.getDefaultMessage()));
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<MsgErrorDTO> database(DataIntegrityViolationException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		MsgErrorDTO err = new MsgErrorDTO(Instant.now(), status.value(), "Existe outro Cliente com esse CPF !", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
