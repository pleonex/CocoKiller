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
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.List;

/**
 * Escenario del juego.
 */
public class Escenario {
    private final Bloque[][] colisiones;
    private final BufferedImage mapa;
    
    private int foodBalls;
    private Pacman pacman;
    private final List<Personaje> fantasmas;
    
    public Escenario(BufferedImage imgMapa, BufferedImage imgColi) {
        this.mapa = imgMapa;
        this.colisiones = new Bloque[imgColi.getWidth()][imgColi.getHeight()];
        loadColisiones(imgColi);
        this.fantasmas = new ArrayList<>();
    }
    
    private void loadColisiones(BufferedImage imgColi) {
        byte[] pixels = ((DataBufferByte)imgColi.getRaster().getDataBuffer()).getData();
        boolean hasAlpha = imgColi.getAlphaRaster() != null;
        int bpp = hasAlpha ? 4 : 3;   // bytes per pixel
        
        for (int x = 0; x < imgColi.getWidth(); x++) {
            for (int y = 0; y < imgColi.getHeight(); y++) {
                int index = (y * imgColi.getWidth() + x) * bpp;
                index += hasAlpha ? 1 : 0;
                Color color = new Color(
                        pixels[index + 2] & 0xFF,
                        pixels[index + 1] & 0xFF,
                        pixels[index + 0] & 0xFF,
                        hasAlpha ? (pixels[index - 1] & 0xFF) : 255
                );
                this.colisiones[x][y] = Bloque.FromColor(color);
                if (this.colisiones[x][y] == Bloque.COM_PEQUE ||
                    this.colisiones[x][y] == Bloque.COM_GRANDE)
                        this.foodBalls++;
            }
        }
    }
    
    public BufferedImage getMapa() {
        return this.mapa;
    }
    
    public int getWidth() {
        return this.mapa.getWidth();
    }
    
    public int getHeight() {
        return this.mapa.getHeight();
    }
    
    public Bloque getBloque(final int x, final int y) {
        return this.colisiones[x][y];
    }
    
    public Pacman getPacman() {
        return this.pacman;
    }
    
    public void setPacman(final Pacman pacman) {
        this.pacman = pacman;
    }
    
    public void addFantasma(final Personaje fantasma) {
        this.fantasmas.add(fantasma);
    }
    
    public Personaje[] getFantasmas() {
        return this.fantasmas.toArray(new Personaje[0]);
    }
    
    public void clearBloque(final int x, final int y) {
        if (this.colisiones[x][y] == Bloque.COM_GRANDE ||
            this.colisiones[x][y] == Bloque.COM_PEQUE)
                this.foodBalls--;
        
        this.colisiones[x][y] = Bloque.VACIO;
        
        if (foodBalls == 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡GANASTE!");
        }
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
