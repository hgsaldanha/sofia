/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.app;

import engine.core.Game;
import engine.core.GameController;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.itens.Posicao;
import engine.itens.PosicaoRender;
import engine.renders.WindowRender;
import game.controladores.Jogadores;
import game.itens.Goleiro;
import game.itens.Jogador;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author elane
 */
public class Hexa implements EventosDoTeclado,EventosDoRender{
    private static Hexa instance;
    private Goleiro goleiro;
    private Jogador jogador;
    public Collection<Posicao> posicao;
    public PosicaoRender mapa;
    private Jogadores jogadores;
    //private Bola bola;
    
    public Hexa() {
        
        Game.ALTURA_TELA = 800;
        Game.LARGURA_TELA = 750;
        
        mapa = new PosicaoRender(16, 15, 50);
        //ulima linha = 226 a 240
        jogadores = new Jogadores(mapa);
        
        //hulk = new Hulk(mapa,25);
        goleiro = new Goleiro(mapa);
    }
    
    public static Hexa getInstance() {
        if (instance == null)
            instance = new Hexa();
        return instance;
    }
    
    public void iniciar() {
        //hulk.iniciarAnimacao();
        goleiro.iniciarAnimacao();
        
        WindowRender window = new WindowRender(this, this);
        window.setVisible(true);
        Game.gameInit();
        
        Thread th_jogadores = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    while (!GameController.getInstance().fimjogo) {
                        int pos_inicial = new Random().nextInt(15);
                        if (pos_inicial < 5)
                            pos_inicial += 5;
                        getJogadores().novoJogador(pos_inicial);
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Erro ao criar jogador.");
                }
            }
        });
        
        th_jogadores.start();
        
    }

    public Jogadores getJogadores() {
        return jogadores;
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
