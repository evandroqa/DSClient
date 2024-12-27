package com.devsuperior.dsclient.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidFieldErrorDTO extends MsgErrorDTO{

	private List<FieldValidMsgDTO> errors = new ArrayList<>();
	
	public ValidFieldErrorDTO(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public List<FieldValidMsgDTO> getErrorsField() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldValidMsgDTO(fieldName, message));
	}
}
