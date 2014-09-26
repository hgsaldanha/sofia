/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.itens.Item;
import engine.itens.PosicaoRender;


/**
 *
 * @author alunoruy
 */
public class Goleiro extends Item{

    public static String IMAGEM_GOLEIRO_DIREITA ="IMAGEM_GOLEIRO_DIREITA";
    public static String IMAGEM_GOLEIRO_ESQUERDA ="IMAGEM_GOLEIRO_ESQUERDAf";
    public static String IMAGEM_GOLEIRO_PARADO ="IMAGEM_GOLEIRO_PARADO";
    
    public Goleiro(PosicaoRender positions) {
        super("goleiro.gif", positions, 5);
       this.addImagem(IMAGEM_GOLEIRO_DIREITA, "goleiro.gif");
       this.addImagem(IMAGEM_GOLEIRO_ESQUERDA, "goleiro.gif");
       this.addImagem(IMAGEM_GOLEIRO_PARADO, "hulk.gif");
    }
   
    public Goleiro(String imagem, PosicaoRender positions) {
        super(imagem, positions, 4);
    }
    
    public void direita(){
        this.changeImagem(IMAGEM_GOLEIRO_DIREITA);
        rightInMapa(1);
    }
    
    public void esquerda(){
        this.changeImagem(IMAGEM_GOLEIRO_ESQUERDA);
        leftInMapa(1);
    }   
    
    public void cima() {
       this.changeImagem(IMAGEM_GOLEIRO_PARADO);
        upInMapa(1);
    }
    
    public void baixo() {
        this.changeImagem(IMAGEM_GOLEIRO_PARADO);
        downInMapa(1);
    }
}
