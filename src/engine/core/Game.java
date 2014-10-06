package engine.core;

import engine.core.GameController;
import engine.renders.JPanelRender;
import java.awt.event.KeyEvent;

/**
 *
 * @author itakenami
 */
public class Game {
    
    public static int LARGURA_TELA;  //Largura da janela
    public static int ALTURA_TELA;   //Altura da janela
    
    private static JPanelRender render; 
    
    public static void setRender(JPanelRender tela) {
        render = tela; //Cria a janela para exibir o jogo
    }
    //Inicia o jogo
    public static void gameInit() {

        //Thread principal que controla o jogo
        Thread thread_jogo_principal = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!GameController.getInstance().fimjogo) { //enquanto o jogo não chega ao fim
                        render.repaint(); //repinta a tela com os Itens do Jogo (ItensJogo)
                        Thread.sleep(100); //Tempo de repintura das informações
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Erro na pintura da tela");
                }
            }
        });
        
        thread_jogo_principal.start();

    }

}
