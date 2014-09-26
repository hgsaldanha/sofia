/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.GameController;
import engine.itens.Item;
import engine.itens.PosicaoRender;

/**
 *
 * @author alunoruy
 */
public class Bola extends Item {
private int contarDefesas;

    public Bola(String img, PosicaoRender positions, int pos) {
        super("Bola.gif", positions, 4);
        setDeslocamento(1);
    }
    
   @Override
   public void animar(){
       this.deslocarReta(105, 1);
        if(GameController.getInstance().colisaoItem(Goleiro.class, this)){
            Item item = GameController.getInstance().getColisaoItem(Goleiro.class, this);
            this.setVisible(true);
            contarDefesas++;
           
              //A medida que o usuário realiza defesas, a velocidade da bola aumenta
        }
        else
        {
            
        }
   }
}
