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

import controladores.Mando;
import java.awt.event.KeyEvent;
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
    private static List<BufferedImage> Pacman1Imgs;
    private static List<BufferedImage> Pacman2Imgs;
    private static List<BufferedImage> FantasmaImgs0;
    private static List<BufferedImage[]> MapImgs;
    
    public static void Inicializa(final String resPath) {
        int i;
        File currFile;
        try {
            // Load pacman images
            Pacman1Imgs = LoadImages(resPath, "pacman", ".png");
            Pacman2Imgs = LoadImages(resPath, "pacmana", ".png");
            
            // Load ghosts
            FantasmaImgs0 = LoadImages(resPath, "fantasma0_D", ".png");

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
    
    private static List<BufferedImage> LoadImages(final String resPath, 
                                    final String preStr, final String postStr) {
        int i = 0;
        List<BufferedImage> imgs = new ArrayList<>();
        File currFile = new File(resPath, preStr + i + postStr);        
        try {
            while (currFile.exists()) {
                imgs.add(ImageIO.read(currFile));
                currFile = new File(resPath, preStr + (++i) + postStr);
            }
        } catch(IOException ex) {
            
        }
        
        return imgs;
    }
    
    public static BufferedImage[] getPacman1Imgs() {
        return Pacman1Imgs.toArray(new BufferedImage[0]);
    }
 
    public static BufferedImage[] getPacman2Imgs() {
        return Pacman2Imgs.toArray(new BufferedImage[0]);
    }
    
    public static BufferedImage getMapImg(int level) {
        return MapImgs.get(level)[0];
    }
    
    public static BufferedImage getColiImg(int level) {
        return MapImgs.get(level)[1];
    }
    
    public static BufferedImage[] getFantasmasImg(int tipo) {
        if (tipo == 0)
            return FantasmaImgs0.toArray(new BufferedImage[0]);
        else
            return null;
    }
    
    public static Mando GetMando1() {
        return new Mando(
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_UP,
                KeyEvent.VK_DOWN,
                KeyEvent.KEY_LOCATION_LEFT | KeyEvent.VK_CONTROL
        );
    }
    
    public static Mando GetMando2() {
        return new Mando(
                KeyEvent.VK_A,
                KeyEvent.VK_D,
                KeyEvent.VK_W,
                KeyEvent.VK_S,
                KeyEvent.VK_SPACE
        );
    }
}
