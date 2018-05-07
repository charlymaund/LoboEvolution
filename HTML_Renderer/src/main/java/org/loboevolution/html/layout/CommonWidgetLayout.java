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
package org.loboevolution.html.layout;


import org.loboevolution.html.HtmlAttributeProperties;
import org.loboevolution.html.dombl.UINode;
import org.loboevolution.html.domimpl.HTMLElementImpl;
import org.loboevolution.html.renderer.RElement;
import org.loboevolution.html.rendererblock.RBlockPosition;
import org.loboevolution.html.rendererblock.RBlockViewport;
import org.loboevolution.html.style.AbstractCSSProperties;

/**
 * The Class CommonWidgetLayout.
 */
public abstract class CommonWidgetLayout implements MarkupLayout, HtmlAttributeProperties {

	/** The Constant ADD_INLINE. */
	protected static final int ADD_INLINE = 0;

	/** The Constant ADD_AS_BLOCK. */
	protected static final int ADD_AS_BLOCK = 1;

	/** The method. */
	private final int method;

	/** The use align attribute. */
	private final boolean useAlignAttribute;

	/**
	 * Instantiates a new common widget layout.
	 *
	 * @param method
	 *            the method
	 * @param usesAlignAttribute
	 *            the uses align attribute
	 */
	public CommonWidgetLayout(int method, boolean usesAlignAttribute) {
		this.method = method;
		this.useAlignAttribute = usesAlignAttribute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.loboevolution.html.renderer.MarkupLayout#layoutMarkup(org.loboevolution.
	 * html .renderer.RBlockViewport,
	 * org.loboevolution.html.domimpl.HTMLElementImpl)
	 */
	@Override
	public void layoutMarkup(RBlockViewport bodyLayout, HTMLElementImpl markupElement) {
		AbstractCSSProperties style = markupElement.getCurrentStyle();
		if (style != null) {
			String display = style.getDisplay();
			if (display != null && "none".equalsIgnoreCase(display)) {
				return;
			}
		}
		UINode node = markupElement.getUINode();
		RElement renderable = null;
		if (node == null) {
			renderable = this.createRenderable(bodyLayout, markupElement);
			if (renderable == null) {
				return;
			}
			markupElement.setUINode(renderable);
		} else {
			renderable = (RElement) node;
		}
		renderable.setOriginalParent(bodyLayout);
		switch (this.method) {
		case ADD_INLINE:
			bodyLayout.addRenderableToLineCheckStyle(renderable, markupElement, this.useAlignAttribute);
			break;
		case ADD_AS_BLOCK:
			RBlockPosition ps = new RBlockPosition();
			ps.positionRElement(markupElement, renderable, bodyLayout, this.useAlignAttribute, true, false);
			break;
		default:
			break;
		}
	}

	/**
	 * Creates the renderable.
	 *
	 * @param bodyLayout
	 *            the body layout
	 * @param markupElement
	 *            the markup element
	 * @return the r element
	 */
	protected abstract RElement createRenderable(RBlockViewport bodyLayout, HTMLElementImpl markupElement);
}
