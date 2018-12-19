package com.nagarro.restclient.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.FlightDetail;
import com.nagarro.restclient.model.RestFlightDetail;
import com.nagarro.restclient.model.RestRequest;
import com.nagarro.restclient.repository.RestFlightDetailsDaoImpl;
import com.nagarro.utils.ComparatorsUtil;
import com.nagarro.utils.ConstantsUtil;
import com.nagarro.utils.CurrencyUtil;
import com.nagarro.utils.StringtoDate;

@Service
public class RestFlightDetailServiceImpl implements RestFlightDetailService {

	List<RestFlightDetail> flightList;

	@Autowired
	RestFlightDetailsDaoImpl restFlightDetailsDaoImpl;

	@Override
	public List<RestFlightDetail> findFlights(RestRequest userInput,int size) {

		flightList = restFlightDetailsDaoImpl.getFlights(userInput,size);
		List<RestFlightDetail> availableFlights = null;

		if (flightList.isEmpty()) {

			flightList = restFlightDetailsDaoImpl.getMatchingFlights(userInput,size);

			availableFlights = getAvailableFlights(userInput);

			if (userInput.getPreference().equals(ConstantsUtil.PREF_FARE)) {
				Collections.sort(availableFlights, ComparatorsUtil.getMatchingFlightFareComparator());
			}

			if (userInput.getPreference().equals(ConstantsUtil.PREF_DURATION)) {
				Collections.sort(availableFlights, ComparatorsUtil.getMatchingFlightDurationComparator());
			}

		} else {

			availableFlights = getAvailableFlights(userInput);

			if (userInput.getPreference().equals(ConstantsUtil.PREF_FARE)) {
				Collections.sort(availableFlights, ComparatorsUtil.getFlightFareComparator());
			}

			if (userInput.getPreference().equals(ConstantsUtil.PREF_DURATION)) {
				Collections.sort(availableFlights, ComparatorsUtil.getFlightDurationComparator());
			}
		}

		// set Fare
		setCurrencyRate(availableFlights, userInput);

		return availableFlights;
	}

	private List<RestFlightDetail> getAvailableFlights(RestRequest userInput) {
		List<RestFlightDetail> availableFlights = new ArrayList<>();

		for (RestFlightDetail flight : flightList) {

			StringtoDate availableFlight = new StringtoDate(flight.getFlight1().getVALID_TILL(), false);
			StringtoDate userFlightDate = new StringtoDate(userInput.getFlightDate(), true);

			if (userFlightDate.getYear() < availableFlight.getYear()) {
				availableFlights.add(flight);
			} else if (userFlightDate.getYear() == availableFlight.getYear()
					&& userFlightDate.getMonth() < availableFlight.getMonth()) {
				availableFlights.add(flight);
			} else if (userFlightDate.getMonth() == availableFlight.getMonth()
					&& userFlightDate.getDay() <= availableFlight.getDay()) {
				availableFlights.add(flight);

			}

		}
		return availableFlights;

	}

	public void setCurrencyRate(List<RestFlightDetail> availableFlights, RestRequest userInput) {

		double exchangeRate = CurrencyUtil.getExchangeRate(userInput.getLoc());
		for (int i = 0; i < availableFlights.size(); i++) {

			RestFlightDetail restFlight = availableFlights.get(i);
			FlightDetail flight = restFlight.getFlight1();
			flight.setFARE(flight.getFARE() * exchangeRate);
			flight = restFlight.getFlight2();
			if (flight != null) {
				flight.setFARE(flight.getFARE() * exchangeRate);
			}

		}

	}

}
