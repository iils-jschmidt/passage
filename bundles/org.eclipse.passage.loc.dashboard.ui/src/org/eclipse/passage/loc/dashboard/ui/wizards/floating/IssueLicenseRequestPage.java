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
package org.eclipse.passage.loc.dashboard.ui.wizards.floating;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.passage.lic.licenses.LicensePlanDescriptor;
import org.eclipse.passage.lic.products.ProductVersionDescriptor;
import org.eclipse.passage.lic.users.UserDescriptor;
import org.eclipse.passage.loc.dashboard.ui.wizards.license.ComposedPage;

public final class IssueLicenseRequestPage implements Supplier<IWizardPage> {

	private final Supplier<Optional<LicensePlanDescriptor>> plan;
	private final Supplier<Optional<Collection<UserDescriptor>>> users;
	private final Supplier<Optional<ProductVersionDescriptor>> product;
	private final Supplier<Optional<List<LocalDate>>> period;
	private final Supplier<Optional<Integer>> capacity;
	private final ComposedPage page;

	IssueLicenseRequestPage(IEclipseContext context, FloatingDataPack initial) {
		page = new ComposedPage(IssueLicenseRequestPage.class.getSimpleName(), context);
		plan = page.withLicensePlan(initial.plan());
		users = page.withUsers();
		product = page.withProductVersion(initial.product());
		period = page.withPeriod();
		capacity = page.withCapacity();
	}

	@Override
	public IWizardPage get() {
		return page.get();
	}

}
