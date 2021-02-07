package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.io.Serializable;

public class MethodDefinition implements Serializable {

	public String name;
	public ValueDefinition [] parameters;
	
	public MethodDefinition(String m) {
		name = m;
	}
	
}
