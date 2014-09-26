/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.app;

import engine.core.Game;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.itens.PosicaoRender;
import engine.renders.WindowRender;
import game.itens.Goleiro;

/**
 *
 * @author elane
 */
public class Hexa implements EventosDoTeclado,EventosDoRender{
    private static Hexa instance;
    private Goleiro goleiro;
    public PosicaoRender mapa;
   
   
    private Hexa()
    {
        Game.ALTURA_TELA = 600;
        Game.LARGURA_TELA = 500;
        
        mapa = new PosicaoRender(12, 10, 50);
        goleiro = new Goleiro(mapa);
    }
    
     public void iniciar(){
        goleiro.iniciarAnimacao();
        WindowRender window = new WindowRender(this, this);
        window.setVisible(true);
        Game.gameInit();
    }
       
    public static Hexa getInstance(){
        if(instance==null){
            instance = new Hexa();
        }
        return instance;
    }
       
    @Override
    public void teclaPress(int keycode) {
        
    }

    @Override
    public void teclaDireita() {
        goleiro.direita();
    }

    @Override
    public void teclaEsquerda() {
        goleiro.esquerda();
    }

    @Override
    public void teclaCima() {
        goleiro.cima();
    }

    @Override
    public void teclaBaixo() {
        goleiro.baixo();
    }

    @Override
    public void teclaEspaco() {
        
    }

    @Override
    public void antesPintar() {
        
    }

    @Override
    public void depoisPintar() {
        
    }
    
}
