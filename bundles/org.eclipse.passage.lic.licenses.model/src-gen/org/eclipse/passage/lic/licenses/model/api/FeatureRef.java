/*******************************************************************************
 * Copyright (c) 2018, 2021 ArSysOp
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     ArSysOp - initial API and implementation
 *******************************************************************************/
package org.eclipse.passage.lic.licenses.model.api;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.passage.lic.licenses.FeatureRefDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.passage.lic.licenses.model.api.FeatureRef#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.licenses.model.api.FeatureRef#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.passage.lic.licenses.model.api.FeatureRef#getMatchingRule <em>Matching Rule</em>}</li>
 * </ul>
 *
 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getFeatureRef()
 * @model superTypes="org.eclipse.passage.lic.licenses.model.api.FeatureRefDescriptor"
 * @generated
 */
public interface FeatureRef extends EObject, FeatureRefDescriptor {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getFeatureRef_Identifier()
	 * @model required="true"
	 * @generated
	 */
	@Override
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.passage.lic.licenses.model.api.FeatureRef#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getFeatureRef_Version()
	 * @model required="true"
	 * @generated
	 */
	@Override
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.passage.lic.licenses.model.api.FeatureRef#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Matching Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matching Rule</em>' attribute.
	 * @see #setMatchingRule(String)
	 * @see org.eclipse.passage.lic.licenses.model.meta.LicensesPackage#getFeatureRef_MatchingRule()
	 * @model required="true"
	 * @generated
	 */
	@Override
	String getMatchingRule();

	/**
	 * Sets the value of the '{@link org.eclipse.passage.lic.licenses.model.api.FeatureRef#getMatchingRule <em>Matching Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matching Rule</em>' attribute.
	 * @see #getMatchingRule()
	 * @generated
	 */
	void setMatchingRule(String value);

} // FeatureRef
