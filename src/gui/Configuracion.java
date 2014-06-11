/*
 * Copyright (C) 2014 Benito Palacios Sánchez
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Configuracion {
    private static List<Image> PacmanImgs;
    
    public static void Inicializa(final String resPath) {
        // Load pacman images
        int i = 0;
        PacmanImgs = new ArrayList<>();
        File currFile = new File(resPath, "pacman" + i + ".png");
        while (currFile.exists()) {
            PacmanImgs.add(Toolkit.getDefaultToolkit().createImage(
                                    currFile.getAbsolutePath()));
            currFile = new File(resPath, "pacman" + (++i) + ".png");
        }
    }
    
    public static Image[] getPacmanImgs() {
        return PacmanImgs.toArray(new Image[0]);
    }
}
