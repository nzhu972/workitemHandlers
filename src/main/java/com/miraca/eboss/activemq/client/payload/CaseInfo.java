package com.miraca.eboss.activemq.client.payload;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CaseInfo implements Serializable {

	String caseNumber;
	String caseType;
	String clientCode;
	String patientFirstName;
	String patientLastName;
	String patientZipcode;
	String dateOfService;
	String technicalPerformed;
	String professionPerformed;
	String ticketNumber;
	String city;
	String state;
	String temperature;
	String address;
	String insurance;
	List<LineItem> lines;
	
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPatientZipcode() {
		return patientZipcode;
	}
	public void setPatientZipcode(String patientZipcode) {
		this.patientZipcode = patientZipcode;
	}
	public String getDateOfService() {
		return dateOfService;
	}
	public void setDateOfService(String dateOfService) {
		this.dateOfService = dateOfService;
	}
	public String getTechnicalPerformed() {
		return technicalPerformed;
	}
	public void setTechnicalPerformed(String technicalPerformed) {
		this.technicalPerformed = technicalPerformed;
	}
	public String getProfessionPerformed() {
		return professionPerformed;
	}
	public void setProfessionPerformed(String professionPerformed) {
		this.professionPerformed = professionPerformed;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public List<LineItem> getLines() {
		return lines;
	}
	public void setLines(List<LineItem> lines) {
		this.lines = lines;
	} 
}
