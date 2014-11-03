package engine.itens;


import engine.core.Game;
import engine.core.GameController;
import java.util.HashMap;
import javax.swing.ImageIcon;

public abstract class Item implements Runnable {
    
    private int width; //largura
    private int height; //altura
    private int x;
    private int y;
    private ImageIcon imagem; //Imagem
    private String image_key;
    private boolean visivel; //visibilidade do item
    private boolean moving;
    private HashMap<String,ImageIcon> list_imagens;
    private Thread th;
    private PosicaoRender positions;
    protected int posicao_atual;
    
    private int deslocamento;//Tamanho do deslocamento do item
    
    private void createItem(String img){
        imagem = new ImageIcon(getClass().getClassLoader().getResource("resource/"+img));
        
        list_imagens = new HashMap<String,ImageIcon>();
        image_key = "DEFAULT";
        list_imagens.put(image_key,imagem);
        
        width = imagem.getIconWidth();
        height = imagem.getIconHeight();
        
        visivel = true;
        deslocamento=1;
        
        moving = false;
    }
    
    //Construtor passando a posição
    public Item(String img, PosicaoRender positions, int pos){
        createItem(img);
        this.positions = positions;
        this.posicao_atual = pos;
        this.x = this.positions.getPosicao(this.posicao_atual).getX();
        this.y = this.positions.getPosicao(this.posicao_atual).getY();
    }
    
    //Construtor passando a posição
    public Item(String img, int x, int y){
        createItem(img);
        this.x = x;
        this.y = y;
    }
    
    //Contrutor com posição centralizada
    public Item(String img){
        createItem(img);
        this.x=(Game.LARGURA_TELA/2)-(width/2);
        this.y=(Game.ALTURA_TELA/2)-(height/2);
    }
    
    public void animarItem(final String[] keys, final int mseg){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String imagem_atual = image_key;
                for(int x=0;x<keys.length;x++){
                    changeImagem(keys[x]);
                    try {
                        Thread.sleep(mseg);
                    } catch (InterruptedException ex) {
                        
                    }
                }
                changeImagem(imagem_atual);
            }
        });
    }
    
    public synchronized void deslocarReta(int pos, int pause){
        
        if(pos>positions.getTotalCasas() || pos < 1){
            return;
        }
        
        deslocarReta(positions.getPosicao(pos).getX(),positions.getPosicao(pos).getY(),pause,pos);
        
        
    }
    
    public synchronized void deslocarReta(final int xf, final int yf, final int pause){
        deslocarReta(xf,yf,pause,0);
    }
    
    public synchronized void deslocarReta(final int xf, final int yf, final int pause, final int pos_render){
        
        if(!moving){
            
            moving = true;
        
            final int fator_x, qtd_x, fator_y, qtd_y;

            if(getX()>xf){
                fator_x = -1;
                qtd_x = getX() - xf;
            }else{
                if(getX()<xf){
                    fator_x = 1;
                    qtd_x = xf - getX();
                }else{
                    fator_x = 0;
                    qtd_x = 0;
                }
            }

            if(getY()>yf){
                fator_y = -1;
                qtd_y = getY() - yf;
            }else{
                if(getY()<yf){
                    fator_y = 1;
                    qtd_y = yf - getY();
                }else{
                    fator_y = 0;
                    qtd_y = 0;
                }
            }

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {

                    int xci = getX();
                    int yci = getY();

                    int qx = qtd_x;
                    int qy = qtd_y;

                    int maior;

                    if(qtd_x > qtd_y){
                        maior = qtd_x;
                    }else{
                        maior = qtd_y;
                    }

                    for(int x=0;x<maior;x++){
                        if(qx>0){
                            xci = xci+fator_x;
                            setX(xci);
                            qx--;
                        }
                        if(qy>0){
                            yci = yci+fator_y;
                            setY(yci);
                            qy--;
                        }
                        pausar(pause);
                    }
                    if(pos_render>0){
                        posicao_atual = pos_render;
                    }
                    moving = false;
                }
            });
            t.start();
        }
    }
    
    public synchronized void moverPara(final int dx, final int dy, final int intervalo) {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                if (!GameController.getInstance().isFimJogo()) {
                    int x = getX();
                    int y = getY();
                    int w = dx - getX() ;
                    int h = dy - getY() ;
                    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
                    if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
                    if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
                    if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
                    int longest = Math.abs(w) ;
                    int shortest = Math.abs(h) ;
                    if (!(longest>shortest)) {
                        longest = Math.abs(h) ;
                        shortest = Math.abs(w) ;
                        if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
                        dx2 = 0 ;            
                    }
                    int numerator = longest >> 1 ;
                    for (int i=0;i<=longest && !GameController.getInstance().isFimJogo();i++) {
                        pausar(intervalo);
                        setX(x);
                        setY(y);
                        numerator += shortest ;
                        if (!(numerator<longest)) {
                            numerator -= longest ;
                            x += dx1 ;
                            y += dy1 ;
                        } else {
                            x += dx2 ;
                            y += dy2 ;
                        }
                    }
                }
            }
        });
        t.start();
    }
    
    public void animar(){
        //Metodo para ser sobrescrito
    }
    
    //Pausa a animação em milesegundos
    public void pausar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            System.out.println("Erro ao pausar animação.");
        }
    }
    
    //Adiciona o item no Jogo e inicializa a thread
    public void iniciarAnimacao(){
        GameController.getInstance().addItem(this);
        th = new Thread(this);
        th.start();
    }
    
    //Define o deslocamento do item
    protected void setDeslocamento(int val){
        this.deslocamento = val;
    }
    
    protected int getDeslocamento(){
        return this.deslocamento;
    }
    
    //Retorna largura
    public int getWidth(){
        return width;
    }
    
    //Retorna altura
    public int getHeight(){
        return height;
    }
    
    //Desce
    public void downInMapa(int passo){
        downInMapa(passo, 10);
    }
    
    public void upInMapa(int passo){
        upInMapa(passo, 10);
    }
        
    public void rightInMapa(int passo){
        rightInMapa(passo, 10);
    }
        
    public void leftInMapa(int passo){
        leftInMapa(passo, 10);
    }
    
    public void downInMapa(int passo, int pause){
        if(positions!=null){
            deslocarReta(posicao_atual+(passo*positions.getColunas()), pause);
        }
    }
    
    //Sobe
    public void upInMapa(int passo, int pause){
        if(positions!=null){
            deslocarReta(posicao_atual-(passo*positions.getColunas()), pause);
        }
    }
    
    //Direita
    public void rightInMapa(int passo, int pause){
        if(positions!=null){
            deslocarReta(posicao_atual+passo, pause);
        }
    }
    
    //Esquerda
    public void leftInMapa(int passo, int pause){
        if(positions!=null){
            deslocarReta(posicao_atual-passo, pause);
        }
    }
    
    //Desce
    public void down(){
        this.y+=deslocamento;
    }
    
    //Sobe
    public void up(){
        this.y-=deslocamento;
    }
    
    //Direita
    public void right(){
        this.x+=deslocamento;
    }
    
    //Esquerda
    public void left(){
        this.x-=deslocamento;
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getImagem() {
        return imagem;
    }
    
    public void addImagem(String key, String img){
        ImageIcon i = new ImageIcon(getClass().getClassLoader().getResource("resource/"+img));
        list_imagens.put(key, i);
    }

    //Muda a imagem
    public void changeImagem(String key) {
        image_key = key;
        imagem = list_imagens.get(image_key);
    }
    
    //Verifica se o item está visivel
    public boolean isVisible() {
        return this.visivel;
    }

    //Define uma visibilidade
    public void setVisible(boolean v) {
        this.visivel = v;
    }

    @Override
    public void run() { //Metodo da thread
        animar();
    }
    
}
