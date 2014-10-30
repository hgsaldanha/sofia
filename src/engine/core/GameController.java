package engine.core;

import engine.itens.Item;
import engine.itens.Obstaculo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author itakenami
 */
public class GameController {

    //instancia do singleton
    private static GameController instance;
    
    //Itens que serão pitados na tela
    private List<Item> animacoes;
    
    public boolean fimjogo; //Define o fim do jogo

    private GameController() {
        //Precisa ser Vector por causa dos metodo sincronizados
        animacoes = new ArrayList<Item>();
        fimjogo = false; //Define que o jogo está iniciando
    }
    
    //Metodo do singleton
    public synchronized static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    
    //verifica se o jogo chegou ao fim
    public boolean isFimJogo() {
        return fimjogo;
    }
    
    public void setFimJogo(boolean val){
        fimjogo = val;
    }

    //Adiciona um item 
    public synchronized void addItem(Item a) {
        animacoes.add(a);
    }
    
    public synchronized void iniciarAnimacoes(){
        for (Item graficos : getItens()) {
            graficos.iniciarAnimacao();
        }
        
    }

    //Retira os itens invisiveis
    public synchronized void delItens() {
        Collection<Item> i = new ArrayList<Item>();
        for (Item graficos : getItens()) {
            if (!graficos.isVisible()) {
                i.add(graficos);
            }
        }
        animacoes.removeAll(i);
    }

    //Retirna os itens que serão exibidos na tela
    public synchronized List<Item> getItens() {
        return animacoes;
    }

    //Agoritmo de colisão
    private boolean colisao(Item obj1, Item obj2) {
        
        int obj1X = obj1.getX();
        int obj1Y = obj1.getY();
        int obj1W = obj1.getWidth();
        int obj1H = obj1.getHeight();
        int obj2X = obj2.getX();
        int obj2Y = obj2.getY();
        int obj2W = obj2.getWidth();
        int obj2H = obj2.getHeight();
        
//        if ((obj1X >= obj2X && obj1X <= obj2X + obj2W)
//                && (obj1Y >= obj2Y && obj1Y <= obj2Y + obj2H)) {
//            return true;
//        } else if ((obj1X + obj1W >= obj2X && obj1X + obj1W <= obj2X + obj2W)
//                && (obj1Y >= obj2Y && obj1Y <= obj2Y + obj2H)) {
//            return true;
//        } else if ((obj1X >= obj2X && obj1X <= obj2X + obj2W)
//                && (obj1Y + obj1H >= obj2Y && obj1Y + obj1H <= obj2Y + obj2H)) {
//            return true;
//        } else if ((obj1X + obj1W >= obj2X && obj1X + obj1W <= obj2X + obj2W)
//                && (obj1Y + obj1H >= obj2Y && obj1Y + obj1H <= obj2Y + obj2H)) {
//            return true;
//        } else {
//            return false;
//        }
        
        if ((obj1X >= obj2X && obj1X <= obj2X + obj2W)
                && (obj1Y >= obj2Y && obj1Y <= obj2Y + obj2H)) {
            return true;
        } else if ((obj1X + obj1W >= obj2X && obj1X + obj1W <= obj2X + obj2W)
                && (obj1Y >= obj2Y && obj1Y <= obj2Y + obj2H)) {
            return true;
        } else if ((obj1X >= obj2X && obj1X <= obj2X + obj2W)
                && (obj1Y + obj1H >= obj2Y && obj1Y + obj1H <= obj2Y + obj2H)) {
            return true;
        } else if ((obj1X + obj1W >= obj2X && obj1X + obj1W <= obj2X + obj2W)
                && (obj1Y + obj1H >= obj2Y && obj1Y + obj1H <= obj2Y + obj2H)) {
            return true;
        } else if ((obj2X >= obj1X && obj2X <= obj1X + obj1W)
                && (obj2Y >= obj1Y && obj2Y <= obj1Y + obj1H)) {
            return true;
        } else if ((obj2X + obj2W >= obj1X && obj2X + obj2W <= obj1X + obj1W)
                && (obj2Y >= obj1Y && obj2Y <= obj1Y + obj1H)) {
            return true;
        } else if ((obj2X >= obj1X && obj2X <= obj1X + obj1W)
                && (obj2Y + obj2H >= obj1Y && obj2Y + obj2H <= obj1Y + obj1H)) {
            return true;
        } else if ((obj2X + obj2W >= obj1X && obj2X + obj2W <= obj1X + obj1W)
                && (obj2Y + obj2H >= obj1Y && obj2Y + obj2H <= obj1Y + obj1H)) {
            return true;
        }
        return false;
        
    }
    
    public synchronized boolean colisaoItem(Class<?> c, Item i) {

        for (Item item : getItens()) {
            
            if (item.getClass()==c) { //Se o item for um inimigo
                //if ((i.getX() >= inimigo.getX()) && (i.getX() < inimigo.getX() + inimigo.getWidth())
                  //      && (i.getY() >= inimigo.getY() - inimigo.getHeight()) && (i.getY() < inimigo.getY())) {
                if(colisao(i, item)){ //Testa se houve colisão
                    //item.setVisible(false); //Se tiver colisão torna o inimigo invisivel
                    return true;
                }
            }
        }
        return false;
    }
    
    //Verifica a colisão com o inimigo
    public synchronized Item getColisaoItem(Item i) {

        for (Item item : getItens()) {
            if (item instanceof Obstaculo) { //Se o item for um inimigo
                if(colisao(i, item)){ //Testa se houve colisão
                    return item;
                }
            }
        }
        return null;
    }

    //Verifica a colisão com o inimigo
    public synchronized Item getColisaoItem(Class<?> c, Item i) {

        for (Item item : getItens()) {
            if (item.getClass()==c) { //Se o item for um inimigo
                if(colisao(i, item)){ //Testa se houve colisão
                    return item;
                }
            }
        }
        return null;
    }
    
    public synchronized boolean colisaoItem(Item c, Item i) {

        for (Item item : getItens()) {
                //if ((i.getX() >= inimigo.getX()) && (i.getX() < inimigo.getX() + inimigo.getWidth())
                  //      && (i.getY() >= inimigo.getY() - inimigo.getHeight()) && (i.getY() < inimigo.getY())) {
                if(colisao(i, item)){ //Testa se houve colisão
                    //item.setVisible(false); //Se tiver colisão torna o inimigo invisivel
                    return true;
                }
            
        }
        return false;
    }
}
