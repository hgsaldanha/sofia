/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.Game;
import engine.itens.Item;
import game.app.Hexa;
import java.util.Random;

/**
 *
 * @author alunoruy
 */
public class Bola extends Item {
    private Jogador jogador;

    private Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    public Bola(int x, int y) {
        super("bola.gif", x, y);
        setDeslocamento(1);
    }
    
    @Override
    public void animar() {
        moverPara(new Random().nextInt(Game.LARGURA_TELA), Game.ALTURA_TELA, Hexa.getInstance().getVelocidadeBola());
        while(getY() < Game.ALTURA_TELA){
            pausar(100);
        }
        getJogador().setVisible(false);
        setVisible(false);

        Hexa.getInstance().getJogadores().atualizaContagem(-1); //1 jogador a menos
    }
   
}
