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

import controladores.MovFantasma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 *
 */
public class Fantasma extends Personaje {
    private final MovFantasma movFantasma;
    private final EfectoBasico efectoTick;
    
    public Fantasma(final Punto posIni, final int vidas,
            final BufferedImage[] imgs, final Escenario escenario) {
        super(new MovFantasma(), vidas, posIni, imgs[0], escenario);
        
        this.movFantasma = (MovFantasma)this.getMovimiento();
        this.movFantasma.setFantasma(this);
        
        this.efectoTick = new EfectoBasico(imgs) {
            @Override
            public void actionPerformed(ActionEvent e) {
                super.actionPerformed(e);
                setCurrentImage(this.getCurrentImage());
            }
        };
    }

    @Override
    public ActionListener getEfectoTick() {
        return this.efectoTick;
    }
}
