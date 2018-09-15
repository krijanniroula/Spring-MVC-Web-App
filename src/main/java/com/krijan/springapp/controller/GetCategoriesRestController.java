package com.krijan.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.krijan.springapp.POJOModel.Enum_district;
import com.krijan.springapp.POJOModel.Enum_zone;
import com.krijan.springapp.interfaces.DistrictInterface;
import com.krijan.springapp.interfaces.ZoneInterface;
import com.krijan.springapp.response.BothResponseBody;
import com.krijan.springapp.response.DistrictResponseBody;
import com.krijan.springapp.response.ZoneResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class GetCategoriesRestController {
	
	@Autowired
	ZoneInterface zoneInterface;
	
	@Autowired
	DistrictInterface districtInterface;
	
	
	@RequestMapping("/spring-app")
	public ModelAndView method1() {

		ModelAndView model = new ModelAndView("home");
		return model;
	}
	

	@PostMapping(value = "/getZoneCategories")
	public ZoneResponseBody method2(@RequestBody String getKeys) {

		JSONObject json = JSONObject.fromObject(getKeys);
		JSONArray arr = (JSONArray) json.get("keyword");
		System.out.println(arr);

		if (arr.toString().equals("[\"zone\"]")) {

			return ZoneResponseResult();
		} else {
			return null;
		}
	}

	@PostMapping(value = "/getDistrictCategories")
	public DistrictResponseBody method3(@RequestBody String getKeys) {

		JSONObject json = JSONObject.fromObject(getKeys);
		JSONArray arr = (JSONArray) json.get("keyword");
		System.out.println(arr);

		if (arr.toString().equals("[\"district\"]")) {

			return DistrictResponseResult();
		} else {
			return null;
		}
	}

	@PostMapping(value = "/getBothCategories")
	public BothResponseBody method4(@RequestBody String getKeys) {

		JSONObject json = JSONObject.fromObject(getKeys);
		JSONArray arr = (JSONArray) json.get("keyword");
		System.out.println(arr);

		if (arr.toString().equals("[\"zone\",\"district\"]")) {
			BothResponseBody bothResponseBody = new BothResponseBody();
			JSONObject obj = new JSONObject();
			JSONObject obj1 = new JSONObject();

			obj.put("zone", ZoneResponseResult().getJsonArray());
			obj1.put("district", DistrictResponseResult().getJsonArray());

			List<JSONObject> list2 = new ArrayList<>();

			list2.add(obj);
			list2.add(obj1);

			bothResponseBody.setJsonObject(list2);

			return bothResponseBody;

		} else {
			return null;
		}
	}

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
