/*
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.ui.tests;

import com.dexels.navajo.xtext.navascript.ui.internal.NavascriptActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;

public class NavascriptUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return NavascriptActivator.getInstance().getInjector("com.dexels.navajo.Navascript");
	}

}
