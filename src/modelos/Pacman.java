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
import controladores.Mando;
import controladores.MovPacman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 *
 */
public class Pacman extends Personaje {
    private final EfectoBasico efectoTick;
    private final MovPacman movPacman;
    private int puntos;
        
    public Pacman(final Punto posIni, final Direccion direccion, final int vidas,
            final Map<String, BufferedImage[]> imgs, final Escenario escenario, final Mando mando) {
        super(new MovPacman(direccion, mando), vidas, posIni, imgs.get("DERECHA")[1], escenario);
        
        this.movPacman = (MovPacman)this.getMovimiento();
        this.movPacman.setPacman(this);
        this.puntos = 0;
        
        this.efectoTick = new Personaje.EfectoBasico(imgs) {
            @Override
            public void actionPerformed(ActionEvent e) {
                super.actionPerformed(e);
            }
        };
    }

    @Override
    public ActionListener getEfectoTick() {
        return this.efectoTick;
    }
    
    public int getPuntos() {
        return this.puntos;
    }
    
    public void incrementPuntos(final int incr) {
        this.puntos += incr;
    }

}
