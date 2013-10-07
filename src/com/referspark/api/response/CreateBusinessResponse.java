package com.referspark.api.response;

public class CreateBusinessResponse extends GenericSuccessFailureResponse{

	private int generatedBusinessId = -1;

	public int getGeneratedBusinessId() {
		return generatedBusinessId;
	}

	public void setGeneratedBusinessId(int generatedBusinessId) {
		this.generatedBusinessId = generatedBusinessId;
	}
	
}
