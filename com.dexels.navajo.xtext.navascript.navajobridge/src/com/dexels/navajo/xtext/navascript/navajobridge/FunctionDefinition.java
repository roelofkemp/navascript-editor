package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.List;

public class FunctionDefinition {

	private String name;
	private String description;
	private List<String> input;
	private String result;
	
	public FunctionDefinition(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getInput() {
		return input;
	}
	
	public void setInput(List<String> input) {
		this.input = input;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
