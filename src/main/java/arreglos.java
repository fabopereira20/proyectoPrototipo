import java.text.ParseException;
import java.util.Random;

public class arreglos {
    public static void mostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("[" + arreglo[i] + "]");

        }
        System.out.println("s");
    }//mostrar arreglo

    public static int[] crearArreglo() {
        Random rnum = new Random();

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnum.nextInt();

        }
        return arr;
    }//crea arreglos con numeros random


    public static int[] crearArreglo(int largo) {       // metodo 1: largo
        Random rnum = new Random();
        if (largo <= 0) {
            largo = 1;
        }
        int[] arr = new int[largo];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnum.nextInt();

        }
        System.err.println(arr);
        return arr;
    }//Crea un arreglo con largo a ingresar



    public static void llenarArreglo(int[] a) {
        Random rnum = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = rnum.nextInt();

        }
        System.out.println(a);
    }//llena un arreglo vacio con numeros randoms

    public static void llenarArreglo(int[] a, int inicio, int fin) {
        if (inicio > fin) {
            int aux = fin;
            fin = inicio;
            inicio = aux;
        }

        int rango = fin - inicio;
        if (inicio == fin) {
            rango = 1;
            inicio = 0;
        }

        Random rnum = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rnum.nextInt(rango) + inicio;

        }
        System.out.println(a);
    }

    public static int convertirstringInt(String numero) {
        numero.trim();
        numero.replaceAll(" ", "");

        int numEntero = Integer.parseInt(numero);
        return numEntero;
    }//convierte un string a entero con la clase Integer y de su método "parseInt"
}
