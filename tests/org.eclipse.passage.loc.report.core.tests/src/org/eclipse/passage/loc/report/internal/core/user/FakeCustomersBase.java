/*******************************************************************************
 * Copyright (c) 2019, 2020 ArSysOp
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
package org.eclipse.passage.loc.report.internal.core.user;

import java.util.Collections;
import java.util.Set;

import org.eclipse.passage.lic.users.UserDescriptor;
import org.eclipse.passage.lic.users.UserOriginDescriptor;

final class FakeCustomersBase implements CustomerStorage {

	private final TestCustomers customers;

	FakeCustomersBase(TestCustomers customers) {
		this.customers = customers;
	}

	@Override
	public Set<UserDescriptor> personsUsedProducts(Set<String> products) {
		return customers.users();
	}

	@Override
	public Set<UserOriginDescriptor> companiesUsedProducts(Set<String> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> products() {
		return Collections.emptySet();
	}

}
