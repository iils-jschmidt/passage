/*******************************************************************************
 * Copyright (c) 2018-2019 ArSysOp
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
package org.eclipse.passage.loc.products.ui;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.passage.lic.emf.edit.ComposedAdapterFactoryProvider;
import org.eclipse.passage.lic.products.ProductDescriptor;
import org.eclipse.passage.lic.products.ProductVersionDescriptor;
import org.eclipse.passage.lic.products.model.meta.ProductsPackage;
import org.eclipse.passage.lic.products.registry.ProductRegistry;
import org.eclipse.passage.loc.internal.products.ui.i18n.ProductsUiMessages;
import org.eclipse.passage.loc.workbench.LocWokbench;
import org.eclipse.swt.widgets.Shell;

public class ProductsUi {

	public static final String BUNDLE_SYMBOLIC_NAME = "org.eclipse.passage.loc.products.ui"; //$NON-NLS-1$

	public static final String PERSPECTIVE_MAIN = BUNDLE_SYMBOLIC_NAME + '.' + "perspective.main"; //$NON-NLS-1$

	public static ProductDescriptor selectProductDescriptor(Shell shell, ComposedAdapterFactoryProvider provider,
			ProductRegistry registry, ProductDescriptor initial) {
		String classifier = ProductsPackage.eINSTANCE.getProduct().getName();
		String title = ProductsUiMessages.ProductsUi_select_product;
		Iterable<? extends ProductDescriptor> input = registry.getProducts();
		Class<ProductDescriptor> clazz = ProductDescriptor.class;
		ComposedAdapterFactory factory = provider.getComposedAdapterFactory();
		return LocWokbench.selectClassifier(shell, factory, classifier, title, input, initial, clazz);
	}

	public static ProductVersionDescriptor selectProductVersionDescriptor(Shell shell,
			ComposedAdapterFactoryProvider provider, ProductRegistry registry, ProductVersionDescriptor initial) {
		String classifier = ProductsPackage.eINSTANCE.getProductVersion().getName();
		String title = ProductsUiMessages.ProductsUi_select_product_line;
		Iterable<? extends ProductVersionDescriptor> input = registry.getProductVersions();
		Class<ProductVersionDescriptor> clazz = ProductVersionDescriptor.class;
		ComposedAdapterFactory factory = provider.getComposedAdapterFactory();
		return LocWokbench.selectClassifier(shell, factory, classifier, title, input, initial, clazz);
	}

}
