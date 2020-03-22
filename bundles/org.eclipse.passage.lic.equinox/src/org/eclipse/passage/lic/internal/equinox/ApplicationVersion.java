package org.eclipse.passage.lic.internal.equinox;

import java.util.function.Supplier;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.passage.lic.internal.base.BaseProductInfo;
import org.eclipse.passage.lic.internal.base.InvalidLicensingConfiguration;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

@SuppressWarnings("restriction")
public final class ApplicationVersion implements Supplier<String> {
	private final IApplicationContext context;

	public ApplicationVersion(IApplicationContext context) {
		this.context = context;
	}

	@Override
	public String get() {
		String property = new BaseProductInfo.Version(context::getBrandingProperty).get();
		if (property != null) {
			return property;
		}
		Bundle bundle = context.getBrandingBundle();
		if (bundle == null) {
			return new InvalidLicensingConfiguration().getProductVersion();
		}
		return stringify(bundle.getVersion());
	}

	private String stringify(Version version) {
		StringBuilder sb = new StringBuilder();
		sb.append(version.getMajor()).append('.');
		sb.append(version.getMinor()).append('.');
		sb.append(version.getMicro());
		return sb.toString();
	}

}
