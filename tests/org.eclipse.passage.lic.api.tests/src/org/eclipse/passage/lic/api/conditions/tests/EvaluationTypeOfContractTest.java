/*******************************************************************************
 * Copyright (c) 2020 ArSysOp
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
package org.eclipse.passage.lic.api.conditions.tests;

import org.eclipse.passage.lic.internal.api.conditions.EvaluationType;

@SuppressWarnings("restriction")
public final class EvaluationTypeOfContractTest extends EvaluationTypeContractTest {

	@Override
	protected EvaluationType forIdentifier(String identifier) {
		return new EvaluationType.Of(identifier);
	}

}
