/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.itens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author itakenami
 */
public class PosicaoRender {
    
    private int linhas;
    private int colunas;
    private int tamanho_item;
    List<Posicao> casas;
    
    public PosicaoRender(int linhas, int colunas, int tamanho){
        
        this.linhas = linhas;
        this.colunas = colunas;
        this.tamanho_item = tamanho;
        
        casas = new ArrayList<Posicao>();
        
        int pos_x=0;
        int pos_y=0;
        
        for(int x=0;x<linhas;x++){
            pos_x=0;
            for(int y=0;y<colunas;y++){
                casas.add(new Posicao(pos_x, pos_y));
                pos_x+=tamanho;
            }
            pos_y+=tamanho;
        }
        
    }
    
    public int getLinhas(){
        return linhas;
    }
    
    public int getColunas(){
        return colunas;
    }
    
    public Posicao getPosicao(int idx){
        return casas.get(idx-1);
    }
    
    public int getTotalCasas(){
        return casas.size();
    }
    
    
}
