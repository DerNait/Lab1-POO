import java.util.Random; //Se importa la libreria random para el tiro aleatorio de los dados

public class Die{
    Random rand = new Random(); //Se instancia el objeto random para poder generar valores aleatorios

    private int valorCara; //Variable de la cara que sale al tirar el dado
    private final int valorCaraMax = 6; //La cantidad de caras que tiene el dado y por ende, el valor maximo de la cara que puede tener

    public void lanzarDado(){ //Funcion para lanzar el dado, generando un valor aleatorio entre 1 y 6
        valorCara = rand.nextInt(valorCaraMax)+1;
    }

    public void setValorCara(int valorCara){ //Funcion para definir y modificar el valor de la cara del dado
        this.valorCara = valorCara;
    }

    public int getValorCara(){ //Funcion para obtener el valor de la cara del dado, devolviendo la variable valorCara
        return valorCara;
    }

}