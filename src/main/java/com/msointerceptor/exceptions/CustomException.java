package com.msointerceptor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomException extends RuntimeException {
	
	    private String resourceName;
	    private String fieldName;
	    private Object fieldValue;
	    private Object httpStatus;

	   
	    public CustomException( String resourceName, String fieldName, Object fieldValue,HttpStatus httpStatus) {
	        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue,httpStatus ));
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	        this.fieldValue = fieldValue;
	        this.httpStatus = httpStatus;
	    }

	    public String getResourceName() {
	        return resourceName;
	    }

	    public String getFieldName() {
	        return fieldName;
	    }

	    public Object getFieldValue() {
	        return fieldValue;
	    }

		public Object getHttpStatus() {
			return httpStatus;
		}

		public void setHttpStatus(Object httpStatus) {
			this.httpStatus = httpStatus;
		}

}
