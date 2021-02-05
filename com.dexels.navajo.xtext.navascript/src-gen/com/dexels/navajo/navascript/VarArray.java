/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.VarArray#getVararrayelement <em>Vararrayelement</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getVarArray()
 * @model
 * @generated
 */
public interface VarArray extends EObject
{
  /**
   * Returns the value of the '<em><b>Vararrayelement</b></em>' containment reference list.
   * The list contents are of type {@link com.dexels.navajo.navascript.VarArrayElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vararrayelement</em>' containment reference list.
   * @see com.dexels.navajo.navascript.NavascriptPackage#getVarArray_Vararrayelement()
   * @model containment="true"
   * @generated
   */
  EList<VarArrayElement> getVararrayelement();

} // VarArray
