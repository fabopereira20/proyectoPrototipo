


import java.util.Scanner;


public class Usuario {
    public static void main(String[] args){
        Scanner teclado =new Scanner(System.in);
       // gestorarchivos.crearArchivo();

        int salir = 0;
        do{
            menu.mostarMenu();
            var option2 = menu.leerOpcion();
            



            switch (option2) {
                case "1":
                    salir=1;
                    break;
                case "2":
                    salir=1;
                    break;
                case "3":
                    menu.menudatos();
                    var option1 = menu.leerOpcion();
                    System.out.println(menu.region(option1));
                    salir=1;
                    break;
                case "4":
                    salir=-1;
                    break;
                    



            }
        
        }while (salir>0);

    } // inicializa ejecucion del programa





    }






