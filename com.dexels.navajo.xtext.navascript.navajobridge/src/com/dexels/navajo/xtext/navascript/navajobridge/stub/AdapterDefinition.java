package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.io.Serializable;

public class AdapterDefinition implements Serializable {

	public String name;
	public ValueDefinition [] fields;
	public MethodDefinition [] methods;
	
	public AdapterDefinition(String s) {
		name = s;
	}
	
	public void setValues(String...strings) {
		
		int size = strings.length;
		fields = new ValueDefinition[size];
		int index = 0;
		for ( String s : strings) {
			fields[index++] = new ValueDefinition(s, "string", false);
		}
	}
	
	public void setMethods(String...strings) {
		int size = strings.length;
		methods = new MethodDefinition[size];
		int index = 0;
		for ( String s : strings) {
			methods[index++] = new MethodDefinition(s);
		}
	}
	
}
