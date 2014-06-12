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

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import modelos.Escenario;
import modelos.Pacman;
import modelos.Punto;

/**
 *
 */
public class Contador extends javax.swing.JPanel {
    private static final Punto POSICION = new Punto(10, 20);
    private static final int SEPARACION = 20;
    private Escenario escenario;

    public Contador() {
        initComponents();
    }

    public void setEscenario(final Escenario escenario) {
        this.escenario = escenario;
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        
        if (this.escenario == null)
            return;
        
        int i = 0;
        for (Pacman p : this.escenario.getPacmans()) {
            String puntos = String.format("%04d", p.getPuntos());
            int y = POSICION.getY() + i * SEPARACION;
            
            g.setColor(Color.white);
            g.setFont(new Font("Courier New", Font.BOLD, 18));
            g.drawString("Jugador " + (i + 1) + ": " + puntos, POSICION.getX(), y);
            i++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(180, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
