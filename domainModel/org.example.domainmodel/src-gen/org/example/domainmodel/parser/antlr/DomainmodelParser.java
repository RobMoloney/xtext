/*
 * generated by Xtext 2.25.0
 */
package org.example.domainmodel.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.example.domainmodel.parser.antlr.internal.InternalDomainmodelParser;
import org.example.domainmodel.services.DomainmodelGrammarAccess;

public class DomainmodelParser extends AbstractAntlrParser {

	@Inject
	private DomainmodelGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalDomainmodelParser createParser(XtextTokenStream stream) {
		return new InternalDomainmodelParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Domainmodel";
	}

	public DomainmodelGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DomainmodelGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
