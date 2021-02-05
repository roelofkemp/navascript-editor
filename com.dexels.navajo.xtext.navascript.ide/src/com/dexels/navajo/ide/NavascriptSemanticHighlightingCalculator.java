package com.dexels.navajo.ide;

import com.google.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;

import com.dexels.navajo.navascript.Message;
import com.dexels.navajo.services.NavascriptGrammarAccess;

public class NavascriptSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

	public static class NavascriptHighlightingStyles implements HighlightingStyles {
		public static String KEYWORD_RED_ID = KEYWORD_ID + "Red";
	}

	@Inject
	NavascriptGrammarAccess ga;

	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object instanceof Message) {
			Keyword keyword = null;
			for (ILeafNode n : NodeModelUtils.findActualNodeFor(object).getLeafNodes()) {
				if (keyword == n.getGrammarElement()) {
					acceptor.addPosition(n.getOffset(), n.getLength(), NavascriptHighlightingStyles.KEYWORD_RED_ID);
				}
			}
		}
		return super.highlightElement(object, acceptor, cancelIndicator);
	}
}
