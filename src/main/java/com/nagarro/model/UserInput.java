package com.nagarro.model;

public class UserInput {

	private String depLoc;
	private String arrLoc;
	private String flightDate;
	private String flightClass;
	private String preference;

	public String getArrLoc() {
		return arrLoc;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public String getPreference() {
		return preference;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

}
