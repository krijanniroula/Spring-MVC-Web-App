package com.krijan.springapp.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krijan.springapp.POJOModels.Enum_district;
import com.krijan.springapp.interfaces.DistrictInterface;

@Controller
public class DistrictCrudOperation {
	@Autowired
	private DistrictInterface districtInterface;
	
	@GetMapping("/districts")
	@ResponseBody
	public List<Enum_district> retrieveAllZone() {
		return districtInterface.findAll();
	}
	
	@DeleteMapping("/districts/{enum_district}")
	@ResponseBody
	public void deleteStudent(@PathVariable String enum_district) {
		districtInterface.deleteById(enum_district);
	}
	
	@PostMapping("/districts")
	public void createStudent(@RequestBody Enum_district enum_district) {
		districtInterface.save(enum_district);

	}
	@PutMapping("/districts/{enum_district}")
	public void updateZone(@RequestBody Enum_district district, @PathVariable String enum_district) {

		districtInterface.findById(enum_district);

		district.setEnum_district(enum_district);
		
		districtInterface.save(district);

	}

}
