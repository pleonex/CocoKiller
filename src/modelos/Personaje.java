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
import javax.swing.Timer;

/**
 * Representa a un personaje en el juego.
 */
public class Personaje {
    private final static int ANI_PERIOD = 140;
    
    private final Timer tmrAni;
    
    private final Timer tmrMov;
    
    private final MovPersonaje movPer;
    
    private final Escenario escenario;
    
    private BufferedImage currImg;
    
    private int vidas;
    
    private Punto posicion;    
    
    public Personaje(final MovPersonaje movPer, final int veloc,
            final int numVidas, final Punto posIni, final BufferedImage[] imgs,
            final Escenario escenario) {
        this.movPer  = movPer;
        this.tmrMov  = new Timer(veloc, movPer);
        this.tmrAni  = new Timer(ANI_PERIOD, new AnimacionTask(imgs));
        this.currImg = imgs[0];
        this.vidas   = numVidas;
        this.posicion  = posIni;
        this.escenario = escenario;
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
    
    public BufferedImage getCurrentImage() {
        return this.currImg;
    }
    
    private void setCurrentImage(final BufferedImage img) {
        this.currImg = img;
    }
    
    public Escenario getEscenario() {
        return this.escenario;
    }
    
    public MovPersonaje getMovimiento() {
        return this.movPer;
    }
    
    public void start() {
        this.tmrAni.start();
        this.tmrMov.start();
    }
    
    public void stop() {
        this.tmrAni.stop();
        this.tmrMov.stop();
    }
    
    private class AnimacionTask implements ActionListener {
        private final BufferedImage[] images;
        private int idx;
        
        public AnimacionTask(final BufferedImage[] images) {
            this.images = images;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            setCurrentImage(this.images[this.idx++]);
            if (this.idx >= this.images.length)
                this.idx = 0;
        }
    }
}
