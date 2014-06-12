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

package modelos;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 * Escenario del juego.
 */
public class Escenario {
    private final Bloque[][] colisiones;
    private final Image mapa;
    
    public Escenario(Image imgMapa, BufferedImage imgColi) {
        this.mapa = imgMapa;
        this.colisiones = LoadColisiones(imgColi);
    }
    
    private static Bloque[][] LoadColisiones(BufferedImage imgColi) {
        Bloque[][] colisiones = new Bloque[imgColi.getWidth()][imgColi.getHeight()];
        byte[] pixels = ((DataBufferByte)imgColi.getRaster().getDataBuffer()).getData();
        boolean hasAlpha = imgColi.getAlphaRaster() != null;
        int bpp = hasAlpha ? 4 : 3;   // bytes per pixel
        
        for (int x = 0; x < imgColi.getWidth(); x++) {
            for (int y = 0; y < imgColi.getHeight(); y++) {
                int index = (y * imgColi.getWidth() + x) * bpp;
                Color color = new Color(
                        pixels[index++] & 0xFF,
                        pixels[index++] & 0xFF,
                        pixels[index++] & 0xFF,
                        hasAlpha ? (pixels[index] & 0xFF) : 255
                );
                colisiones[x][y] = Bloque.FromColor(color);
            }
        }
        
        return colisiones;
    }
    
    public Image getMapa() {
        return this.mapa;
    }
    
    public boolean isPosicionPermitida(final Punto posicion, final int width,
            final int height) {
       
        boolean permitido = true; 
        for (int x = 0; x < width && permitido; x++)
            for (int y = 0; y < height && permitido; y++)
                if (this.colisiones[posicion.getX() + x][posicion.getY() + y] == Bloque.ESCENARIO)
                    permitido = false;
        
        return permitido;
    }
}
