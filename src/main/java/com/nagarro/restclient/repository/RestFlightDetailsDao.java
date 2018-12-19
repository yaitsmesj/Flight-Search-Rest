package com.nagarro.restclient.repository;

import java.util.List;

import com.nagarro.restclient.model.RestFlightDetail;
import com.nagarro.restclient.model.RestRequest;

public interface RestFlightDetailsDao {

	List<RestFlightDetail> getMatchingFlights(RestRequest userInput,int size);

	List<RestFlightDetail> getFlights(RestRequest userInput,int size);

}