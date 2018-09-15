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

import com.krijan.springapp.POJOModels.Enum_zone;
import com.krijan.springapp.interfaces.ZoneInterface;

@Controller
public class ZoneCrudOperation {
	
	@Autowired
	private ZoneInterface zoneInterface;
	
	@GetMapping("/zones")
	@ResponseBody
	public List<Enum_zone> retrieveAllZone() {
		return zoneInterface.findAll();
	}
	
	@DeleteMapping("/zones/{enum_zone}")
	public void deleteStudent(@PathVariable String enum_zone) {
		zoneInterface.deleteById(enum_zone);
	}
	
	@PostMapping("/zones")
	public void createStudent(@RequestBody Enum_zone enum_zone) {
			zoneInterface.save(enum_zone);

	}
	@PutMapping("/zones/{enum_zone}")
	public void updateZone(@RequestBody Enum_zone zone, @PathVariable String enum_zone) {

		zoneInterface.findById(enum_zone);

		zone.setEnum_zone(enum_zone);
		
		zoneInterface.save(zone);

	}
}
