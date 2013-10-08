package com.referspark.api.response;

public class GetExistingMiniBusinessResponse extends GenericSuccessFailureResponse{
   
	private int generatedBusinessId = -1;
	private String email;
	private String businessname;
	
	public int getGeneratedBusinessId() {
		return generatedBusinessId;
	}
	public void setGeneratedBusinessId(int generatedBusinessId) {
		this.generatedBusinessId = generatedBusinessId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	
}
