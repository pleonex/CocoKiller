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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Personaje;
import modelos.Punto;

/**
 *
 */
public abstract class MovPersonaje implements ActionListener {
    private Personaje personaje;
    private Direccion direccion;
 
    public MovPersonaje(final Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void setPersonaje(final Personaje personaje) {
        this.personaje = personaje;
    }
    
    protected Personaje getPersonaje() {
        return this.personaje;
    }
    
    protected Direccion getDireccion() {
        return this.direccion;
    }
    
    protected void setDireccion(final Direccion direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Calcula el desplazamiento
        int dx = 0;
        int dy = 0;
        switch (this.getDireccion()) {
            case ABAJO: dx = 0; dy = 1; break;
            case ARRIBA: dx = 0; dy = -1; break;
            case DERECHA: dx = 1; dy = 0; break;
            case IZQUIERDA: dx = -1; dy = 0; break;
        }
        
        // A partir de este obtiene la siguiente posición.
        Punto sigPos = this.getPersonaje().getPosicion().offset(dx, dy);
        
        // Comprueba que el siguiente movimiento sea posible.
        boolean valida = this.personaje.getEscenario().isPosicionPermitida(
                sigPos,
                this.personaje.getCurrentImage().getWidth(),
                this.personaje.getCurrentImage().getHeight()
        );
        
        // Si el movimiento es inválido, pregunta por una posición buena.
        if (!valida)
            sigPos = this.getSiguientePosicion();
        
        // Muévete si puedes
        if (sigPos != null)
            this.getPersonaje().setPosicion(sigPos);
    }
    
    protected abstract Punto getSiguientePosicion();
}
