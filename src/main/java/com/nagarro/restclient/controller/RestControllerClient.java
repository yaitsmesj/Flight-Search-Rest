package com.nagarro.restclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restclient.model.RestFlightDetail;
import com.nagarro.restclient.model.RestRequest;
import com.nagarro.restclient.service.RestFlightDetailService;

@RestController
@RequestMapping(value="/rest")
public class RestControllerClient {

	@Autowired
	RestFlightDetailService restFlightDetailService;

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@RequestMapping(value = "/getFlights", method = RequestMethod.POST)
	public List<RestFlightDetail> getFlights(@RequestParam int size,@RequestBody final RestRequest userInput) {
		List<RestFlightDetail> flightList = restFlightDetailService.findFlights(userInput,size);
		return flightList;
	}

}
