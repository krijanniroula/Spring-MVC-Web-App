package com.krijan.springapp.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krijan.springapp.POJOModels.Enum_zone;

public interface ZoneInterface extends JpaRepository<Enum_zone, String>{
	

}
