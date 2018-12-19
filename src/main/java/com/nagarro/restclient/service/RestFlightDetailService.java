package com.nagarro.restclient.service;

import java.util.List;

import com.nagarro.restclient.model.RestFlightDetail;
import com.nagarro.restclient.model.RestRequest;

public interface RestFlightDetailService {

	List<RestFlightDetail> findFlights(RestRequest userInput,int size);

}