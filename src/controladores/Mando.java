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

/**
 *
 */
public class Mando {
    private final int izquierda;
    private final int derecha;
    private final int arriba;
    private final int abajo;
    private final int disparar;

    public Mando(int izquierda, int derecha, int arriba, int abajo, int disparar) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.arriba = arriba;
        this.abajo = abajo;
        this.disparar = disparar;
    }
    
    public int getIzquierda() {
        return izquierda;
    }

    public int getDerecha() {
        return derecha;
    }

    public int getArriba() {
        return arriba;
    }

    public int getAbajo() {
        return abajo;
    }

    public int getDisparar() {
        return disparar;
    }
    
    
}
