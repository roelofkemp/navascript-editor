/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.TypeArgument#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getTypeArgument()
 * @model
 * @generated
 */
public interface TypeArgument extends PropertyArgument
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(PropertyType)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getTypeArgument_Value()
   * @model containment="true"
   * @generated
   */
  PropertyType getValue();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.TypeArgument#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(PropertyType value);

} // TypeArgument
