/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.VarMode#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getVarMode()
 * @model
 * @generated
 */
public interface VarMode extends EObject
{
  /**
   * Returns the value of the '<em><b>Mode</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' containment reference.
   * @see #setMode(MessageMode)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getVarMode_Mode()
   * @model containment="true"
   * @generated
   */
  MessageMode getMode();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.VarMode#getMode <em>Mode</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mode</em>' containment reference.
   * @see #getMode()
   * @generated
   */
  void setMode(MessageMode value);

} // VarMode
