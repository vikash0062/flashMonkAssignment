package com.flashmonk.onlinestore.exception;

import com.flashmonk.onlinestore.constants.OnlineStoreConstants;

/*
 * 
 * @author VIKASH130298@GMAIL.COM 
 * 
 * 
 */


public class OnlineStoreException extends Exception {
	
	private String errorMessage = OnlineStoreConstants.ERR_DEFAULT;

	

	public OnlineStoreException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnlineStoreException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
