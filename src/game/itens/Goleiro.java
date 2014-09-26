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
    public static String IMAGEM_COMEMORACAO ="IMAGEM_COMEMORACAO";
    private double qtdeBolas;

    
    public Goleiro(PosicaoRender positions) {
        super("goleiro.gif", positions, 106);
       this.addImagem(IMAGEM_GOLEIRO_DIREITA, "goleiro.gif");
       this.addImagem(IMAGEM_GOLEIRO_ESQUERDA, "goleiro.gif");
       this.addImagem(IMAGEM_GOLEIRO_PARADO, "parado.gif");
       this.addImagem(IMAGEM_COMEMORACAO, "comemoracao.gif");
    }
   
    public Goleiro(String imagem, PosicaoRender positions) {
        super(imagem, positions,106);
    }
    
    @Override
   public void animar()
   {
        //Verifica se houve colisão com a bola
            if(GameController.getInstance().colisaoItem(Bola.class, this)){
               Item bola = GameController.getInstance().getColisaoItem(Bola.class, this);
               bola.setVisible(true);
               this.addBolas(1);
              //A medida que o usuário realiza defesas, a velocidade da bola aumenta
               if (qtdeBolas > 7){
                   //Ganha partida
               }
               else{
                   
               }
            }
            else
            {
            //Verificar se foi bola dentro do gol
            }
            

            pausar(50);
   }
     
    public void addBolas(int p){
        qtdeBolas+=p;
    }
    
    public double getBolas(){
        return qtdeBolas;
    }
    
    public void diminuirPontos(int p){
        qtdeBolas-=p;
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
