/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.GameController;
import engine.itens.Item;
import engine.itens.PosicaoRender;
import game.app.Hexa;
import java.util.Random;


/**
 *
 * @author alunoruy
 */
public class Jogador extends Item{
    private int DIRECAO;
    private final int INTERVALO = 100;
    PosicaoRender pr;
    
    public Jogador(PosicaoRender pr, int p) {
       super("goleiro.gif",pr,p);
        //addImagem("goleiro_esquerda", "goleiro_esqueda.gif");
        //addImagem("goleiro_direita", "goleiro_direita.gif");
       this.pr = pr;
       setDeslocamento(1);
       iniciarAnimacao();
    }

    @Override
    public void animar() {
        if(!GameController.getInstance().isFimJogo() || getY() < 600){ //Enquanto o jogo não chegou ao fim
            
            while (getY() < 350 && isVisible()) {//Enquanto estiver visivel e não ter chegado em baixo
                downInMapa(1,15);
            }
            
            chutar(new Bola(pr,posicao_atual+15));
            pausar(3000);
            
            setVisible(false); //Fim do inimigo
            
            Hexa.getInstance().getJogadores().atualizaContagem(-1); //1 jogador a menos
        }
    }
    
    public void chutar(Bola b) {
        int direcao = new Random().nextInt(15)+226;
        b.deslocarReta(direcao, 10);
    }
}
