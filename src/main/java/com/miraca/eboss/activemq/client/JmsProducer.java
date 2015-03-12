package com.miraca.eboss.activemq.client;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.miraca.eboss.activemq.client.payload.CaseInfo;
import com.miraca.eboss.activemq.client.payload.LineItem;
import com.miraca.eboss.demo.CaseMaster;
import com.miraca.eboss.demo.CaseSource;
import com.miraca.eboss.demo.ChargeLine;
import com.miraca.eboss.demo.Demographic;
import com.miraca.eboss.demo.WeatherInfo;


public class JmsProducer {
	public void send (CaseMaster caseData) { 
		
		CaseInfo payload = mapCaseData (caseData);
		
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		connectionFactory.setUserName("nevin");
		connectionFactory.setPassword("nevin");
		// Create a Connection
		Connection connection;
		try {
			connection = connectionFactory.createConnection();

		// Create a Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		ObjectMessage msg = session.createObjectMessage();
		msg.setObject(payload);
		//msg.setJMSType();
		// Create the destination
		Destination destination = session.createQueue("fabric.simple");

		// Create a MessageProducer from the Session to the Queue
		MessageProducer producer = session.createProducer(destination);

		// Start the connection
		connection.start();
		
		producer.send(msg);
		
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private CaseInfo mapCaseData (CaseMaster origin) {
		
		CaseInfo destination = new CaseInfo ();
		
		destination.setAddress(origin.getCaseDemographic().getAddress());
		destination.setCaseNumber(origin.getCaseSource().getCaseNumber());
		destination.setCaseType(origin.getCaseSource().getCaseType());
		destination.setCity(origin.getWeatherInfo().getCity());
		destination.setClientCode(origin.getCaseSource().getClientCode());
		
	/*	SimpleDateFormat sdfDestination = new SimpleDateFormat(
                "MM/dd/yy");*/

        // parse the date into another format
       // String strDate = sdfDestination.format(origin.getCaseSource().getDateOfService());
        
		destination.setDateOfService(origin.getCaseSource().getDateOfService());
		destination.setInsurance(origin.getCaseDemographic().getInsurance());
		destination.setLines(mapLineItems(origin.getChargeLine()));
		destination.setPatientFirstName(origin.getCaseSource().getFirstName());
		destination.setPatientLastName(origin.getCaseSource().getLastName());
		destination.setPatientZipcode(origin.getCaseSource().getZipcode());
		destination.setProfessionPerformed(origin.getCaseSource().getProfessionalPerformed());
		destination.setState(origin.getWeatherInfo().getState());
		destination.setTechnicalPerformed(origin.getCaseSource().getTechnicalPerformed());
		destination.setTemperature(origin.getWeatherInfo().getTemperature());
		destination.setTicketNumber(origin.getCaseSource().getTicketNumber());
		
	
		return destination;
	}
	
	private List<LineItem> mapLineItems (List<ChargeLine> origin) {
		LineItem payloadItem;
		List<LineItem> destination = new ArrayList<LineItem> ();
		
		for (ChargeLine item : origin) {
			payloadItem = new LineItem ();
			
			payloadItem.setChargeType(item.getChargeType());
			payloadItem.setCpt(item.getCpt());
			payloadItem.setDiagnosis(item.getDiagnosis());
			payloadItem.setPrice(item.getPrice());
			payloadItem.setQty(item.getQty());
			payloadItem.setTicketNumber(item.getTicketNumber());
			payloadItem.setTotalPrice(item.getTotalPrice());
			
			destination.add(payloadItem);
		}
		return destination;
	}
	
	public static void main (String args[]) {
		JmsProducer producer = new JmsProducer();
		
		producer.send(mockObject());
		
		System.out.println ("done");
	}
	public static CaseMaster mockObject () {
		CaseMaster caseMaster = new CaseMaster();
		Demographic demographic = new Demographic();
		WeatherInfo weatherInfo = new WeatherInfo ();
		caseMaster.setCaseSource(new CaseSource());
		caseMaster.setCaseDemographic(demographic);
		caseMaster.setWeatherInfo(weatherInfo);
		
		caseMaster.getCaseDemographic().setAddress("100 main st");
		caseMaster.getCaseSource().setCaseNumber("PY14-00001");
		caseMaster.getCaseSource().setCaseType("Global");
		caseMaster.getWeatherInfo().setCity("Dallas");
		caseMaster.getCaseSource().setClientCode("OK1000");
		caseMaster.getCaseSource().setDateOfService("04/11/14");
		caseMaster.getCaseDemographic().setInsurance("Medicare");
		caseMaster.setChargeLine(mockLineItem());
		caseMaster.getCaseSource().setFirstName("Peter");
		caseMaster.getCaseSource().setLastName("Griffin");
		caseMaster.getCaseSource().setZipcode("75075");
		caseMaster.getCaseSource().setProfessionalPerformed("Irving");
		caseMaster.getWeatherInfo().setState("TX");
		caseMaster.getCaseSource().setTechnicalPerformed("Client");
		caseMaster.getWeatherInfo().setTemperature("75");
		caseMaster.getCaseSource().setTicketNumber("100001");
		
		return caseMaster;
	}
	
	private static List<ChargeLine> mockLineItem () {
		ChargeLine line = new ChargeLine ();
		List<ChargeLine> lines = new ArrayList<ChargeLine>();
		
		line.setChargeType("Professional");
		line.setCpt("88305");
		line.setDiagnosis("537.9");
		line.setPrice(100.00f);
		line.setQty(new Short((short) 1));
		line.setTicketNumber("100001");
		line.setTotalPrice(100.00f);
		
		lines.add(line);
		
		line = new ChargeLine ();
		line.setChargeType("Technical");
		line.setCpt("88305");
		line.setDiagnosis("537.9");
		line.setPrice(100.00f);
		line.setQty(new Short((short) 1));
		line.setTicketNumber("100001");
		line.setTotalPrice(100.00f);
		
		lines.add(line);
		return lines;
	}
}
