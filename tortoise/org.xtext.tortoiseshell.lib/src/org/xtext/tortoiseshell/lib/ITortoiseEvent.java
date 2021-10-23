/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.xtext.tortoiseshell.lib;

import org.xtext.tortoiseshell.lib.Tortoise;

public interface ITortoiseEvent {

	Tortoise getTortoise();
	
	interface Listener {
		void handleTortoiseEvent(ITortoiseEvent event);
	}
}