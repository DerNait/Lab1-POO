public class Player{

    private String nombre; //Variable donde se almacenara el nombre del jugador
    private int puntuacion; //Variable donde se almacenara el puntaje del jugador

    public Player(String nombre){ //Constructor del objeto, donde se le pedira el nombre del jugador
        this.nombre = nombre;
    }

    public void setNombre(String nombre){ //Funcion para definir y modificar el nombre del jugador
        this.nombre = nombre;
    }

    public String getNombre(){ //Funcion para obtener el nombre del jugador, devuelve la variable nombre
        return nombre;
    }

    public void setPuntuacion(int puntuacion){ //Funcion para definir y modificar la puntuacion del jugador
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion(){ //Funcion para obtener la puntuacion del jugador, devuelve la variable nombre
        return puntuacion;
    }
}