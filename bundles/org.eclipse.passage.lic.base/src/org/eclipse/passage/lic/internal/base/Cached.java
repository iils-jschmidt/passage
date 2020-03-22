package org.eclipse.passage.lic.internal.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * To be removed after arsysop.lang is approved
 * 
 */
public final class Cached<S, T> {
	private final S source;
	private final Function<S, T> retrieve;
	private final List<T> value = new ArrayList<T>(1);

	/**
	 * To create a <i>late init</i> value, you should specify a {@code source} for
	 * initialization and a {@code way} to perform it.
	 * 
	 * @param source   original data sufficient to build the <i>late init-ed
	 *                 value</i> from it
	 * @param retrieve a function that builds <i>the late init value</i> from a
	 *                 given {@code source}. It is guaranteed to be called ones and
	 *                 only when {@linkplain get} method is called.
	 * @since 0.1
	 */
	public Cached(S source, Function<S, T> retrieve) {
		Objects.requireNonNull(source);
		Objects.requireNonNull(retrieve);
		this.source = source;
		this.retrieve = retrieve;
	}

	/**
	 * Returns cashed value. The first call begets {@code the value retrieval} and
	 * cashing.
	 * 
	 * @since 0.1
	 */
	public T get() {
		if (value.isEmpty()) {
			value.add(retrieve.apply(source));
		}
		return value.get(0);
	}

}
