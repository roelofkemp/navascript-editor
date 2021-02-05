/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Level Statements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.TopLevelStatements#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getTopLevelStatements()
 * @model
 * @generated
 */
public interface TopLevelStatements extends EObject
{
  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link com.dexels.navajo.navascript.TopLevelStatement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see com.dexels.navajo.navascript.NavascriptPackage#getTopLevelStatements_Statements()
   * @model containment="true"
   * @generated
   */
  EList<TopLevelStatement> getStatements();

} // TopLevelStatements
