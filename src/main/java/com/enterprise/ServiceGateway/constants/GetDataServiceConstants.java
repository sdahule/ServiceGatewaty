package com.enterprise.ServiceGateway.constants;

public enum GetDataServiceConstants {
	
	BASE_URL("http:localhostinte");
	
private String value;
	
	GetDataServiceConstants(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

}
