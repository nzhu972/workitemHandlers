package com.miraca.eboss.workitemhandler;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import com.miraca.eboss.activemq.client.JmsProducer;
import com.miraca.eboss.demo.CaseMaster;

public class SenderWorkItemHandler implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		// extract parameters

	    CaseMaster caseData = (CaseMaster) workItem.getParameter("caseData");
	    
	    System.out.println ("Total Lines: " + caseData.getChargeLine().size());
	    
	    JmsProducer jmsProducer = new JmsProducer();
	    
	    System.out.println ("Dispatching case to message queue " + caseData.getChargeLine().size());
	    
	    jmsProducer.send(caseData);
	    
	    manager.completeWorkItem(workItem.getId(), null);
	}
	
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

	    // Do nothing, notifications cannot be aborted

	}
}
