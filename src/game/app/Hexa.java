/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.app;

import engine.core.Game;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.renders.WindowRender;
import game.info.Posicao;
import game.itens.Goleiro;
import game.itens.Hulk;
import java.util.ArrayList;
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
    public Collection<Posicao> posicao;
    
    public Hexa() {
        Game.ALTURA_TELA = 630;
        Game.LARGURA_TELA = 618;
        
        posicao = new ArrayList<>();
        posicao.add(new Posicao(100, 100));
        posicao.add(new Posicao(120, 100));
        posicao.add(new Posicao(130, 100));
        posicao.add(new Posicao(140, 100));
        posicao.add(new Posicao(150, 100));
        
        
        hulk = new Hulk();
        goleiro = new Goleiro();
    }
    
    public static Hexa getInstance() {
        if (instance == null)
            instance = new Hexa();
        return instance;
    }
    
    public void iniciar() {
        hulk.iniciarAnimacao();
        goleiro.iniciarAnimacao();
        
        WindowRender window = new WindowRender(this, this);
        window.setVisible(true);
        
        Game.gameInit();
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
