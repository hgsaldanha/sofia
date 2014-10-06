/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.renders;

import engine.core.Game;
import engine.eventos.EventosDoTeclado;
import engine.eventos.EventosDoRender;
import javax.swing.JFrame;

/**
 *
 * @author itakenami
 */
public class WindowRender extends JFrame{
    
    public WindowRender(EventosDoTeclado evt, EventosDoRender imgevt){
        
        JPanelRender jPanel1 = new JPanelRender(this, evt, imgevt);
        
        Game.setRender(jPanel1);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.layout.GroupLayout gamePanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(
                gamePanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(0, Game.LARGURA_TELA, Short.MAX_VALUE));
        gamePanel1Layout.setVerticalGroup(
                gamePanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(0, Game.ALTURA_TELA, Short.MAX_VALUE));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }
    
}
