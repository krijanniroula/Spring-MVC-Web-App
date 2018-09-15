package com.krijan.springapp.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krijan.springapp.POJOModel.Enum_district;

public interface DistrictInterface extends JpaRepository<Enum_district, String>{
	
	
	
}
