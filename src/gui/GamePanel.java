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

import controladores.MovPacman;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import modelos.Escenario;
import modelos.Personaje;
import modelos.PersonajeFactory;

/**
 * Contenedor del juego.
 */
public class GamePanel extends javax.swing.JPanel {
    private long fpsTime;
    private int fps;
    private int fpsCounter;
    
    private final Escenario escenario;
    private final Personaje pacman;
    
    public GamePanel() {
        initComponents();
        
        this.escenario = new Escenario(Configuracion.getMapImg(0), Configuracion.getColiImg(0));
        
        this.pacman = PersonajeFactory.CreaPacman1(this.escenario);
        this.pacman.start();
        
        // 60 fps
        new Timer(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }).start();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        // Borra todo y pinta el fondo
        super.paintComponent(g);
        
        // Dibuja el mapa
        g.drawImage(this.escenario.getMapa(), 0, 0, this);
        
        // Dibuja a Pacman
        g.drawImage(
                this.pacman.getCurrentImage(),
                this.pacman.getPosicion().getX(),
                this.pacman.getPosicion().getY(),
                this
        );
        
        // Pintamos los FPS en la esquina
        g.setColor(Color.white);
        g.drawString("FPS: " + this.fps, 250, 100);
        this.fpsCounter++;
        if (System.nanoTime() - this.fpsTime > 1e9) {
            this.fps = this.fpsCounter;
            this.fpsCounter = 0;
            this.fpsTime = System.nanoTime();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

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

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (this.pacman.getMovimiento() instanceof MovPacman)
            ((MovPacman)this.pacman.getMovimiento()).keyPressed(evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.requestFocus();
    }//GEN-LAST:event_formMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
