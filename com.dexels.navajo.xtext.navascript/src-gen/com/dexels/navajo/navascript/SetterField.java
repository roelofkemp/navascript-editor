/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Setter Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.SetterField#getField <em>Field</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.SetterField#getExpressionList <em>Expression List</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.SetterField#getMappedArray <em>Mapped Array</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.SetterField#getMappedField <em>Mapped Field</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getSetterField()
 * @model
 * @generated
 */
public interface SetterField extends MethodOrSetter
{
  /**
   * Returns the value of the '<em><b>Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' attribute.
   * @see #setField(String)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getSetterField_Field()
   * @model
   * @generated
   */
  String getField();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.SetterField#getField <em>Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' attribute.
   * @see #getField()
   * @generated
   */
  void setField(String value);

  /**
   * Returns the value of the '<em><b>Expression List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression List</em>' containment reference.
   * @see #setExpressionList(ConditionalExpressions)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getSetterField_ExpressionList()
   * @model containment="true"
   * @generated
   */
  ConditionalExpressions getExpressionList();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.SetterField#getExpressionList <em>Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression List</em>' containment reference.
   * @see #getExpressionList()
   * @generated
   */
  void setExpressionList(ConditionalExpressions value);

  /**
   * Returns the value of the '<em><b>Mapped Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mapped Array</em>' containment reference.
   * @see #setMappedArray(MappedArrayMessage)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getSetterField_MappedArray()
   * @model containment="true"
   * @generated
   */
  MappedArrayMessage getMappedArray();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.SetterField#getMappedArray <em>Mapped Array</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mapped Array</em>' containment reference.
   * @see #getMappedArray()
   * @generated
   */
  void setMappedArray(MappedArrayMessage value);

  /**
   * Returns the value of the '<em><b>Mapped Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mapped Field</em>' containment reference.
   * @see #setMappedField(MappedArrayField)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getSetterField_MappedField()
   * @model containment="true"
   * @generated
   */
  MappedArrayField getMappedField();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.SetterField#getMappedField <em>Mapped Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mapped Field</em>' containment reference.
   * @see #getMappedField()
   * @generated
   */
  void setMappedField(MappedArrayField value);

} // SetterField
