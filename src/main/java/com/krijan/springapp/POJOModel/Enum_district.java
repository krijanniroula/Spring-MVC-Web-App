package com.krijan.springapp.POJOModel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enum_district {

	@Id
	private String enum_district;

	public String getEnum_district() {
		return enum_district;
	}

	public void setEnum_district(String enum_district) {
		this.enum_district = enum_district;
	}



}
