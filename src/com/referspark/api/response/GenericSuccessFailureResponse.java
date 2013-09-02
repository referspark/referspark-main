package com.referspark.api.response;

public class GenericSuccessFailureResponse implements GenericResponse{
	private boolean success = false;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
