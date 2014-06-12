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
import controladores.MovFantasma;
import controladores.MovPacman;
import gui.Configuracion;

/**
 *
 */
public class PersonajeFactory {
    public static Personaje CreaPacman1(final Escenario escenario) {
        return new Personaje(
                new MovPacman(Direccion.DERECHA),
                20,
                3,
                new Punto(5, 4),
                Configuracion.getPacmanImgs(),
                escenario
        );
    }
    
    public static Personaje CreaFantasma(final Escenario escenario, int tipo) {
        return new Personaje(
                new MovFantasma(),
                21,
                1,
                new Punto(68, 84),
                Configuracion.getPacmanImgs(),
                escenario
        );
    }
}
