package com.krijan.springapp.componets;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.krijan.springapp.POJOModels.Enum_district;
import com.krijan.springapp.POJOModels.Enum_zone;
import com.krijan.springapp.interfaces.DistrictInterface;
import com.krijan.springapp.interfaces.ZoneInterface;
import com.krijan.springapp.responsebody.DistrictResponseBody;
import com.krijan.springapp.responsebody.ZoneResponseBody;

import net.sf.json.JSONArray;

@Component
public class GetCategoriesComponent {
	
	@Autowired
	ZoneInterface zoneInterface;
	
	@Autowired
	DistrictInterface districtInterface;
	

	public ZoneResponseBody ZoneResponseResult() {
		ZoneResponseBody zoneResponse = new ZoneResponseBody();
		List<Enum_zone> list = new ArrayList<>();
		list = zoneInterface.findAll();

		JSONArray ja = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			ja.add(list.get(i).getEnum_zone());
		}

		zoneResponse.setJsonArray(ja);
		return zoneResponse;
	}
	
	public DistrictResponseBody DistrictResponseResult() {

		DistrictResponseBody districtResponse = new DistrictResponseBody();
		List<Enum_district> list = new ArrayList<>();
		list = districtInterface.findAll();

		JSONArray ja = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			ja.add(list.get(i).getEnum_district());
		}
		districtResponse.setJsonArray(ja);
		return districtResponse;
	}
	

	

}
