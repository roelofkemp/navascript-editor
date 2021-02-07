package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

import com.dexels.navajo.xtext.navascript.navajobridge.AdapterInterrogator;

public class NavajoProxyStub implements EventHandler {

	private EventAdmin myEventAdmin;

	private Map<String, AdapterDefinition> adapters = new HashMap<>();
	
	public void init() {
		
		// sqlquery
		AdapterDefinition a1 = new AdapterDefinition("sqlquery");
		a1.setValues("datasource", "transactionContext", "query");
		a1.setMethods("addParameter", "update");
		adapters.put(a1.name, a1);
		
		AdapterDefinition a2 = new AdapterDefinition("navajomap");
		a2.setValues("sendThrough", "messagePointer");
		a2.setMethods("createproperty", "callwebservice");
		adapters.put(a2.name, a2);
		
		AdapterDefinition a3 = new AdapterDefinition("mailmap");
		a3.setValues("from", "to", "cc", "bcc", "subject", "bodyText", "mailServer");
		a3.setMethods("doSend");
		adapters.put(a3.name, a3);
		
		
	}
	
	public void activate() {
		System.err.println("In NavajoProxyStub.activate()");
		init();
	}
	
	private void sendResponse() {
		Map<String,Object> map = new HashMap<>();
		map.put("overview", adapters);
		Event e = new Event(AdapterInterrogator.ADAPTER_OVERVIEW, map);
		myEventAdmin.postEvent(e);
	}

	public void setEventAdmin(EventAdmin e) {
		myEventAdmin = e;
	}


	@Override
	public void handleEvent(Event event) {
		System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Received event: " + event);
		sendResponse();
	}

}
