/*
 * Copyright 2020 Martin Winandy
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.tinylog.core.runtime;

/**
 * Stack trace location implementation for legacy Java 8 that stores the location of a callee as numeric index.
 */
public final class JavaIndexBasedStackTraceLocation extends AbstractJavaStackTraceLocation {

	private final int index;

	/**
	 * @param index The index of the callee in the stack trace
	 */
	JavaIndexBasedStackTraceLocation(int index) {
		this.index = index;
	}

	@Override
	public JavaIndexBasedStackTraceLocation push() {
		return new JavaIndexBasedStackTraceLocation(index + 1);
	}

	@Override
	public String getCallerClassName() {
		if (callerClassGetter != null) {
			try {
				Class<?> clazz = (Class<?>) callerClassGetter.invoke(index + 1);
				return clazz.getName();
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
		}

		StackTraceElement element = push().getCallerStackTraceElement();
		return element == null ? null : element.getClassName();
	}

	@Override
	public StackTraceElement getCallerStackTraceElement() {
		StackTraceElement[] trace = new Throwable().getStackTrace();
		return index >= 0 && index < trace.length ? trace[index] : null;
	}

}