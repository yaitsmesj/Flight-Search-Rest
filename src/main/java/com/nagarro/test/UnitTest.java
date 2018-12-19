package com.nagarro.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.restclient.controller.RestControllerClient;
import com.nagarro.restclient.model.RestFlightDetail;
import com.nagarro.restclient.model.RestRequest;

public class UnitTest {


	@Test
	public void test() {

		RestRequest userInput = new RestRequest();
		userInput.setDepLoc("MUB");
		userInput.setArrLoc("BUG");
		userInput.setFlightClass("E");
		userInput.setFlightDate("05/12/2012");
		userInput.setAirline("AirIndia");
		userInput.setLoc("USD");
		userInput.setPreference("FARE");
		RestControllerClient restControllerClient = new RestControllerClient();
		List<RestFlightDetail> flightList = restControllerClient.getFlights(userInput);
		for(RestFlightDetail restFlightDetail: flightList) {
			restFlightDetail.getFlight1().getDEP_LOC();
		}
		
	}

}
