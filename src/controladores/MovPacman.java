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
import modelos.Punto;

/**
 *
 */
public class MovPacman extends MovPersonaje {
    private static final int MAX_INTENTOS = 15;
    private int intentos = -1;
    private Direccion futuraDireccion;
    
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
    protected void enCambio(final Punto pos) {
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
}
