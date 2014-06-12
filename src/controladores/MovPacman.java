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

package controladores;

import java.awt.event.KeyEvent;
import modelos.Bloque;
import modelos.Punto;

/**
 *
 */
public class MovPacman extends MovPersonaje {
    private static final int MAX_INTENTOS = 15;
    private int intentos = -1;
    private Direccion futuraDireccion;
    
    private static final int PUNTOS_COMIDA_PEQUE = 10;
    private static final int PUNTOS_COMIDA_GRANDE = 100;
    
    public MovPacman(final Direccion direccion) {
        super(direccion);
    }
    
    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT: this.futuraDireccion = Direccion.IZQUIERDA; break;
            case KeyEvent.VK_RIGHT: this.futuraDireccion = Direccion.DERECHA; break;
            case KeyEvent.VK_UP: this.futuraDireccion = Direccion.ARRIBA; break;
            case KeyEvent.VK_DOWN: this.futuraDireccion = Direccion.ABAJO; break;
        }
        
        this.intentos = 0;
    }
    
    @Override
    protected Punto getSiguientePosicion() {
        return null;
    }
    
    @Override
    protected void enCambio() {
        this.checkCambioDireccion();
        
        for (int x = 0; x < this.getPersonaje().getCurrentImage().getWidth(); x++) {
            for (int y = 0; y < this.getPersonaje().getCurrentImage().getHeight(); y++) {
                this.checkComida(this.getPersonaje().getPosicion().offset(x, y));
            }
        }
    }
    
    private void checkCambioDireccion() {
         if (intentos == -1 || intentos >= MAX_INTENTOS) {
            intentos = -1;
            return;
        }
        
        if (this.testDireccion(futuraDireccion)) {
            this.setDireccion(futuraDireccion);
            intentos = -1;
        } else {
            intentos++;
        }       
    }
    
    private void checkComida(final Punto pos) {
        Bloque bloque = this.getEscenario().getBloque(pos.getX(), pos.getY());
        switch (bloque) {
            case COM_PEQUE:
                this.getPersonaje().incrementPuntos(PUNTOS_COMIDA_PEQUE);
                this.getEscenario().clearBloque(pos.getX(), pos.getY());
                break;
                
            case COM_GRANDE:
                this.getPersonaje().incrementPuntos(PUNTOS_COMIDA_GRANDE);
                this.getEscenario().clearBloque(pos.getX(), pos.getY());
                break;
        }
    }
}
