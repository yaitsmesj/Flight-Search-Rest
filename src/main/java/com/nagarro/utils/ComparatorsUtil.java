package com.nagarro.utils;

import java.util.Comparator;

import com.nagarro.restclient.model.RestFlightDetail;

public class ComparatorsUtil {

	public static Comparator<RestFlightDetail> getFlightFareComparator() {

		return new Comparator<RestFlightDetail>() {

			@Override
			public int compare(RestFlightDetail o1, RestFlightDetail o2) {

				if (o1.getFlight1().getFARE() > o2.getFlight1().getFARE())
					return 1;
				else if (o1.getFlight1().getFARE() < o2.getFlight1().getFARE())
					return -1;
				else
					return 0;

			}
		};
	}

	public static Comparator<RestFlightDetail> getFlightDurationComparator() {
		return new Comparator<RestFlightDetail>() {

			@Override
			public int compare(RestFlightDetail o1, RestFlightDetail o2) {
				if (o1.getFlight1().getFLIGHT_DUR() > o2.getFlight1().getFLIGHT_DUR())
					return 1;
				else if (o1.getFlight1().getFLIGHT_DUR() < o2.getFlight1().getFLIGHT_DUR())
					return -1;
				else
					return 0;

			}
		};
	}

	public static Comparator<RestFlightDetail> getMatchingFlightFareComparator() {
		return new Comparator<RestFlightDetail>() {

			@Override
			public int compare(RestFlightDetail o1, RestFlightDetail o2) {
				if (o1.getFlight1().getFARE() + o1.getFlight2().getFARE() > o2.getFlight1().getFARE()
						+ o2.getFlight2().getFARE())
					return 1;
				else if (o1.getFlight1().getFARE() + o1.getFlight2().getFARE() < o2.getFlight1().getFARE()
						+ o2.getFlight2().getFARE())
					return -1;
				else
					return 0;
			}
		};
	}

	public static Comparator<RestFlightDetail> getMatchingFlightDurationComparator() {
		return new Comparator<RestFlightDetail>() {

			@Override
			public int compare(RestFlightDetail o1, RestFlightDetail o2) {
				if (Integer.parseInt(o1.getFlight2().getFLIGHT_TIME()) + o1.getFlight2().getFLIGHT_DUR()
						- Integer.parseInt(
								o1.getFlight1().getFLIGHT_TIME()) > Integer.parseInt(o2.getFlight2().getFLIGHT_TIME())
										+ o2.getFlight2().getFLIGHT_DUR()
										- Integer.parseInt(o2.getFlight1().getFLIGHT_TIME()))
					return 1;
				else if (Integer.parseInt(o1.getFlight2().getFLIGHT_TIME()) + o1.getFlight2().getFLIGHT_DUR()
						- Integer.parseInt(
								o1.getFlight1().getFLIGHT_TIME()) < Integer.parseInt(o2.getFlight2().getFLIGHT_TIME())
										+ o2.getFlight2().getFLIGHT_DUR()
										- Integer.parseInt(o2.getFlight1().getFLIGHT_TIME()))
					return 1;
				else
					return 0;
			}
		};
	}

}
