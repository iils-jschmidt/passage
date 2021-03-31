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
package org.eclipse.passage.lbc.base.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.passage.lbc.internal.base.EagerFloatingState;
import org.eclipse.passage.lbc.internal.base.api.FloatingState;
import org.eclipse.passage.lbc.internal.base.api.RawRequest;
import org.eclipse.passage.lic.floating.model.net.ServerAuthenticationExpression;
import org.eclipse.passage.lic.floating.model.net.ServerAuthenticationType;
import org.eclipse.passage.lic.internal.api.EvaluationType;
import org.eclipse.passage.lic.internal.api.PassageAction;
import org.eclipse.passage.lic.internal.base.NamedData;
import org.eclipse.passage.lic.internal.base.StringNamedData;
import org.eclipse.passage.lic.internal.base.io.MD5Hashes;
import org.eclipse.passage.lic.internal.net.EncodingAlgorithm;
import org.eclipse.passage.lic.internal.net.LicensingAction;

@SuppressWarnings("restriction")
final class RequestConstructed {

	private Map<String, String> params = new HashMap<>();
	private byte[] content;
	private FloatingState state;

	RequestConstructed() {
		this.state = new EagerFloatingState(new TestLicFolder());
	}

	RequestConstructed withParameters(Collection<NamedData<?>> data) {
		data.forEach(p -> params.put(p.key(), p.get().get().toString()));
		return this;
	}

	RequestConstructed withParameter(StringNamedData data) {
		params.put(data.key(), data.get().get());
		return this;
	}

	RequestConstructed withAction(PassageAction action) {
		LicensingAction parameter = new LicensingAction(action);
		params.put(parameter.key(), parameter.get().get().name());
		return this;
	}

	RequestConstructed withContent(byte[] bytes) {
		this.content = bytes;
		return this;
	}

	RequestConstructed withState(FloatingState st) {
		this.state = new EagerFloatingState(st.grants(), new TestLicFolder().get());
		return this;
	}

	RawRequest getValid() {
		addPredefinedParams();
		return getPure();
	}

	RawRequest getPure() {
		return new Franky(params, content, state);
	}

	private void addPredefinedParams() {
		Arrays.asList(//
				new ServerAuthenticationType(new EvaluationType.Hardware().identifier()), //
				new ServerAuthenticationExpression("os.family=*"), //$NON-NLS-1$
				new EncodingAlgorithm(new MD5Hashes().id().toString()) //
		).forEach(param -> params.put(param.key(), param.get().get()));
	}

	private static final class Franky implements RawRequest {

		private final Map<String, String> params;
		private final byte[] content;
		private final FloatingState state;

		Franky(Map<String, String> params, byte[] content, FloatingState state) {
			this.params = params;
			this.content = content;
			this.state = state;
		}

		@Override
		public String parameter(String name) {
			return params.get(name);
		}

		@Override
		public byte[] content() throws IOException {
			return content;
		}

		@Override
		public FloatingState state() {
			return state;
		}

	}

}
