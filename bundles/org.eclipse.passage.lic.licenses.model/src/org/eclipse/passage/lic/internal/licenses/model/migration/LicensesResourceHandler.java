/*******************************************************************************
 * Copyright (c) 2020, 2021 ArSysOp
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
package org.eclipse.passage.lic.internal.licenses.model.migration;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.passage.lic.emf.migration.DelegateClassifiers;
import org.eclipse.passage.lic.emf.migration.EClassRoutes;
import org.eclipse.passage.lic.emf.migration.MigrationRoutes;
import org.eclipse.passage.lic.emf.migration.SimpleAttributeRoute;
import org.eclipse.passage.lic.emf.migration.SimpleClassRoutes;
import org.eclipse.passage.lic.emf.migration.SimpleMigrationRoutes;
import org.eclipse.passage.lic.emf.migration.SimpleReferenceRoute;
import org.eclipse.passage.lic.emf.xmi.MigratingResourceHandler;
import org.eclipse.passage.lic.internal.licenses.model.AssignGrantIdentifiers;
import org.eclipse.passage.lic.licenses.model.api.PersonalLicensePack;
import org.eclipse.passage.lic.licenses.model.meta.LicensesPackage;

public class LicensesResourceHandler extends MigratingResourceHandler {

	@Override
	public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
		super.postLoad(resource, inputStream, options);
		resource.getContents().stream()//
				.filter(PersonalLicensePack.class::isInstance)//
				.map(PersonalLicensePack.class::cast)//
				.forEach(new AssignGrantIdentifiers());
	}

	@Override
	protected void ensureMigrations() {
		migrate033();
		migrate040();
		migrate050();
		migrate100();
		migrate110();
	}

	@Override
	protected MigrationRoutes attributes() {
		MigrationRoutes routes = new SimpleMigrationRoutes();
		LicensesPackage licenses = LicensesPackage.eINSTANCE;

		routes.define("licenseGrants", new SimpleReferenceRoute(licenses.getPersonalLicensePack_Grants())); //$NON-NLS-1$
		routes.define("licensePack", new SimpleReferenceRoute(licenses.getLicenseGrant_Pack())); //$NON-NLS-1$
		routes.define("licensePlanFeatures", new SimpleReferenceRoute(licenses.getLicensePlan_Features())); //$NON-NLS-1$
		routes.define("licensePlan", new SimpleReferenceRoute(licenses.getLicensePlanFeature_Plan())); //$NON-NLS-1$

		routes.define("conditionExpression", new SimpleAttributeRoute(licenses.getEvaluationInstructions_Expression(), //$NON-NLS-1$
				licenses.getLicenseGrant_UserAuthentication()));
		routes.define("conditionType", new SimpleAttributeRoute(licenses.getEvaluationInstructions_Type(), //$NON-NLS-1$
				licenses.getLicenseGrant_UserAuthentication()));
		routes.define("featureIdentifier", //$NON-NLS-1$
				new SimpleAttributeRoute(licenses.getFeatureRef_Identifier(), licenses.getLicenseGrant_Feature()));
		routes.define("identifier", new SimpleAttributeRoute(licenses.getLicenseGrant_Identifier())); //$NON-NLS-1$
		routes.define("identifier", new SimpleAttributeRoute(licenses.getLicenseRequisites_Identifier(), //$NON-NLS-1$
				licenses.getPersonalLicensePack_License()));
		routes.define("issueDate", new SimpleAttributeRoute(licenses.getLicenseRequisites_IssueDate(), //$NON-NLS-1$
				licenses.getPersonalLicensePack_License()));
		routes.define("matchRule", new SimpleAttributeRoute(licenses.getVersionMatch_Rule(), //$NON-NLS-1$
				licenses.getLicenseGrant_Feature(), licenses.getFeatureRef_VersionMatch()));
		routes.define("matchVersion", new SimpleAttributeRoute(licenses.getVersionMatch_Version(), //$NON-NLS-1$
				licenses.getLicenseGrant_Feature(), licenses.getFeatureRef_VersionMatch()));
		routes.define("planIdentifier", new SimpleAttributeRoute(licenses.getLicenseRequisites_Plan(), //$NON-NLS-1$
				licenses.getPersonalLicensePack_License()));
		routes.define("productIdentifier", new SimpleAttributeRoute(licenses.getProductRef_Identifier(), //$NON-NLS-1$
				licenses.getPersonalLicensePack_License(), licenses.getLicenseRequisites_Product()));
		routes.define("productVersion", new SimpleAttributeRoute(licenses.getProductRef_Version(), //$NON-NLS-1$
				licenses.getPersonalLicensePack_License(), licenses.getLicenseRequisites_Product()));
		routes.define("userIdentifier", new SimpleAttributeRoute(licenses.getUserRef_Identifier(), //$NON-NLS-1$
				licenses.getPersonalLicensePack_License(), licenses.getPersonalLicenseRequisites_User()));
		routes.define("userFullName", new SimpleAttributeRoute(licenses.getUserRef_Name(), //$NON-NLS-1$
				licenses.getPersonalLicensePack_License(), licenses.getPersonalLicenseRequisites_User()));
		routes.define("validFrom", //$NON-NLS-1$
				new SimpleAttributeRoute(licenses.getValidityPeriodClosed_From(), licenses.getLicenseGrant_Valid()));
		routes.define("validUntil", //$NON-NLS-1$
				new SimpleAttributeRoute(licenses.getValidityPeriodClosed_Until(), licenses.getLicenseGrant_Valid()));
		routes.ignore("requestIdentifier", licenses.getPersonalLicensePack()); //$NON-NLS-1$
		return routes;
	}

	private void migrate033() {
		String uri = "http://www.eclipse.org/passage/lic/0.3.3"; //$NON-NLS-1$
		new DelegateClassifiers(uri).delegate(classRoutes200());
	}

	private void migrate040() {
		String uri = "http://www.eclipse.org/passage/lic/licenses/0.4.0"; //$NON-NLS-1$
		new DelegateClassifiers(uri).delegate(classRoutes200());
	}

	private void migrate050() {
		String uri = "http://www.eclipse.org/passage/lic/licenses/0.5.0"; //$NON-NLS-1$
		new DelegateClassifiers(uri).delegate(classRoutes200());
	}

	private void migrate100() {
		String uri = "http://www.eclipse.org/passage/lic/licenses/1.0.0"; //$NON-NLS-1$
		new DelegateClassifiers(uri).delegate(classRoutes200());
	}

	private void migrate110() {
		String uri = "http://www.eclipse.org/passage/lic/licenses/1.1.0"; //$NON-NLS-1$
		new DelegateClassifiers(uri).delegate(classRoutes200());
	}

	private EClassRoutes classRoutes200() {
		LicensesPackage delegate = LicensesPackage.eINSTANCE;
		EClassRoutes routes = new SimpleClassRoutes();
		routes.define("LicensePack", delegate.getPersonalLicensePack()); //$NON-NLS-1$
		routes.define("LicenseGrant", delegate.getLicenseGrant()); //$NON-NLS-1$
		routes.define("LicensePlan", delegate.getLicensePlan()); //$NON-NLS-1$
		routes.define("LicensePlanFeature", delegate.getLicensePlanFeature()); //$NON-NLS-1$
		return routes;
	}

}
