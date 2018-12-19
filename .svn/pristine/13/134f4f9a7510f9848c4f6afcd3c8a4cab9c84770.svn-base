package com.nagarro.utils;

public class StringtoDate {

	private String date;
	private boolean isUserInput;
	private int day;
	private int month;
	private int year;

	public StringtoDate(String date, boolean isUserInput) {
		this.date = date;
		this.isUserInput = isUserInput;
		setDate();
	}

	public Integer getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	private void setDate() {

		if (isUserInput) {
			day = Integer.parseInt(date.substring(8, 10));
			month = Integer.parseInt(date.substring(5, 7));
			year = Integer.parseInt(date.substring(0, 4));

		} else {
			day = Integer.parseInt(date.substring(0, 2));
			month = Integer.parseInt(date.substring(3, 5));
			year = Integer.parseInt(date.substring(6, 10));

		}
	}

}
