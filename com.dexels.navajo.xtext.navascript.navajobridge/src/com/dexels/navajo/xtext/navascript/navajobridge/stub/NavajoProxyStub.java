package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

import com.dexels.navajo.mapping.compiler.meta.MapDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterInterrogator;
import com.dexels.navajo.xtext.navascript.navajobridge.FunctionDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterClassDefinition;

public class NavajoProxyStub implements EventHandler {

	private EventAdmin myEventAdmin;

	private Map<String, AdapterClassDefinition> adapters = new TreeMap<>();
	private Map<String, FunctionDefinition> functions = new TreeMap<>();

	public void init(MapDefinitionInterrogatorImpl mdii) throws Exception {

		List<MapDefinition> allAdapters = mdii.getAdapters();
		functions = mdii.getFunctions();

		for ( MapDefinition md : allAdapters ) {
			if ( md.objectName != null && !"".equals(md.objectName)) {
				try {
					adapters.put(md.tagName, new AdapterClassDefinition(md));
				} catch (Exception e) {
					System.err.println("Could not add " + md.tagName + ": " + e.getLocalizedMessage());
				}
			}
		}

	}

	private void addExtension(MapDefinitionInterrogatorImpl mdii, String ext) {
		try {
			mdii.addExtentionDefinition(ext);
		} catch (Exception e) {
			System.err.println("Could not load " + ext + ": " + e.getLocalizedMessage());
		}
	}

	public void activate() {
		System.err.println("In NavajoProxyStub.activate()");
		try {
			MapDefinitionInterrogatorImpl mdii = new MapDefinitionInterrogatorImpl();

			addExtension(mdii, "com.dexels.navajo.adapter.functions.StandardAdapterFunctionLibrary");
			addExtension(mdii, "com.dexels.navajo.adapter.StandardAdapterLibrary");
			addExtension(mdii, "com.dexels.navajo.adapter.core.NavajoEnterpriseCoreAdapterLibrary");
			addExtension(mdii, "com.dexels.navajo.mongo.adapter.MongoAdapterLibrary");
			addExtension(mdii, "com.dexels.navajo.resource.http.bundle.ResourceAdapterLibrary");
			addExtension(mdii, "com.dexels.navajo.functions.StandardFunctionDefinitions");
			addExtension(mdii, "com.dexels.navajo.functions.StandardFunctionDefinitions");
			addExtension(mdii, "com.dexels.navajo.adapter.functions.StandardAdapterFunctionLibrary");

			init(mdii);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}

	private void sendResponse() {
		Map<String,Object> map = new HashMap<>();
		map.put("adapters", adapters);
		map.put("functions", functions);
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

	public static void main(String [] args) {

		NavajoProxyStub n = new NavajoProxyStub();
		n.activate();

		for ( String s : n.functions.keySet() ) {
			System.err.println(n + " -> " + n.functions.get(s).getInput());
		}
	}

}
