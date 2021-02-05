/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.Validations#getChecks <em>Checks</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getValidations()
 * @model
 * @generated
 */
public interface Validations extends EObject
{
  /**
   * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
   * The list contents are of type {@link com.dexels.navajo.navascript.Check}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checks</em>' containment reference list.
   * @see com.dexels.navajo.navascript.NavascriptPackage#getValidations_Checks()
   * @model containment="true"
   * @generated
   */
  EList<Check> getChecks();

} // Validations
