package com.miraca.eboss.workitemhandler;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import com.miraca.eboss.demo.CaseMaster;
import com.miraca.eboss.demo.ChargeLine;
import com.miraca.eboss.ProcessContants;

public class ValidationWorkItemHandler implements WorkItemHandler {
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		 CaseMaster caseData = (CaseMaster) workItem.getParameter("caseData");
		 
/*		 for (ChargeLine line : caseData.getChargeLine() ) {
			 if (line.getChargeType().equalsIgnoreCase(ProcessContants.CHARGE_TYPE_PROFESSIONAL)) {
				 if (ProcessContants.pPriceMap.containsKey(line.getCpt())) {
					 line.setPrice(ProcessContants.pPriceMap.get(line.getCpt()));
					 line.setTotalPrice(line.getQty() * line.getPrice());
					 caseData.setPriceFoundInd(true);
				 }
				 else {
					 caseData.setPriceFoundInd(false);
				 }
			 }
			 if (line.getChargeType().equalsIgnoreCase(ProcessContants.CHARGE_TYPE_TECHNICAL)) {
				 if (ProcessContants.tPriceMap.containsKey(line.getCpt())) {
					 line.setPrice(ProcessContants.tPriceMap.get(line.getCpt()));
					 line.setTotalPrice(line.getQty() * line.getPrice());
					 caseData.setPriceFoundInd(true);
				 }
				 else {
					 caseData.setPriceFoundInd(false);
				 }
			 }
		 }*/
		 
		 final Map<String, Object> resultMap = new HashMap<String, Object>();
		 resultMap.put("result", caseData);
		 manager.completeWorkItem(workItem.getId(), resultMap);
	}
	
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

	    // Do nothing, notifications cannot be aborted

	}
}
