package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name = "flight_details")
public class FlightDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column
	private String FLIGHT_NO;

	@Column
	private String DEP_LOC;

	@Column
	private String ARR_LOC;

	@Column
	private String VALID_TILL;

	@Column
	private String FLIGHT_TIME;

	@Column
	private double FLIGHT_DUR;

	@Column
	private double FARE;

	@Column
	private String SEAT_AVAILABILITY;

	@Column
	private String CLASS;

	public FlightDetail() {
		
	}
	
	public String getARR_LOC() {
		return ARR_LOC;
	}

	public String getCLASS() {
		return CLASS;
	}

	public String getDEP_LOC() {
		return DEP_LOC;
	}

	public double getFARE() {
		return FARE;
	}

	public double getFLIGHT_DUR() {
		return FLIGHT_DUR;
	}

	public String getFLIGHT_NO() {
		return FLIGHT_NO;
	}

	public String getFLIGHT_TIME() {
		return FLIGHT_TIME;
	}

	public int getID() {
		return ID;
	}

	public String getSEAT_AVAILABILITY() {
		return SEAT_AVAILABILITY;
	}

	public String getVALID_TILL() {
		return VALID_TILL;
	}

	public void setARR_LOC(String aRR_LOC) {
		ARR_LOC = aRR_LOC;
	}

	public void setCLASS(String cLASS) {
		CLASS = cLASS;
	}

	public void setDEP_LOC(String dEP_LOC) {
		DEP_LOC = dEP_LOC;
	}

	public void setFARE(double fARE) {
		FARE = fARE;
	}

	public void setFLIGHT_DUR(double fLIGHT_DUR) {
		FLIGHT_DUR = fLIGHT_DUR;
	}

	public void setFLIGHT_NO(String fLIGHT_NO) {
		FLIGHT_NO = fLIGHT_NO;
	}

	public void setFLIGHT_TIME(String fLIGHT_TIME) {
		FLIGHT_TIME = fLIGHT_TIME;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setSEAT_AVAILABILITY(String sEAT_AVAILABILITY) {
		SEAT_AVAILABILITY = sEAT_AVAILABILITY;
	}

	public void setVALID_TILL(String vALID_TILL) {
		VALID_TILL = vALID_TILL;
	}

}
