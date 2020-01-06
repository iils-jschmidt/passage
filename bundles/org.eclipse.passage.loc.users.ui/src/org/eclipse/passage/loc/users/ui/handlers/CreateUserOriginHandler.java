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
package org.eclipse.passage.loc.users.ui.handlers;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.passage.loc.users.core.Users;
import org.eclipse.passage.loc.users.ui.UsersUi;
import org.eclipse.passage.loc.workbench.LocWokbench;

public class CreateUserOriginHandler {

	@Execute
	public void execute(IEclipseContext context) {
		String domain = Users.DOMAIN_NAME;
		String perspectiveId = UsersUi.PERSPECTIVE_MAIN;
		LocWokbench.createDomainResource(context, domain, perspectiveId);
	}

}