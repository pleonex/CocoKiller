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
public enum Direccion {
    ARRIBA,
    ABAJO,
    DERECHA,
    IZQUIERDA;
    
    public static Direccion Aleatoria() {
        switch ((int)Math.round(Math.random() * 3)) {
            case 0: return ARRIBA;
            case 1: return ABAJO;
            case 2: return DERECHA;
            case 3: return IZQUIERDA;
        }
        
        return null;
    }
    
    public Direccion AleatoriaPerpendicular() {
        switch ((int)Math.round(Math.random() * 1)) {
            case 0:
                if (this == ARRIBA || this == ABAJO)
                    return DERECHA;
                else
                    return ARRIBA;
            case 1:
                if (this == ARRIBA || this == ABAJO)
                    return IZQUIERDA;
                else
                    return ABAJO;
        }
        
        return null;
    }
}
