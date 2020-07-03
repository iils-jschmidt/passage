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
package org.eclipse.passage.lic.internal.bc.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

final class PairContent extends PairInfo<byte[]> {

	PairContent(Path pub, Path secret) throws IOException {
		super(pub, secret);
	}

	@Override
	protected byte[] info(Path file) throws IOException {
		byte[] content = new byte[(int) Files.size(file)];
		try (InputStream stream = new FileInputStream(file.toFile())) {
			stream.read(content);
		}
		return content;
	}

}
