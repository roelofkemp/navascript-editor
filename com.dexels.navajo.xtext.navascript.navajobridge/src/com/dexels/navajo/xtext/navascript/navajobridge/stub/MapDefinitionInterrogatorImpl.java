package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import com.dexels.navajo.document.nanoimpl.CaseSensitiveXMLElement;
import com.dexels.navajo.document.nanoimpl.XMLElement;
import com.dexels.navajo.mapping.compiler.meta.KeywordException;
import com.dexels.navajo.mapping.compiler.meta.MapDefinition;
import com.dexels.navajo.mapping.compiler.meta.MapMetaData;
import com.dexels.navajo.xtext.navascript.navajobridge.FunctionDefinition;

import navajo.ExtensionDefinition;

@SuppressWarnings("unused")
public class MapDefinitionInterrogatorImpl  {


	MapMetaData mapMetaData = null;
	private Map<String,FunctionDefinition> functions = new TreeMap<>();

	public MapDefinitionInterrogatorImpl() throws Exception {
		mapMetaData = MapMetaData.getInstance();
	}


	public void readExtentionDefinition(ExtensionDefinition ed, MapMetaData md) throws IOException, ClassNotFoundException, KeywordException {

		System.err.println("In MapMetaData. ExtensionDefinition: " + ed);

		BufferedReader br = new BufferedReader(new InputStreamReader(ed.getDefinitionAsStream(),StandardCharsets.UTF_8));

		XMLElement config = new CaseSensitiveXMLElement();
		config.parseFromReader(br);
		br.close();


		if ( config.getName().equals("adapterdef")) {
			Vector<XMLElement> allmaps = config.getElementsByTagName("map");
			for ( int i = 0; i < allmaps.size(); i++ ) {
				XMLElement map = allmaps.get(i);
				md.addMapDefinition(map);
			}
		}
	}

	public void readFunctionDefinition(ExtensionDefinition ed) throws IOException, ClassNotFoundException, KeywordException {

		System.err.println("In MapMetaData. ExtensionDefinition: " + ed);

		BufferedReader br = new BufferedReader(new InputStreamReader(ed.getDefinitionAsStream(),StandardCharsets.UTF_8));

		XMLElement config = new CaseSensitiveXMLElement();
		config.parseFromReader(br);
		br.close();


		if ( config.getName().equals("functiondef")) {
			Vector<XMLElement> allmaps = config.getElementsByTagName("function");
			for ( int i = 0; i < allmaps.size(); i++ ) {
				XMLElement map = allmaps.get(i);
				String name = (String) map.getAttribute("name");
				FunctionDefinition f = new FunctionDefinition(name);
				XMLElement descElt =  map.getChildByTagName("description");
				if ( descElt != null ) {
					f.setDescription(descElt.getContent());
				}
				List<String> inputs = new ArrayList<>();
				XMLElement inputElt = map.getChildByTagName("input");
				if ( inputElt != null ) {
					String [] options = inputElt.getContent().split("\\|");
					for ( String o : options ) {
						o = o.replace(',', ';');
						inputs.add(o);
					}
				}
				f.setInput(inputs);
				XMLElement resultElt = map.getChildByTagName("result");
				if ( descElt != null ) {
					f.setResult(resultElt.getContent());
				}
				functions.put(name, f);
				System.err.println(name + ": " + f);
			}
		}
	}
	
	public void addExtentionDefinition(String extension) throws Exception {

		Class<ExtensionDefinition> c = (Class<ExtensionDefinition>) Class.forName(extension);
		ExtensionDefinition ed = c.getDeclaredConstructor().newInstance();
		MapMetaData md = MapMetaData.getInstance();
		readExtentionDefinition(ed, md);
		readFunctionDefinition(ed);

	}

	public boolean isMethod(String adapter, String m) throws Exception {
		try {
			if (  mapMetaData.getMapDefinition(adapter) == null ) {
				throw new Exception("Could not find adapter: " + adapter);
			}
			return ( mapMetaData.getMapDefinition(adapter).getMethodDefinition(m) != null);
		} catch (ClassNotFoundException e) {
			throw new Exception(e);
		} catch (KeywordException e) {
			throw new Exception(e);
		}
	}

	private boolean isRegularField(String adapter, String m) throws Exception {
		if (  mapMetaData.getMapDefinition(adapter) == null ) {
			throw new Exception("Could not find adapter: " + adapter + " for field " + m);
		} 
		String className = mapMetaData.getMapDefinition(adapter).objectName;
		Class c = Class.forName(className);
		return c.getDeclaredField(m) != null;
	}

	public boolean isDeclaredField(String className, String m)  {
		try {
			Class c = Class.forName(className);
			return c.getDeclaredField(m) != null;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isField(String adapter, String m) throws Exception {

		try {
			if (  mapMetaData.getMapDefinition(adapter) == null ) {
				// Try regular field
				if ( isRegularField(adapter, m) ) {
					return true;
				}
				throw new Exception("Could not find adapter: " + adapter);
			} 
			String objectName = mapMetaData.getMapDefinition(adapter).objectName;
			boolean isDefinedField = ( mapMetaData.getMapDefinition(adapter).getValueDefinition(m) != null);
			boolean isDeclaredField = isDeclaredField(objectName, m);
			return isDefinedField || isDeclaredField;
		} catch (ClassNotFoundException e) {
			throw new Exception(e);
		} catch (KeywordException e) {
			throw new Exception(e);
		}
	}

	public MapDefinition getAdapter(String adapter) throws Exception{

		return mapMetaData.getMapDefinition(adapter);

	}

	public Map<String,FunctionDefinition> getFunctions() throws Exception {
		return functions;
	}
	
	public List<MapDefinition> getAdapters() throws Exception{
		
		ArrayList<MapDefinition> allMaps = new ArrayList<>();
		
		Set<String> definitions = mapMetaData.getMapDefinitions();
		for ( String s : definitions ) {
			allMaps.add(mapMetaData.getMapDefinition(s));
		}
		
		return allMaps;
	}
	
	public void describeAdapter(String adapter) throws Exception {

		MapDefinition md = mapMetaData.getMapDefinition(adapter);

		Set<String> methods = md.getMethodDefinitions();		

		System.err.println("Adapter " + adapter + " methods:");

		for ( String s : methods ) {
			System.err.println("\t" + s);
		}

		Set<String> values = md.getValueDefinitions();

		System.err.println("Adapter " + adapter + " fields:");

		for ( String s : values ) {
			System.err.println("\t" + s);
		}

	}

	public static void main (String [] args) throws Exception {

		MapDefinitionInterrogatorImpl m = new MapDefinitionInterrogatorImpl();

		String adapter = "sqlquery";
		String field = "doUpdate";

		m.describeAdapter(adapter);

	}

	public boolean isValidClass(String className) {
		try {
			Class c = Class.forName(className);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isValidAdapter(String adapter)  {
		try {
			return ( mapMetaData.getMapDefinition(adapter) != null ) ;
		} catch (Exception e) {
			return false;
		}
	}
}

