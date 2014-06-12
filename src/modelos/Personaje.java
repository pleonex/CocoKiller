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

import controladores.MovPersonaje;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Representa a un personaje en el juego.
 */
public abstract class Personaje {
    private final MovPersonaje movPer;
    
    private final Escenario escenario;
    
    private BufferedImage currImg;
    
    private BufferedImage defaultImg;
    
    private int vidas;
    
    private Punto posicion;    
    
    public Personaje(final MovPersonaje movPer, final int numVidas,
            final Punto posIni, final BufferedImage defaultImg, final Escenario escenario) {
        this.movPer  = movPer;
        this.vidas   = numVidas;
        this.posicion  = posIni;
        this.escenario = escenario;
        this.defaultImg = defaultImg;
        this.currImg = defaultImg;
    }
    
    public int getVidas() {
        return this.vidas;
    }
    
    public void setVidas(final int vidas) {
        this.vidas = vidas;
    }
    
    public Punto getPosicion() {
        return this.posicion;
    }
    
    public void setPosicion(final Punto pos) {
        this.posicion = pos;
    }
    
    public Rectangle getRectangle() {
        return new Rectangle(
                this.posicion.getX(),
                this.posicion.getY(),
                this.currImg.getWidth(),
                this.currImg.getHeight()
        );
    }
    
    public int getWidth() {
        return this.defaultImg.getWidth();
    }
    
    public int getHeight() {
        return this.defaultImg.getHeight();
    }
    
    public BufferedImage getDefaultImage() {
        return this.defaultImg;
    }
    
    public BufferedImage getCurrentImage() {
        return this.currImg;
    }
    
    protected void setCurrentImage(final BufferedImage img) {
        this.currImg = img;
    }
    
    public Escenario getEscenario() {
        return this.escenario;
    }
    
    public MovPersonaje getMovimiento() {
        return this.movPer;
    }
    
    public abstract ActionListener getEfectoTick();
}
