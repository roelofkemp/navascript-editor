package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.io.Serializable;

public class ValueDefinition implements Serializable {

	public String name;
	public String type;
	public boolean required;
	
	public ValueDefinition(String name, String type, boolean required) {
		this.name = name;
	}
	
}
