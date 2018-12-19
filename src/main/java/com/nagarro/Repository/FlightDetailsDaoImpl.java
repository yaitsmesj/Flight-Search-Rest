package com.nagarro.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.nagarro.model.FlightDetail;
import com.nagarro.model.UserInput;
import com.nagarro.utils.ConstantsUtil;

@Repository
public class FlightDetailsDaoImpl implements FlightDetailsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<FlightDetail> availableFlights(UserInput userInput) {
		List<FlightDetail> availableFlights = null;

		try {
			Query query = entityManager.createQuery(ConstantsUtil.FLIGHT_DETAILS_QUERY)
					.setParameter(0, userInput.getDepLoc()).setParameter(1, userInput.getArrLoc())
					.setParameter(2, userInput.getFlightClass()).setParameter(3, "Y");
			availableFlights = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return availableFlights;
	}

}
