/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.itens.Item;

/**
 *
 * @author alunoruy
 */
public class Goleiro extends Item {
    public Goleiro() {
        super("goleiro.gif", 300, 300);
        addImagem("goleiro_esquerda", "goleiro_esqueda.gif");
        addImagem("goleiro_direita", "goleiro_direita.gif");
    }
}
