/*
    GNU GENERAL LICENSE
    Copyright (C) 2014 - 2018 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General License for more details.

    You should have received a copy of the GNU General Public
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    

    Contact info: ivan.difrancesco@yahoo.it
 */
package org.loboevolution.html.js.event;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.loboevolution.w3c.events.CustomEvent;
import org.loboevolution.w3c.html.HTMLElement;

/**
 * The Class CustomEventImpl.
 */
public class CustomEventImpl extends EventImpl implements CustomEvent {

	/**
	 * Instantiates a new custom event impl.
	 */
	public CustomEventImpl() {
	}

	/**
	 * Instantiates a new custom event impl.
	 *
	 * @param type
	 *            the type
	 * @param srcElement
	 *            the src element
	 */
	public CustomEventImpl(String type, HTMLElement srcElement) {
		super(type, srcElement);
	}

	/**
	 * Instantiates a new custom event impl.
	 *
	 * @param type
	 *            the type
	 * @param srcElement
	 *            the src element
	 * @param mouseEvent
	 *            the mouse event
	 * @param leafX
	 *            the leaf x
	 * @param leafY
	 *            the leaf y
	 */
	public CustomEventImpl(String type, HTMLElement srcElement, InputEvent mouseEvent, int leafX, int leafY) {
		super(type, srcElement, mouseEvent, leafX, leafY);
	}

	/**
	 * Instantiates a new custom event impl.
	 *
	 * @param type
	 *            the type
	 * @param srcElement
	 *            the src element
	 * @param keyEvent
	 *            the key event
	 */
	public CustomEventImpl(String type, HTMLElement srcElement, KeyEvent keyEvent) {
		super(type, srcElement, keyEvent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.loboevolution.w3c.events.CustomEvent#initCustomEvent(java.lang.String,
	 * boolean, boolean, int)
	 */
	@Override
	public void initCustomEvent(String type, boolean canBubble, boolean cancelable, int detail) {
		setType(type);
		setCanBubble(canBubble);
		setCancelable(cancelable);
		setDetail(detail);
	}
}
