package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

public class AdapterInterrogator implements EventHandler {

	public final static String FETCH_ADAPTERS = "adapter_fetch";
	public final static String ADAPTER_OVERVIEW = "adapter_overview";
	
	Map<String, AdapterClassDefinition> myAdapters = null;
	Map<String, FunctionDefinition> myFunctions = null;

	private EventAdmin myEventAdmin;

	public void activate() {
		fetchAdapters();
	}

	public void setEventAdmin(EventAdmin e) {
		myEventAdmin = e;
	}

	private void fetchAdapters() {

		Map<String,String> map = new HashMap<>();
		Event e = new Event(FETCH_ADAPTERS, map);
		myEventAdmin.postEvent(e);

	}

	public AdapterClassDefinition getAdapter(String s) {
		return myAdapters.get(s);
	}

	public FunctionDefinition getFunction(String s) {
		return myFunctions.get(s);
	}
	
	public String [] getAdapters() {

		if ( myAdapters != null ) {

			Set<String> keySet = myAdapters.keySet();
			String [] adapters = new String[keySet.size()];
			adapters = (String []) keySet.toArray(adapters);

			return adapters;
		} else {
			return null;
		}
	}
	
	public String [] getFunctions() {

		if ( myFunctions != null ) {

			Set<String> keySet = myFunctions.keySet();
			String [] functions = new String[keySet.size()];
			functions = (String []) keySet.toArray(functions);

			return functions;
		} else {
			return null;
		}
	}
	

	@Override
	public void handleEvent(Event event) {
		if ( event.getTopic().equals(ADAPTER_OVERVIEW)) {
			myAdapters =  (Map<String, AdapterClassDefinition>) event.getProperty("adapters");
			myFunctions =  (Map<String, FunctionDefinition>) event.getProperty("functions");
		}
	}
}
