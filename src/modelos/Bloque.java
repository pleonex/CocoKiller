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

/**
 *
 */
public enum Bloque {
    VACIO,
    COM_GRANDE,
    COM_PEQUE,
    ESCENARIO,
    PUERTA,
    PORTAL;
    
    public static Bloque FromColor(final Color color) {
        switch (color.getRGB()) {
            case 0xFFFF0000: return ESCENARIO;
            case 0xFF000000: return VACIO;
            case 0xFFFFFFFF: return COM_PEQUE;
            case 0xFF0000FF: return COM_GRANDE;
            case 0xFF00FF00: return PUERTA;
            case 0xFFFFFF00: return PORTAL;
        }
        
        return null;
    }
}
