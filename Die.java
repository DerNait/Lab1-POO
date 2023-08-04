import java.util.Random;

public class Die{
    Random rand = new Random();

    private int valorCara;
    private final int valorCaraMax = 6;

    public void lanzarDado(){
        valorCara = rand.nextInt(valorCaraMax)+1;
    }

    public void setValorCara(int valorCara){
        this.valorCara = valorCara;
    }

    public int getValorCara(){
        return valorCara;
    }

}