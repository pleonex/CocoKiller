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
public class MovFantasma extends MovPersonaje {

    public MovFantasma() {
        super(Direccion.Aleatoria());
    }
    
    @Override
    protected Punto getSiguientePosicion() {
        this.cambiaDireccion(true);
        return this.getIncrementPosicion();
    }

    @Override
    protected void enCambio() {
        if ((int)Math.round(Math.random() * 4) < 2.0)
            this.cambiaDireccion(false);
    }
    
    private void cambiaDireccion(boolean bloqueante) {
        int intentos = 0;
        while (intentos < 4 || bloqueante) {
            Direccion dir = this.getDireccion().AleatoriaPerpendicular();
            if (this.testDireccion(dir)) {
                this.setDireccion(dir);
                return;
            } else {
                intentos++;
            }
        }        
    }
}
