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
    public Bola(PosicaoRender pr, int p) {
        super("bola.gif",pr, p);
        
        setDeslocamento(1);
        iniciarAnimacao();
    }
    
    @Override
    public void animar() {
        while(posicao_atual < 226){ //Enquanto o jogo não chegou ao fim
            System.out.println(posicao_atual);
        }
        setVisible(false);
            
            //Hexa.getInstance().getJogadores().atualizaContagem(-1); //1 jogador a menos
            
            //Verifica se houve colisão com o inimigo
            /*if(GameController.getInstance().colisaoItem(Inimigo.class, this)){
                GameController.getInstance().setFimJogo(true);//Informa o fim do jogo
                GameController.getInstance().addItem(new ImagemItem("game-over.jpg"));
                setVisible(false);//Apaga a nave
            }
            

            //pausar(50);
        }*/
        
    }
}
