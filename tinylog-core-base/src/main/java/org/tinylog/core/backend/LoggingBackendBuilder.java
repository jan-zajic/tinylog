package org.tinylog.core.backend;

import org.tinylog.core.Framework;

/**
 * Builder for creating {@link LoggingBackend LoggingBackends}.
 *
 * <p>
 *     This interface must be implemented by all logging backends and provided as
 *     {@link java.util.ServiceLoader service} in {@code META-INF/services}.
 * </p>
 */
public interface LoggingBackendBuilder {

	/**
	 * Gets the name of the logging backend, which can be used to address the logging backend in a configuration.
	 *
	 * <p>
	 *     The name must start with a lower case ASCII letter [a-z] and end with a lower case ASCII letter [a-z] or
	 *     digit [0-9]. Within the name, lower case letters [a-z], numbers [0-9], spaces [ ], and hyphens [-] are
	 *     allowed.
	 * </p>
	 *
	 * @return The name of the logging backend
	 */
	String getName();

	/**
	 * Creates a new instance of the logging backend.
	 *
	 * @param framework The actual logging framework instance
	 * @return New instance of the logging backend
	 */
	LoggingBackend create(Framework framework);

}