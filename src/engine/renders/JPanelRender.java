/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.renders;

import engine.core.GameController;
import engine.itens.Item;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.itens.Item;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author itakenami
 */
public class JPanelRender extends JPanel {
    
    private EventosDoRender imgEvt;
    private EventosDoTeclado evt;
    private JFrame window;
    
    public JPanelRender(JFrame window, final EventosDoTeclado evt, EventosDoRender imgevt){
        
        this.window = window;
        this.imgEvt = imgevt;
        this.evt = evt;
        
        window.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                evt.teclaEsquerda();
            } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                evt.teclaDireita();
            } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                evt.teclaCima();
            } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                evt.teclaBaixo();
            } else if (key == KeyEvent.VK_SPACE) {
                evt.teclaEspaco();
            } else {
                evt.teclaPress(key);
            }
            }
        });
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        pintar(g); 
    }
    
    //Pinta os objetos na tela. Este método é chamado pela thread principal do Jogo
    private synchronized void pintar(Graphics g) {

        //Neste momento é necessário impedir a criação de inimigos
        //Jogo.getInstance().getInimigos().criaInimigo(false);
        evt.antesPintar();

        //Apaga itens que não estão visíveis
        GameController.getInstance().delItens();

        //Imprime os itens na tela
        for (Item graficos : GameController.getInstance().getItens()) {
            g.drawImage(graficos.getImagem().getImage(), graficos.getX(), graficos.getY(), this);
        }
        
        //Volta a permitir a criação de inimigos
        //Jogo.getInstance().getInimigos().criaInimigo(true);
        evt.depoisPintar();

    }
    
}
