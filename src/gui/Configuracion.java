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

import controladores.Direccion;
import controladores.Mando;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 */
public class Configuracion {
    private static Map<String, BufferedImage[]> Pacman1Imgs;
    private static Map<String, BufferedImage[]> Pacman2Imgs;
    private static Map<String, BufferedImage[]> FantasmaImgs0;
    private static List<BufferedImage[]> MapImgs;
    
    public static void Inicializa(final String resPath) {
        int i;
        File currFile;
        try {
            // Load pacman images
            Pacman1Imgs = new HashMap<>(4);
            Pacman1Imgs.put("DERECHA", LoadImages(resPath, "pacman_D"));
            Pacman1Imgs.put("IZQUIERDA", LoadImages(resPath, "pacman_I"));
            Pacman1Imgs.put("ABAJO", LoadImages(resPath, "pacman_AB"));
            Pacman1Imgs.put("ARRIBA", LoadImages(resPath, "pacman_AR"));

            Pacman2Imgs = new HashMap<>(4);
            Pacman2Imgs.put("DERECHA", LoadImages(resPath, "pacmana_D"));
            Pacman2Imgs.put("IZQUIERDA", LoadImages(resPath, "pacmana_I"));
            Pacman2Imgs.put("ABAJO", LoadImages(resPath, "pacmana_AB"));
            Pacman2Imgs.put("ARRIBA", LoadImages(resPath, "pacmana_AR"));
            
            // Load ghosts
            FantasmaImgs0 = new HashMap<>(4);
            FantasmaImgs0.put("DERECHA", LoadImages(resPath, "fantasma0_D"));
            FantasmaImgs0.put("IZQUIERDA", LoadImages(resPath, "fantasma0_I"));
            FantasmaImgs0.put("ABAJO", LoadImages(resPath, "fantasma0_AB"));
            FantasmaImgs0.put("ARRIBA", LoadImages(resPath, "fantasma0_AR"));

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
    
    private static BufferedImage[] LoadImages(final String resPath, 
                                    final String preStr) {
        int i = 0;
        List<BufferedImage> imgs = new ArrayList<>();
        File currFile = new File(resPath, preStr + i + ".png");        
        try {
            while (currFile.exists()) {
                imgs.add(ImageIO.read(currFile));
                currFile = new File(resPath, preStr + (++i) + ".png");
            }
        } catch(IOException ex) {
            System.err.println("Error al cargar imagen");
        }
        
        return imgs.toArray(new BufferedImage[0]);
    }
    
    public static Map<String, BufferedImage[]> getPacman1Imgs() {
        return Pacman1Imgs;
    }
 
    public static Map<String, BufferedImage[]> getPacman2Imgs() {
        return Pacman2Imgs;
    }
    
    public static BufferedImage getMapImg(int level) {
        return MapImgs.get(level)[0];
    }
    
    public static BufferedImage getColiImg(int level) {
        return MapImgs.get(level)[1];
    }
    
    public static Map<String, BufferedImage[]> getFantasmasImg(int tipo) {
        if (tipo == 0)
            return FantasmaImgs0;
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
