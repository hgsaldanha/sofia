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


/**
 *
 * @author alunoruy
 */
public class Jogador extends Item{
    private int DIRECAO;
    private final int INTERVALO = 100;
    
    public Jogador(PosicaoRender pr, int p) {
       super("goleiro.gif",pr,p);
        //addImagem("goleiro_esquerda", "goleiro_esqueda.gif");
        //addImagem("goleiro_direita", "goleiro_direita.gif");
        setDeslocamento(1);
        iniciarAnimacao();
    }

    @Override
    public void animar() {
        if(!GameController.getInstance().isFimJogo() || getY() < 600){ //Enquanto o jogo não chegou ao fim
            
            while (getY() < 600 && isVisible()) {//Enquanto estiver visivel e não ter chegado em baixo
                downInMapa(5,15);
                
                //pausar(1000);
            }
            
            setVisible(false); //Fim do inimigo
            
            Hexa.getInstance().getJogadores().atualizaContagem(-1); //1 jogador a menos
            
            //Verifica se houve colisão com o inimigo
            /*if(GameController.getInstance().colisaoItem(Inimigo.class, this)){
                GameController.getInstance().setFimJogo(true);//Informa o fim do jogo
                GameController.getInstance().addItem(new ImagemItem("game-over.jpg"));
                setVisible(false);//Apaga a nave
            }
            */

            //pausar(50);
        }
        
    }
    
    
}
