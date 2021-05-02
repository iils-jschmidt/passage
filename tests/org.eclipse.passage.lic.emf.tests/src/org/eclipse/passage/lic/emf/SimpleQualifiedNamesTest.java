/*******************************************************************************
 * Copyright (c) 2021 ArSysOp
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
package org.eclipse.passage.lic.emf;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Test;

public class SimpleQualifiedNamesTest {

	private final SimpleQualifiedNames cut = new SimpleQualifiedNames();

	@Test
	public void invalid() {
		assertEquals("", cut.caseEClass(null)); //$NON-NLS-1$
		assertEquals("", cut.caseEDataType(null)); //$NON-NLS-1$
	}

	@Test
	public void plain() {
		EClass ec = EcoreFactory.eINSTANCE.createEClass();
		ec.setName("ec"); //$NON-NLS-1$
		assertEquals("ec", cut.caseEClass(ec)); //$NON-NLS-1$
		EDataType edt = EcoreFactory.eINSTANCE.createEDataType();
		edt.setName("edt"); //$NON-NLS-1$
		assertEquals("edt", cut.caseEDataType(edt)); //$NON-NLS-1$
	}

	@Test
	public void qualifed() {
		EPackage ep = EcoreFactory.eINSTANCE.createEPackage();
		ep.setNsPrefix("nsp"); //$NON-NLS-1$
		ep.setName("ep"); //$NON-NLS-1$
		EClass ec = EcoreFactory.eINSTANCE.createEClass();
		ec.setName("ec"); //$NON-NLS-1$
		ep.getEClassifiers().add(ec);
		assertEquals("nsp.ep.ec", cut.caseEClass(ec)); //$NON-NLS-1$
		EDataType edt = EcoreFactory.eINSTANCE.createEDataType();
		edt.setName("edt"); //$NON-NLS-1$
		ep.getEClassifiers().add(edt);
		assertEquals("nsp.ep.edt", cut.caseEDataType(edt)); //$NON-NLS-1$
	}
}
