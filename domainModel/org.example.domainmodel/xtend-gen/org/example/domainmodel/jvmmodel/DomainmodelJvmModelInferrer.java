/**
 * generated by Xtext 2.25.0
 */
package org.example.domainmodel.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.example.domainmodel.domainmodel.Entity;
import org.example.domainmodel.domainmodel.Feature;
import org.example.domainmodel.domainmodel.Operation;
import org.example.domainmodel.domainmodel.Property;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
  /**
   * a builder API to programmatically create Jvm elements
   * in readable way.
   */
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  protected void _infer(final Entity element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPrelinkingPhase) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      this._jvmTypesBuilder.setDocumentation(it, this._jvmTypesBuilder.getDocumentation(element));
      JvmTypeReference _superType = element.getSuperType();
      boolean _tripleNotEquals = (_superType != null);
      if (_tripleNotEquals) {
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmTypeReference _cloneWithProxies = this._jvmTypesBuilder.cloneWithProxies(element.getSuperType());
        this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _cloneWithProxies);
      }
      EList<Feature> _features = element.getFeatures();
      for (final Feature feature : _features) {
        boolean _matched = false;
        if (feature instanceof Property) {
          _matched=true;
          EList<JvmMember> _members = it.getMembers();
          JvmField _field = this._jvmTypesBuilder.toField(feature, ((Property)feature).getName(), ((Property)feature).getType());
          this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
          EList<JvmMember> _members_1 = it.getMembers();
          JvmOperation _getter = this._jvmTypesBuilder.toGetter(feature, ((Property)feature).getName(), ((Property)feature).getType());
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _getter);
          EList<JvmMember> _members_2 = it.getMembers();
          JvmOperation _setter = this._jvmTypesBuilder.toSetter(feature, ((Property)feature).getName(), ((Property)feature).getType());
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _setter);
        }
        if (!_matched) {
          if (feature instanceof Operation) {
            _matched=true;
            EList<JvmMember> _members = it.getMembers();
            final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
              this._jvmTypesBuilder.setDocumentation(it_1, this._jvmTypesBuilder.getDocumentation(feature));
              EList<JvmFormalParameter> _params = ((Operation)feature).getParams();
              for (final JvmFormalParameter p : _params) {
                EList<JvmFormalParameter> _parameters = it_1.getParameters();
                JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType());
                this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              }
              this._jvmTypesBuilder.setBody(it_1, ((Operation)feature).getBody());
            };
            JvmOperation _method = this._jvmTypesBuilder.toMethod(feature, ((Operation)feature).getName(), ((Operation)feature).getType(), _function_1);
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
          }
        }
      }
    };
    acceptor.<JvmGenericType>accept(this._jvmTypesBuilder.toClass(element, this._iQualifiedNameProvider.getFullyQualifiedName(element)), _function);
  }
  
  public void infer(final EObject element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPrelinkingPhase) {
    if (element instanceof Entity) {
      _infer((Entity)element, acceptor, isPrelinkingPhase);
      return;
    } else if (element != null) {
      _infer(element, acceptor, isPrelinkingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, acceptor, isPrelinkingPhase).toString());
    }
  }
}
