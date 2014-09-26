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
 * @author alunoruy
 */
public class Bola extends Item {

    public Bola(String img, PosicaoRender positions, int pos) {
        super("Bola.gif", positions, 4);
    }
    
   @Override
   public void animar(){
       this.deslocarReta(105, 0);
   }
}
