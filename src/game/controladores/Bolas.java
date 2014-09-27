/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controladores;

import engine.core.Game;
import java.util.Random;

/**
 *
 * @author elane
 */
public class Bolas {
    private int qtdeBolas;
    private boolean novaBola;
   
    
    public Bolas(){
    qtdeBolas =0;
    novaBola = true;
    }
    
    public synchronized void CriarBolaCenario(boolean sim){
       novaBola = sim;
    }
    
    //Informa uma qtd de inimigos a + ou -
    public synchronized void atualizaInimigo(int val) {
        
    }
}
