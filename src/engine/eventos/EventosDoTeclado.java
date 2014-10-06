/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.eventos;

/**
 *
 * @author itakenami
 */
public interface EventosDoTeclado {
    
    public void teclaPress(int keycode);
    public void teclaDireita();
    public void teclaEsquerda();
    public void teclaCima();
    public void teclaBaixo();
    public void teclaEspaco();
    public void antesPintar();
    public void depoisPintar();
}
