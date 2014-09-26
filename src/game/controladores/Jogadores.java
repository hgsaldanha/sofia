/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controladores;

import engine.itens.PosicaoRender;
import game.itens.Jogador;
import java.util.Random;

/**
 *
 * @author alunoruy
 */
public class Jogadores {
    private final int MAX_JOGADORES = 3;
    private int qtd_jogadores = 0;
    private PosicaoRender pr;
    
    public Jogadores(PosicaoRender pr) {
        this.pr = pr;
    }
    
    public synchronized void novoJogador() {
        if (qtd_jogadores < MAX_JOGADORES) {
            atualizaContagem(1);
            int pos_inicial = new Random().nextInt(15);
            if (pos_inicial < 5)
                pos_inicial += 5;
            new Jogador(pr, pos_inicial);
        }
        System.out.println(qtd_jogadores);
    }
    
    public synchronized void atualizaContagem(int i) {
        this.qtd_jogadores += i;
    }
    
}
