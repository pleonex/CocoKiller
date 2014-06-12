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

import modelos.Punto;

/**
 *
 */
public class MovPacman extends MovPersonaje {
    public MovPacman(final Direccion direccion) {
        this.setDireccion(direccion);
    }
    
    @Override
    protected void mueve() {
        int dx = 0;
        int dy = 0;
        switch (this.getDireccion()) {
            case ABAJO: dx = 0; dy = 1; break;
            case ARRIBA: dx = 0; dy = -1; break;
            case DERECHA: dx = 1; dy = 0; break;
            case IZQUIERDA: dx = -1; dy = 0; break;
        }
        
        Punto sigPos = this.getPersonaje().getPosicion().offset(dx, dy);
        // TODO: Comprueba que el siguiente movimiento sea posible
        
        // Muévete
        this.getPersonaje().setPosicion(sigPos);
    }
}