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
import modelos.Escenario;
import modelos.Personaje;
import modelos.Punto;

/**
 *
 */
public abstract class MovPersonaje implements ActionListener {
    private static final int INCR = 1;
    
    private Personaje personaje;
    private Direccion direccion;
 
    public MovPersonaje(final Direccion direccion) {
        this.direccion = direccion;
    }
    
    protected void setPersonaje(final Personaje personaje) {
        this.personaje = personaje;
    }
    
    protected Direccion getDireccion() {
        return this.direccion;
    }
    
    protected Escenario getEscenario() {
        return this.personaje.getEscenario();
    }
    
    protected void setDireccion(final Direccion direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Punto sigPos = this.getIncrementPosicion();
        
        // Comprueba que el siguiente movimiento sea posible.
        boolean valida = this.isPosicionValida(sigPos);
        
        // Si el movimiento es inválido, pregunta por una posición buena.
        if (!valida)
            sigPos = this.getSiguientePosicion();
                
        // Muévete si puedes
        if (sigPos != null)
            this.personaje.setPosicion(sigPos);
        
        // Avisa del cambio
        this.enCambio();
    }
    
    protected boolean testDireccion(final Direccion direccion) {
        Direccion oldDir = this.direccion;
        this.direccion   = direccion;
        boolean valida   = this.isPosicionValida(this.getIncrementPosicion());
        this.direccion   = oldDir;
        
        return valida;
    }
    
    protected boolean isPosicionValida(Punto pos) {
        // Comprueba que el siguiente movimiento sea posible.
        return this.personaje.getEscenario().isPosicionPermitida(
                pos,
                this.personaje.getCurrentImage().getWidth(),
                this.personaje.getCurrentImage().getHeight()
        );
    }
    
    protected Punto getIncrementPosicion() {
         // Calcula el desplazamiento
        int dx = 0;
        int dy = 0;
        switch (this.getDireccion()) {
            case ABAJO: dx = 0; dy = INCR; break;
            case ARRIBA: dx = 0; dy = -INCR; break;
            case DERECHA: dx = INCR; dy = 0; break;
            case IZQUIERDA: dx = -INCR; dy = 0; break;
        }
        
        // A partir de este obtiene la siguiente posición.
        return this.personaje.getPosicion().offset(dx, dy);       
    }
    
    protected abstract Punto getSiguientePosicion();
    
    protected abstract void enCambio();
}
