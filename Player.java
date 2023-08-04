public class Player{

    private String nombre;
    private int puntuacion; 

    public Player(String nombre){
        this.nombre = nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion(){
        return puntuacion;
    }
}