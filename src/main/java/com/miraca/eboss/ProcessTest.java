
package com.miraca.eboss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.services.client.api.RemoteRestRuntimeFactory;

import com.miraca.eboss.demo.CaseMaster;
import com.miraca.eboss.demo.CaseSource;
import com.miraca.eboss.demo.ChargeLine;
import com.miraca.eboss.demo.Demographic;
import com.miraca.eboss.demo.ValidCounter;
import com.miraca.eboss.demo.WeatherInfo;
//import redhat.brms6workshop.labs.Notification;
//import redhat.brms6workshop.labs.QuoteEvent;

/**
 * This is a sample file to test a process.
 */
public class ProcessTest {
	
	private static final String APPLICATION_CONTEXT = "http://localhost:8080/business-central";
	private static final String DEPLOYMENT_ID = "com.miraca.eboss:demo:1.0";
    private static final String USER_ID = "nevin";
    private static final String PASSWORD = "jb0ssr@cks";
    private static CaseMaster caseData;
    
	public static void main(String[] args) {

	    populateSamples(USER_ID, PASSWORD, APPLICATION_CONTEXT, DEPLOYMENT_ID);
	   
	}
	
	public static void populateSamples(String userId, String password, String applicationContext, String deploymentId)
	  {
	    RuntimeEngine runtimeEngine = getRuntimeEngine(applicationContext, deploymentId, userId, password);
	   
	    KieSession kieSession = runtimeEngine.getKieSession();

	    // Start the input
	    // cali zip code 94102
	    Map<String, Object> processVariables = getProcessArgs("100001", "PY14-00001", "Purchased Service", "OK1000", "Brown", "Bear", "94102", "04/11/14", "Client", "Irving");
	    kieSession.startProcess("demo.caseflow", processVariables);
	    /*
	    processVariables = getProcessArgs("100002", "PY15-00002", "Purchased Service", "OK1000", "Bryan", "Griffin", "1111", "04/11/14", "Client", "Client");
	    kieSession.startProcess("demo.caseflow", processVariables);
	    */
	    
/*	    Map<String, Object> processVariables = getProcessArgs("100003", "PY16-00003", "Global", "OK1000", "Peter", "Griffin", "1111", "04/11/14", "Client", "Irving");
	    kieSession.startProcess("demo.caseflow", processVariables);*/
	    
	  }
	  private static RuntimeEngine getRuntimeEngine(String applicationContext, String deploymentId, String userId, String password)
	  {
	    try
	    {
	      URL jbpmURL = new URL(applicationContext);
	      RemoteRestRuntimeFactory remoteRestSessionFactory = new RemoteRestRuntimeFactory (deploymentId, jbpmURL, userId, password);
	      return remoteRestSessionFactory.newRuntimeEngine();
	    }
	    catch (MalformedURLException e)
	    {
	      throw new IllegalStateException("This URL is always expected to be valid!", e);
	    }
	  }

	  private static Map<String, Object> getProcessArgs(String ticketNumber, String caseNumber, String caseType, String clientCode, String firstName, String lastName, String zipCode, String dos, String techPerformed, String profPerformed)
	  {
	    Map<String, Object> processVariables = new HashMap<String, Object>();
	    caseData = new CaseMaster ();
	    CaseSource caseSource= new CaseSource ();
	    Demographic demographic = new Demographic();
	    WeatherInfo weatherInfo = new WeatherInfo();

	    ArrayList<ChargeLine> chargeLine = new ArrayList<ChargeLine>();
	    
	    caseData.setCaseDemographic(demographic);
	    caseData.setChargeLine(chargeLine);
	    caseData.setCaseSource(caseSource);
	    caseData.setWeatherInfo(weatherInfo);

	    caseData.getCaseSource().setCaseNumber(caseNumber);
	    caseData.getCaseSource().setCaseType(caseType);
	    caseData.getCaseSource().setClientCode(clientCode);
	    caseData.getCaseSource().setTicketNumber(ticketNumber);
	    
		caseData.getCaseSource().setDateOfService(dos);
	    caseData.getCaseSource().setFirstName(firstName);
	    caseData.getCaseSource().setLastName(lastName);
	    caseData.getCaseSource().setZipcode(zipCode);
	    caseData.getCaseSource().setProfessionalPerformed(profPerformed);
	    caseData.getCaseSource().setTechnicalPerformed(techPerformed);

	    ValidCounter counter = new ValidCounter();
	    counter.setCounter(0);
	    
	    processVariables.put("caseMaster", caseData);
	    processVariables.put("validCount", new Integer (0));
	    processVariables.put("zipcodeOrig", zipCode);
	    processVariables.put("counterProcess", counter);

	    return processVariables;
	  }
}