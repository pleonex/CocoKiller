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

import controladores.Direccion;
import gui.Configuracion;

/**
 *
 */
public class PersonajeFactory {
    public static Pacman CreaPacman1(final Escenario escenario) {
        Pacman p = new Pacman(
                new Punto(5, 4),
                Direccion.DERECHA,
                3,
                Configuracion.getPacman1Imgs(),
                escenario,
                Configuracion.GetMando1()
        );
        escenario.addPacman(p);
        return p;
    }
    
    public static Pacman CreaPacman2(final Escenario escenario) {
        Pacman p = new Pacman(
                new Punto(204, 180),
                Direccion.ABAJO,
                3,
                Configuracion.getPacman2Imgs(),
                escenario,
                Configuracion.GetMando2()
        );
        escenario.addPacman(p);
        return p;
    }
    
    public static Fantasma CreaFantasma(final Escenario escenario, int tipo) {
        Fantasma f = new Fantasma(
                new Punto(68, 84),
                1,
                Configuracion.getFantasmasImg(tipo),
                escenario
        );
        escenario.addFantasma(f);
        return f;
    }
}
