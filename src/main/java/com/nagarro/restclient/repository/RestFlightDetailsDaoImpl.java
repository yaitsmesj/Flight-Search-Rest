package com.nagarro.restclient.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.nagarro.model.FlightDetail;
import com.nagarro.restclient.model.RestFlightDetail;
import com.nagarro.restclient.model.RestRequest;
import com.nagarro.utils.ConstantsUtil;

@Repository
public class RestFlightDetailsDaoImpl implements RestFlightDetailsDao {

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.restclient.repository.RestFlightDetailsDao#getFlights(com.nagarro
	 * .model.RestRequest)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RestFlightDetail> getMatchingFlights(RestRequest userInput,int size) {
		String classQuery = "";
		if (userInput.getFlightClass().equals("E")) {

		} else if (userInput.getFlightClass().equals("B")) {
			classQuery = " AND f1.CLASS = 'B' AND f2.CLASS = 'B'";
		}

		Query query = entityManager.createQuery("select f1,f2 from FlightDetail as f1, FlightDetail as f2 where"
				+ "	f1.DEP_LOC=?0 and f2.ARR_LOC=?1 and f1.ARR_LOC = f2.DEP_LOC AND f2.FLIGHT_TIME - f1.FLIGHT_TIME + f1.FLIGHT_DUR >= 1"
				+ " f1.ARR_LOC = f2.DEP_LOC AND f2.FLIGHT_TIME - f1.FLIGHT_TIME + f1.FLIGHT_DUR <= 10" + classQuery
				+ " AND f1.SEAT_AVAILABILITY = ?2 AND f2.SEAT_AVAILABILITY = ?2").setParameter(0, userInput.getDepLoc())
				.setParameter(1, userInput.getArrLoc()).setParameter(2, "Y").setFirstResult(0);
		query.setMaxResults(10);
		;
		List<FlightDetail> f1 = new ArrayList<>();
		List<FlightDetail> f2 = new ArrayList<>();
		List<Object[]> flights = query.getResultList();
		for (Object[] f : flights) {
			f1.add((FlightDetail) f[0]);
			f2.add((FlightDetail) f[1]);
		}

		List<RestFlightDetail> matchingFlights = new ArrayList<>();
		for (int i = 0; i < f1.size(); i++) {
			RestFlightDetail flight = new RestFlightDetail();
			flight.setFlight1(f1.get(i));
			flight.setFlight2(f2.get(i));
			matchingFlights.add(flight);
		}

		return matchingFlights;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RestFlightDetail> getFlights(RestRequest userInput,int size) {
		List<FlightDetail> availableFlights = null;
		List<RestFlightDetail> flightList = null;

		try {
			Query query = entityManager.createQuery(ConstantsUtil.FLIGHT_DETAILS_QUERY)
					.setParameter(0, userInput.getDepLoc()).setParameter(1, userInput.getArrLoc())
					.setParameter(2, userInput.getFlightClass()).setParameter(3, "Y").setFirstResult(0);
			query.setMaxResults(size);
			;
			availableFlights = query.getResultList();

			flightList = new ArrayList<>();
			for (FlightDetail flight : availableFlights) {
				RestFlightDetail restFlightDetail = new RestFlightDetail();
				restFlightDetail.setFlight1(flight);
				restFlightDetail.setFlight2(null);
				flightList.add(restFlightDetail);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flightList;
	}

}
