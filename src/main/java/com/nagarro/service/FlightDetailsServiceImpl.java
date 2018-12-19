package com.nagarro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Repository.FlightDetailsDao;
import com.nagarro.model.FlightDetail;
import com.nagarro.model.UserInput;
import com.nagarro.utils.ConstantsUtil;
import com.nagarro.utils.StringtoDate;

@Service("flightDetailsService")
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired
	FlightDetailsDao flightDetailsDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.service.FlightDetailsService#findFlights()
	 */
	@Override
	public List<FlightDetail> findFlights(UserInput userInput) {

		List<FlightDetail> flightList = flightDetailsDao.availableFlights(userInput);
		List<FlightDetail> availableFlights = new ArrayList<>();

		for (FlightDetail flight : flightList) {

			StringtoDate availableFlight = new StringtoDate(flight.getVALID_TILL(), false);
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

		if (userInput.getPreference().equals(ConstantsUtil.PREF_FARE)) {

			Collections.sort(availableFlights, new Comparator<FlightDetail>() {

				@Override
				public int compare(FlightDetail o1, FlightDetail o2) {
					if (o1.getFARE() > o2.getFARE())
						return 1;
					else if (o1.getFARE() < o2.getFARE())
						return -1;
					else
						return 0;

				}
			});
		}

		if (userInput.getPreference().equals(ConstantsUtil.PREF_DURATION)) {
			Collections.sort(availableFlights, new Comparator<FlightDetail>() {

				@Override
				public int compare(FlightDetail o1, FlightDetail o2) {

					if (o1.getFLIGHT_DUR() > o2.getFLIGHT_DUR())
						return 1;
					else if (o1.getFLIGHT_DUR() < o2.getFLIGHT_DUR())
						return -1;
					else
						return 0;
				}
			});
		}
		return availableFlights;
	}
}
