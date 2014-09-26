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
import game.itens.Hulk;
import game.itens.Jogador;
import java.util.Collection;

/**
 *
 * @author alunoruy
 */
public class Hexa implements EventosDoTeclado, EventosDoRender {

    public static final int MAX_PLAYERS = 4;
    private static Hexa instance;
    private Hulk hulk;
    private Goleiro goleiro;
    private Jogador jogador;
    public Collection<Posicao> posicao;
    public PosicaoRender mapa;
    private Jogadores jogadores;
    
    public Hexa() {
        
        Game.ALTURA_TELA = 800;
        Game.LARGURA_TELA = 1400;
        
        mapa = new PosicaoRender(20, 20, 50);
        
        jogadores = new Jogadores(mapa);
        
        //hulk = new Hulk(mapa,25);
        //goleiro = new Goleiro(mapa,26);
    }
    
    public static Hexa getInstance() {
        if (instance == null)
            instance = new Hexa();
        return instance;
    }
    
    public void iniciar() {
        //hulk.iniciarAnimacao();
        //goleiro.iniciarAnimacao();
        
        WindowRender window = new WindowRender(this, this);
        window.setVisible(true);
        
        Game.gameInit();
        
        Thread th_jogadores = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!GameController.getInstance().fimjogo) {
                        getJogadores().novoJogador();
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
        goleiro.toRight();
    }

    @Override
    public void teclaEsquerda() {
        goleiro.toLeft();
    }

    @Override
    public void teclaCima() {
        
    }

    @Override
    public void teclaBaixo() {
        
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
