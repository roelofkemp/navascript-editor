package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

import com.dexels.navajo.xtext.navascript.navajobridge.stub.AdapterDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.stub.MethodDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.stub.ValueDefinition;

public class AdapterInterrogator implements EventHandler {

	public final static String FETCH_ADAPTERS = "adapter_fetch";
	public final static String ADAPTER_OVERVIEW = "adapter_overview";

	Map<String, AdapterDefinition> myAdapters = null;

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

	public String [] getFields (String adapter) {

		AdapterDefinition ad = myAdapters.get(adapter);
		if ( ad != null ) {
			
			ValueDefinition [] values = ad.fields;
			String [] asString = new String[values.length];
			int index = 0;
			for ( ValueDefinition vd: values ) {
				asString[index++] = "$" + vd.name;
			}
			return asString;
		}
		return null;
	}

	public String [] getMethods (String adapter) {

		AdapterDefinition ad = myAdapters.get(adapter);
		if ( ad != null ) {
			
			MethodDefinition [] values = ad.methods;
			String [] asString = new String[values.length];
			int index = 0;
			for ( MethodDefinition md: values ) {
				asString[index++] = "." + md.name;
			}
			return asString;
		}
		return null;
	}

	@Override
	public void handleEvent(Event event) {
		if ( event.getTopic().equals(ADAPTER_OVERVIEW)) {
			myAdapters =  (Map<String, AdapterDefinition>) event.getProperty("overview");
		}
	}
}
