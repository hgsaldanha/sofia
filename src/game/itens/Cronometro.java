/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.GameController;
import javax.swing.JLabel;

/**
 *
 * @author alunoruy
 */
public class Cronometro extends JLabel implements Runnable{
         
             String tempo = "";                         
             String minutos = "";
             
             public Cronometro(){
                 run();
             }
      
             
    @Override
    public void run() {
         try {        
             int segundos = 0;
             int minutos = 0;
             String strminutos = "";
             String strsegundos = "";
             
             while (!GameController.getInstance().fimjogo) {
                 
                 
                 if(segundos < 10)
                 {
                     strsegundos = "0"+segundos;
                 }
                 else
                 {
                     strsegundos = ""+segundos;
                 }
                 
                 
                  if(minutos < 10)
                 {
                     strminutos = "0"+minutos;
                 }
                 else
                 {
                     strminutos = ""+minutos;
                 }
                 
                 
                 tempo = strminutos +":"+strsegundos;
               //  System.out.println(tempo);
                 this.setText(tempo);
                        Thread.sleep(1000);
                        
                        if(segundos == 59){
                     minutos = minutos + 1;
                     segundos = -1;
                      }                    
                 segundos = segundos + 1;
                 
                
                    }
             
    
            }  catch(Exception e){
                e.getStackTrace();
            }
             
             
                        
    }
    
}
