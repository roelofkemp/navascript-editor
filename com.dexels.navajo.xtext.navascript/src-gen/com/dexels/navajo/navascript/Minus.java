/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Minus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.Minus#getLeft <em>Left</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Minus#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getMinus()
 * @model
 * @generated
 */
public interface Minus extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMinus_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Minus#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMinus_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Minus#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // Minus
