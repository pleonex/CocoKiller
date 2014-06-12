/*
 * Copyright (C) 2014 benito
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
import modelos.Punto;

/**
 *
 * @author benito
 */
public class FPSCounter extends javax.swing.JPanel {
    private static final Punto POSICION = new Punto(135, 10);
    private GamePanel gamePanel;
    

    public FPSCounter() {
        initComponents();
    }

    public void setGamePanel(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        
        if (this.gamePanel == null)
            return;
        
        int fps = this.gamePanel.getFPS();
                
        g.setColor(Color.white);
        g.setFont(new Font("Courier New", Font.BOLD, 10));
        g.drawString("FPS: " + String.format("%02d", fps), POSICION.getX(), POSICION.getY());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));

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
