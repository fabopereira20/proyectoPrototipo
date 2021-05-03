import java.util.Random;

public class arreglos {
    public static void mostrarArreglo(int[] arreglo) {   //mostrar arreglo
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("[" + arreglo[i] + "]");

        }
        System.out.println("s");
    }

    public static int[] crearArreglo() {       //metodo 1
        Random rnum = new Random();

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnum.nextInt();

        }
        return arr;
    }

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
    }

    public static int[] crearArreglo(int largo, int incio, int fin) { //crear arreeglo con v.2.5 con recursividad

        if (largo <= 0) {
            largo = 1;
        }
        int[] arr = new int[largo];
        llenarArreglo(arr, incio, fin);
        return arr;
    }

    public static void llenarArreglo(int[] a) {       //metodo 2
        Random rnum = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = rnum.nextInt();

        }
        System.out.println(a);
    }

    public static void llenarArreglo(int[] a, int inicio, int fin) {       //metodo v2.0
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

}
