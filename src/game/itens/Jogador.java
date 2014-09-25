/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.itens.Item;
import engine.itens.PosicaoRender;

/**
 *
 * @author elane
 */
public class Jogador extends Item{

    public Jogador(String img, PosicaoRender positions, int pos) {
        super(img, positions, pos);
    }
    
    @Override
    public void animar() {
        
            while (getY() < 600 && isVisible()) {//Enquanto estiver visivel e não ter chegado em baixo
                down();
                pausar(100);
            }
            
            setVisible(false); //Fim do inimigo
           // Jogo.getInstance().getInimigos().atualizaInimigo(-1); //Informa que existe 1 inimigo a menos
            
        
    }
}
