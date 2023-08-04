/*
Nombre: Kevin Josué Villagrán Mérida
Carnet: 23584
Fecha de creación: 4/08/2023 - 07:57 a.m.
Fecha de ultima modificación: 4/08/2023 - a.m.
*/

import java.util.Scanner; //Importamos el scanner para que los usuarios puedan introducir valores

public class PIG{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in); //Se instancia el scanner que estaremos utilizando

        int seleccion = 0;//Esta llevara la opcion que el jugador haya escogido en el menu. 
        boolean menu = true;

        //Menú principal
        while(menu){
            System.out.println("\n===== PIG =====");
            System.out.println("\n¿Que deseas hacer? Introduzca el numero de la opción que desea escoger");
            System.out.println("1. Comenzar a jugar");
            System.out.println("2. Salir");

            try{
                seleccion = Integer.parseInt(scan.nextLine());
            }catch(Exception e){
                System.out.println("\nIntroduzca un valor numerico valido");
            }

            switch(seleccion){
                case 1:
                    menu = false;
                    jugar();
                    break;
                case 2:
                    System.out.println("Gracias por jugar ¡Hasta pronto!");
                    menu = false;
                    break;
                default:
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            }
        }
    }

    public static void jugar(){
        Scanner scan = new Scanner(System.in);

        boolean gameOver = false;
        boolean ceder = false;
        String nombre;

        Die dado = new Die();
        Die dado2 = new Die();

        System.out.println("\n==== REGISTRO DE JUGADORES ====");
        //Registramos al jugador 1
        System.out.println("\nIntroduzca el nombre del JUGADOR 1");
        nombre = scan.nextLine();
        Player jugador1 = new Player(nombre);

        //Registramos al jugador 2
        System.out.println("\nIntroduzca el nombre del JUGADOR 2");
        nombre = scan.nextLine();
        Player jugador2 = new Player(nombre);

        //Registramos al jugador 3
        System.out.println("\nIntroduzca el nombre del JUGADOR 3");
        nombre = scan.nextLine();
        Player jugador3 = new Player(nombre);

        //Registramos al jugador 4
        System.out.println("\nIntroduzca el nombre del JUGADOR 4");
        nombre = scan.nextLine();
        Player jugador4 = new Player(nombre);

        while(gameOver == false){
        //TIRA EL JUGADOR 1
        int puntosRonda = 0;
        ceder = false;
        System.out.println("\n==== TIRA JUGADOR "+jugador1.getNombre()+" ====");
        while(ceder == false){
            int seleccion = 0;
            boolean anException = true;
            if(ceder != true){
                
            }
            do{
                System.out.println("\n¿Desea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
            } while(anException);

            switch(seleccion){
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado();
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara();
                    tiro2 = dado2.getValorCara();
                    System.out.println("Tu lanzamiento quedo:");
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){
                        jugador1.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{
                        jugador1.setPuntuacion(jugador1.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador1.getPuntuacion());
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                    if(puntosRonda >= 20){
                        System.out.println("Has llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    if(jugador1.getPuntuacion() >= 100){
                        System.out.println("\n¡¡¡EL JUGADOR "+jugador1.getNombre()+" GANA LA PARTIDA!!!");
                        gameOver = true;
                    }
                    else
                        gameOver = false;

                    break;
                case 2:
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default:
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }
        
        //TIRA EL JUGADOR 2
        ceder = false;
        puntosRonda = 0;
        System.out.println("\n==== TIRA JUGADOR "+jugador2.getNombre()+" ====");
        while(ceder == false){
            int seleccion = 0;
            boolean anException = true;
            if(ceder != true){
                
            }
            do{
                System.out.println("\n¿Desea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
            } while(anException);

            switch(seleccion){
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado();
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara();
                    tiro2 = dado2.getValorCara();
                    System.out.println("Tu lanzamiento quedo:");
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){
                        jugador2.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{
                        jugador2.setPuntuacion(jugador2.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador2.getPuntuacion());
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                    if(puntosRonda >= 20){
                        System.out.println("Has llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    if(jugador2.getPuntuacion() >= 100){
                        System.out.println("\n¡¡¡EL JUGADOR "+jugador2.getNombre()+" GANA LA PARTIDA!!!");
                        gameOver = true;
                    }

                    break;
                case 2:
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default:
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }

        //TIRA EL JUGADOR 3
        ceder = false;
        puntosRonda = 0;
        System.out.println("\n==== TIRA JUGADOR "+jugador3.getNombre()+" ====");
        while(ceder == false){
            int seleccion = 0;
            boolean anException = true;
            if(ceder != true){
                
            }
            do{
                System.out.println("\n¿Desea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
            } while(anException);

            switch(seleccion){
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado();
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara();
                    tiro2 = dado2.getValorCara();
                    System.out.println("Tu lanzamiento quedo:");
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){
                        jugador3.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{
                        jugador3.setPuntuacion(jugador3.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador3.getPuntuacion());
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                    if(puntosRonda >= 20){
                        System.out.println("Has llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    if(jugador3.getPuntuacion() >= 100){
                        System.out.println("\n¡¡¡EL JUGADOR "+jugador3.getNombre()+" GANA LA PARTIDA!!!");
                        gameOver = true;
                    }

                    break;
                case 2:
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default:
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }

        //TIRA EL JUGADOR 4
        ceder = false;
        puntosRonda = 0;
        System.out.println("\n==== TIRA JUGADOR "+jugador4.getNombre()+" ====");
        while(ceder == false){
            int seleccion = 0;
            boolean anException = true;
            if(ceder != true){
                
            }
            do{
                System.out.println("\n¿Desea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
            } while(anException);

            switch(seleccion){
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado();
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara();
                    tiro2 = dado2.getValorCara();
                    System.out.println("Tu lanzamiento quedo:");
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){
                        jugador4.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{
                        jugador4.setPuntuacion(jugador4.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador4.getPuntuacion());
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                    if(puntosRonda >= 20){
                        System.out.println("Has llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    if(jugador4.getPuntuacion() >= 100){
                        System.out.println("\n¡¡¡EL JUGADOR "+jugador4.getNombre()+" GANA LA PARTIDA!!!");
                        gameOver = true;
                    }

                    break;
                case 2:
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default:
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }
        }
        return;
    }
}