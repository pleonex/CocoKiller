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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 */
public class Configuracion {
    private static List<BufferedImage> PacmanImgs;
    private static List<BufferedImage[]> MapImgs;
    
    public static void Inicializa(final String resPath) {
        int i;
        File currFile;
        try {
            // Load pacman images
            i = 0;
            PacmanImgs = new ArrayList<>();
            currFile = new File(resPath, "pacman" + i + ".png");
            while (currFile.exists()) {
                PacmanImgs.add(ImageIO.read(currFile));
                currFile = new File(resPath, "pacman" + (++i) + ".png");
            }

            // Load map images
            i = 0;
            MapImgs = new ArrayList<>();
            currFile = new File(resPath, "mapa" + i + ".png");
            while (currFile.exists()) {
                MapImgs.add(new BufferedImage[] { 
                    ImageIO.read(currFile),
                    ImageIO.read(new File(resPath, "coli" + i + ".png"))
                });
                currFile = new File(resPath, "mapa" + (++i) + ".png");
            }
        } catch (IOException ex) {
            
        }
    }
    
    public static BufferedImage[] getPacmanImgs() {
        return PacmanImgs.toArray(new BufferedImage[0]);
    }
    
    public static BufferedImage getMapImg(int level) {
        return MapImgs.get(level)[0];
    }
    
    public static BufferedImage getColiImg(int level) {
        return MapImgs.get(level)[1];
    }
}
