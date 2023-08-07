/*
Nombre: Kevin Josué Villagrán Mérida
Carnet: 23584
Fecha de creación: 4/08/2023 - 07:57 a.m.
Fecha de ultima modificación: 6/08/2023 - 22:13 p.m.
*/

import java.util.Scanner; //Importamos el scanner para que los usuarios puedan introducir valores

public class PIG{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in); //Se instancia el scanner que estaremos utilizando

        int seleccion = 0;//Esta llevara la opcion que el jugador haya escogido en el menu. 
        boolean menu = true;

        //Menú principal con un ciclo que termina si decide salir
        while(menu){
            System.out.println("\n===== PIG =====");
            System.out.println("\nQue deseas hacer? Introduzca el numero de la opcion que desea escoger");
            System.out.println("1. Comenzar a jugar");
            System.out.println("2. Salir");

            try{//Se verifica que el usuario ingrese un valor numerico valido 
                seleccion = Integer.parseInt(scan.nextLine());
            }catch(Exception e){
                System.out.println("\nIntroduzca un valor numerico valido");
            }

            switch(seleccion){
                case 1: //Si el jugador escoge 1, comenzara el juego
                    menu = false;
                    jugar();
                    break;
                case 2: //Si escoge dos, se cerrara el ciclo del menu y con eso el programa terminara
                    System.out.println("Gracias por jugar ¡Hasta pronto!");
                    menu = false;
                    break;
                default: //Si escoge una opcion que no es ni 1 ni 2, se le avisara al usuario que ingrese valores correctos
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            }
        }
    }

    public static void jugar(){ //Funcion de jugar
        Scanner scan = new Scanner(System.in); //Se instancia el Scanner para que los usuarios puedan introducir valores con el teclado

        boolean gameOver = false; //Variable booleana que determinara cuando se termina el juego
        boolean ceder = false; //Variable booleana que determinara cuando un jugador decide ceder su turno
        String nombre; //String que nos permetira almacenar las entradas de teclado del nombre del jugador

        Die dado = new Die(); //Se crean los dados con los que se jugaran
        Die dado2 = new Die();

        System.out.println("\n==== REGISTRO DE JUGADORES ====");
        //Registramos al jugador 1
        System.out.println("\nIntroduzca el nombre del JUGADOR 1");
        nombre = scan.nextLine();
        Player jugador1 = new Player(nombre); //Instanciamos un nuevo jugador con le nombre introducido

        //Registramos al jugador 2
        System.out.println("\nIntroduzca el nombre del JUGADOR 2");
        nombre = scan.nextLine();
        Player jugador2 = new Player(nombre); //Instanciamos un nuevo jugador con le nombre introducido

        //Registramos al jugador 3
        System.out.println("\nIntroduzca el nombre del JUGADOR 3");
        nombre = scan.nextLine();
        Player jugador3 = new Player(nombre); //Instanciamos un nuevo jugador con le nombre introducido

        //Registramos al jugador 4
        System.out.println("\nIntroduzca el nombre del JUGADOR 4");
        nombre = scan.nextLine();
        Player jugador4 = new Player(nombre); //Instanciamos un nuevo jugador con le nombre introducido
 
        while(gameOver == false){
        //TIRA EL JUGADOR 1
        int puntosRonda = 0;
        if(!gameOver){ //Mientras no sea gameOver, se reiniciaran los valores de rondas anteriores
            ceder = false;
            puntosRonda = 0;
            System.out.println("\n==== TIRA JUGADOR "+jugador1.getNombre()+" ====");
        } 
        while(ceder == false && gameOver != true){ //Esto se repetira hasta que el jugador decida ceder, llegue al limite por ronda, o se acabe el juego (ganando)
            int seleccion = 0;
            boolean anException = true; //Variable booleana que ayudara a verificar que el usuario introduzca bien un valor numerico
            do{
                System.out.println("\nDesea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{ //Se verifica que el usuario introduzca un valor numerico valido con un ciclo que terminara hasta que lo introduzca correctamente
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
            } while(anException); //Mientras de error, se repetira este ciclo

            switch(seleccion){ //Si la opcion del jugador es 1, este tirara su dado
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado();//Se lanzan ambos dados
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara();//Se obtienen y se almacenan los valores de las caras de ambos dados
                    tiro2 = dado2.getValorCara();
                    System.out.println("\nTu lanzamiento quedo:");//Se muestra como quedaron los tiros del dado
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){//Si alguna de las caras dio como resultado 1, se reiniciara la puntuacion del jugador, de la ronda y se cedera el turno automaticamente.
                        jugador1.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{//De no haber un 1 entre las caras de los dados, se sumaran los resultados tanto para el jugador, como para el puntaje de la ronda.
                        jugador1.setPuntuacion(jugador1.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador1.getPuntuacion());//Se muestran los puntajes de ronda y del jugador
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                    
                    if(jugador1.getPuntuacion() >= 100){//Si la puntuación del jugador llegara a ser 100 o mas, este gana la partida terminando el juego.
                        System.out.println("\nEL JUGADOR "+jugador1.getNombre()+" GANA LA PARTIDA!!!\n");
                        gameOver = true;
                        ceder = true;
                    }
                    else if(puntosRonda >= 20){//Si la puntuacion de la ronda es mayor o igual a 20, se pasa al siguiente jugador.
                        System.out.println("\nHas llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    break;
                case 2://Si escoge la opcion 2, el jugador cedera su turno
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default://Si el usuario introduce un valor que no es ni 1 ni 2, se le avisara le pedira que lo intente de nuevo
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }
        
        //TIRA EL JUGADOR 2
        if(!gameOver){ //Mientras no sea gameOver, se reiniciaran los valores de rondas anteriores
            ceder = false;
            puntosRonda = 0;
            System.out.println("\n==== TIRA JUGADOR "+jugador2.getNombre()+" ====");
        } 
        while(ceder == false && gameOver != true){ //Esto se repetira hasta que el jugador decida ceder, llegue al limite por ronda, o se acabe el juego (ganando)
            int seleccion = 0;
            boolean anException = true; //Variable booleana que ayudara a verificar que el usuario introduzca bien un valor numerico
            do{
                System.out.println("\nDesea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{ //Se verifica que el usuario introduzca un valor numerico valido con un ciclo que terminara hasta que lo introduzca correctamente
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true; //Mientras de error, se repetira este ciclo
                }
            } while(anException); //Mientras de error, se repetira este ciclo

            switch(seleccion){ //Si la opcion del jugador es 1, este tirara su dado
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado(); //Se lanzan ambos dados
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara(); //Se obtienen y se almacenan los valores de las caras de ambos dados
                    tiro2 = dado2.getValorCara();
                    System.out.println("\nTu lanzamiento quedo:"); //Se muestra como quedaron los tiros del dado
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){ //Si alguna de las caras dio como resultado 1, se reiniciara la puntuacion del jugador, de la ronda y se cedera el turno automaticamente.
                        jugador2.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{ //De no haber un 1 entre las caras de los dados, se sumaran los resultados tanto para el jugador, como para el puntaje de la ronda.
                        jugador2.setPuntuacion(jugador2.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador2.getPuntuacion()); //Se muestran los puntajes de ronda y del jugador
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                    if(jugador2.getPuntuacion() >= 100){ //Si la puntuación del jugador llegara a ser 100 o mas, este gana la partida terminando el juego.
                        System.out.println("\nEL JUGADOR "+jugador2.getNombre()+" GANA LA PARTIDA!!!\n");
                        gameOver = true;
                        ceder = true;
                    }else if(puntosRonda >= 20){ //Si la puntuacion de la ronda es mayor o igual a 20, se pasa al siguiente jugador.
                        System.out.println("\nHas llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    break;
                case 2: //Si escoge la opcion 2, el jugador cedera su turno
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default: //Si el usuario introduce un valor que no es ni 1 ni 2, se le avisara le pedira que lo intente de nuevo
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }

        //TIRA EL JUGADOR 3
        if(!gameOver){ //Mientras no sea gameOver, se reiniciaran los valores de rondas anteriores
            ceder = false;
            puntosRonda = 0;
            System.out.println("\n==== TIRA JUGADOR "+jugador3.getNombre()+" ====");
        } 
        while(ceder == false){ //Esto se repetira hasta que el jugador decida ceder, llegue al limite por ronda, o se acabe el juego (ganando)
            int seleccion = 0;
            boolean anException = true; //Variable booleana que ayudara a verificar que el usuario introduzca bien un valor numerico
            if(ceder != true && gameOver != true){
                
            }
            do{
                System.out.println("\nDesea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{ //Se verifica que el usuario introduzca un valor numerico valido con un ciclo que terminara hasta que lo introduzca correctamente
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){ 
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
            } while(anException); //Mientras de error, se repetira este ciclo

            switch(seleccion){ //Si la opcion del jugador es 1, este tirara su dado
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado();
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara(); //Se obtienen y se almacenan los valores de las caras de ambos dados
                    tiro2 = dado2.getValorCara();
                    System.out.println("\nTu lanzamiento quedo:"); //Se muestra como quedaron los tiros del dado
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){ //Si alguna de las caras dio como resultado 1, se reiniciara la puntuacion del jugador, de la ronda y se cedera el turno automaticamente.
                        jugador3.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{
                        jugador3.setPuntuacion(jugador3.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador3.getPuntuacion()); //Se muestran los puntajes de ronda y del jugador
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                     if(jugador3.getPuntuacion() >= 100){ //Si la puntuación del jugador llegara a ser 100 o mas, este gana la partida terminando el juego.
                        System.out.println("\nEL JUGADOR "+jugador3.getNombre()+" GANA LA PARTIDA!!!\n");
                        gameOver = true;
                        ceder = true;
                    }else if(puntosRonda >= 20){ //Si la puntuacion de la ronda es mayor o igual a 20, se pasa al siguiente jugador.
                        System.out.println("\nHas llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    break;
                case 2: //Si escoge la opcion 2, el jugador cedera su turno
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default: //Si el usuario introduce un valor que no es ni 1 ni 2, se le avisara le pedira que lo intente de nuevo
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }

        //TIRA EL JUGADOR 4
        if(!gameOver){ //Mientras no sea gameOver, se reiniciaran los valores de rondas anteriores
            ceder = false;
            puntosRonda = 0;
            System.out.println("\n==== TIRA JUGADOR "+jugador4.getNombre()+" ====");
        }  
        while(ceder == false){ //Esto se repetira hasta que el jugador decida ceder, llegue al limite por ronda, o se acabe el juego (ganando)
            int seleccion = 0;
            boolean anException = true; //Variable booleana que ayudara a verificar que el usuario introduzca bien un valor numerico
            do{
                System.out.println("\nDesea lanzar el dado o ceder? 1. Lanzar 2. Ceder");
                try{ //Se verifica que el usuario introduzca un valor numerico valido con un ciclo que terminara hasta que lo introduzca correctamente
                    seleccion = Integer.parseInt(scan.nextLine());
                    anException = false;
                }catch(Exception e){
                    System.out.println("\nIntroduzca un valor numerico valido");
                    anException = true;
                }
            } while(anException); //Mientras de error, se repetira este ciclo

            switch(seleccion){ //Si la opcion del jugador es 1, este tirara su dado
                case 1:
                    int tiro1 = 0;
                    int tiro2 = 0;

                    dado.lanzarDado(); //Se lanzan ambos dados
                    dado2.lanzarDado();
                    tiro1 = dado.getValorCara(); //Se obtienen y se almacenan los valores de las caras de ambos dados
                    tiro2 = dado2.getValorCara(); 
                    System.out.println("\nTu lanzamiento quedo:"); //Se muestra como quedaron los tiros del dado
                    System.out.println(tiro1);
                    System.out.println(tiro2);

                    if(tiro1 == 1 || tiro2 == 1){ //Si alguna de las caras dio como resultado 1, se reiniciara la puntuacion del jugador, de la ronda y se cedera el turno automaticamente.
                        jugador4.setPuntuacion(0);
                        puntosRonda = 0;
                        ceder = true;
                    }
                    else{ //De no haber un 1 entre las caras de los dados, se sumaran los resultados tanto para el jugador, como para el puntaje de la ronda.
                        jugador4.setPuntuacion(jugador4.getPuntuacion()+(tiro1+tiro2));
                        puntosRonda += (tiro1+tiro2);
                    }
                        
                    System.out.println("Su puntuacion es de: "+jugador4.getPuntuacion()); //Se muestran los puntajes de ronda y del jugador
                    System.out.println("Su puntuacion (RONDA) es de: "+puntosRonda);

                    if(jugador4.getPuntuacion() >= 100){ //Si la puntuación del jugador llegara a ser 100 o mas, este gana la partida terminando el juego.
                        System.out.println("\nEL JUGADOR "+jugador4.getNombre()+" GANA LA PARTIDA!!!\n");
                        gameOver = true;
                        ceder = true;
                    }
                    else if(puntosRonda >= 20){ //Si la puntuacion de la ronda es mayor o igual a 20, se pasa al siguiente jugador.
                        System.out.println("\nHas llegado al limite de tiros");
                        System.out.println("Pasando al siguiente jugador, presiona enter para continuar...");
                        scan.nextLine();
                        ceder = true;
                    }

                    break;
                case 2: //Si escoge la opcion 2, el jugador cedera su turno
                    ceder = true;
                    System.out.println("Has cedido");
                    break;
                default://Si el usuario introduce un valor que no es ni 1 ni 2, se le avisara le pedira que lo intente de nuevo
                    System.out.println("Solo puede escoger una opcion entre 1 y 2.");
                    System.out.println("Presione enter para continuar...");
                    scan.nextLine();
                    break;
            } 
        }
        }
        return; //Si se acaba el juego, termina el programa.
    }
}