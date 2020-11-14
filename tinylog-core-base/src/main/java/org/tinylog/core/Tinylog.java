package org.tinylog.core;

/**
 * Global access to the tinylog framework.
 */
public final class Tinylog {

	private static final Framework framework = new Framework(true, true);

	/** */
	private Tinylog() {
	}

	/**
	 * Gets the configuration.
	 *
	 * @return The configuration of tinylog
	 */
	public static Configuration getConfiguration() {
		return framework.getConfiguration();
	}

	/**
	 * Gets the actual framework instance.
	 *
	 * <p>
	 *     This framework instance is only for tinylog itself and tinylog extensions.
	 * </p>
	 *
	 * @return The actual framework instance
	 */
	public static Framework getFramework() {
		return framework;
	}

	/**
	 * Registers a new {@link Hook}.
	 *
	 * @param hook Hook to register
	 */
	public static void registerHook(Hook hook) {
		framework.registerHook(hook);
	}

	/**
	 * Removes a registered {@link Hook}.
	 *
	 * @param hook Hook to unregister
	 */
	public static void removeHook(Hook hook) {
		framework.removeHook(hook);
	}

	/**
	 * Starts tinylog if it is not running yet.
	 *
	 * <p>
	 *     When the first log entry is issued, tinylog starts automatically by itself. This method only needs to be
	 *     called in a few corner cases.
	 * </p>
	 */
	public static void startUp() {
		framework.startUp();
	}

	/**
	 * Shuts down tinylog manually.
	 *
	 * <p>
	 *     If auto shutdown has not been disabled, tinylog will shut down by itself. This method only needs to be called
	 *     if auto shutdown has been explicitly disabled.
	 * </p>
	 */
	public static void shutDown() {
		framework.shutDown();
	}

}