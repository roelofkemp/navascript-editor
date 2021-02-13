package com.dexels.navajo.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
 
public class NavascriptDocumentationProvider implements IEObjectDocumentationProvider {
 
	public NavascriptDocumentationProvider() {
		System.err.println("in NavascriptDocumentationProvider");
	}
	
    @Override
    public String getDocumentation(EObject o) {
    	System.err.println("In getDocumentation: " + o);
       return "Hello world: " + o;
    }
}
 
