package com.miraca.eboss;

import java.util.HashMap;
import java.util.Map;

public class ProcessContants {
	public static final Map<String, Float> tPriceMap;
	public static final Map<String, Float> pPriceMap;
	public static final String CHARGE_TYPE_PROFESSIONAL = "Professional";
	public static final String CHARGE_TYPE_TECHNICAL = "Technical";
    static
    {
    	tPriceMap = new HashMap<String, Float>();
    	tPriceMap.put("88305", 75.00f);
    	
    	pPriceMap = new HashMap<String, Float>();
    	pPriceMap.put("88305", 100.00f);
    	pPriceMap.put("88342", 150.00f);
    }
   
}
