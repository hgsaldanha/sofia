/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controladores;

import game.itens.Jogador;

/**
 *
 * @author alunoruy
 */
public class Jogadores {
    private final int MAX_JOGADORES = 3;
    private int qtd_jogadores = 0;
    
    public synchronized void novoJogador(int x) {
        if (qtd_jogadores <= MAX_JOGADORES) {
            atualizaContagem(1);
            //new Jogador(pr, pos_inicial);
            new Jogador(x, -50);
        }
    }
    
    public synchronized void atualizaContagem(int i) {
        this.qtd_jogadores += i;
    }
    
}
