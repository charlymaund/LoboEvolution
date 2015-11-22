/*
* Copyright (c) 2002 and later by MH Software-Entwicklung. All Rights Reserved.
*  
* JTattoo is multiple licensed. If your are an open source developer you can use
* it under the terms and conditions of the GNU General Public License version 2.0
* or later as published by the Free Software Foundation.
*  
* see: gpl-2.0.txt
* 
* If you pay for a license you will become a registered user who could use the
* software under the terms and conditions of the GNU Lesser General Public License
* version 2.0 or later with classpath exception as published by the Free Software
* Foundation.
* 
* see: lgpl-2.0.txt
* see: classpath-exception.txt
* 
* Registered users could also use JTattoo under the terms and conditions of the 
* Apache License, Version 2.0 as published by the Apache Software Foundation.
*  
* see: APACHE-LICENSE-2.0.txt
*/
 
package com.jtattoo.plaf.bernstein;

import com.jtattoo.plaf.BaseDesktopPaneUI;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

/**
 * The Class BernsteinDesktopPaneUI.
 *
 * @author Michael Hagen
 */
public class BernsteinDesktopPaneUI extends BaseDesktopPaneUI {

    /** The desktop pane ui. */
    private static BernsteinDesktopPaneUI desktopPaneUI = null;

    public static ComponentUI createUI(JComponent c) {
        if (desktopPaneUI == null) {
            desktopPaneUI = new BernsteinDesktopPaneUI();
        }
        return desktopPaneUI;
    }

    public void update(Graphics g, JComponent c) {
        if (c.getClientProperty("backgroundTexture") == null) {
            BernsteinUtils.fillComponent(g, c);
        } else {
            super.update(g, c);
        }
    }
}
