package com.krijan.springapp.POJOModel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enum_zone {

	@Id
	private String enum_zone;

	public String getEnum_zone() {
		return enum_zone;
	}


	public void setEnum_zone(String enum_zone) {
		this.enum_zone = enum_zone;
	}

	
}
