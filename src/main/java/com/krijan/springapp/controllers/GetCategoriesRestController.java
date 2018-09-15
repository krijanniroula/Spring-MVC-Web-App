package com.krijan.springapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.krijan.springapp.componets.GetCategoriesComponent;
import com.krijan.springapp.responsebody.BothResponseBody;
import com.krijan.springapp.responsebody.DistrictResponseBody;
import com.krijan.springapp.responsebody.ZoneResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class GetCategoriesRestController {
	
	@Autowired
	GetCategoriesComponent getCategoriesController;

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

			return getCategoriesController.ZoneResponseResult();
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

			return getCategoriesController.DistrictResponseResult();
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

			obj.put("zone", getCategoriesController.ZoneResponseResult().getJsonArray());
			obj1.put("district", getCategoriesController.DistrictResponseResult().getJsonArray());

			List<JSONObject> list2 = new ArrayList<>();

			list2.add(obj);
			list2.add(obj1);

			bothResponseBody.setJsonObject(list2);

			return bothResponseBody;

		} else {
			return null;
		}
	}

}
