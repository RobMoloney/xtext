/*
 * generated by Xtext 2.25.0
 */
package org.example.domainmodel;

import org.eclipse.xtext.generator.IGenerator;
import org.example.domainmodel.generator.DomainmodelGenerator;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {

//	// contributed by org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
//		public Class<? extends IGenerator2> bindIGenerator2() {
//			return DomainmodelGenerator.class;
//		}	
//		
//		bindIGenerator2
	
	@Override
	public Class<? extends IGenerator> bindIGenerator() {
		return super.bindIGenerator();
	}
}


