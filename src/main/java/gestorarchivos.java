
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class gestorarchivos {
    private Scanner teclado = new Scanner(System.in);
    private String ruta;



    public void crearDirectorio(String ruta) {
        //  System.out.println("ingresa una ruta");
        //  String ruta = teclado.next();     //teclado.next()ingreso de texto generico,
        Path directorio = Paths.get(ruta);   //transforma el texto contenido en la varialbele ruta a una ruta de archivo

        if (Files.exists(directorio)) { //verifica si el directorio existe o no
            System.out.println("El directorio ya existe");
        } else {
            try {
                Files.createDirectories(directorio);
                System.out.println("El directorio fue creado");
            } catch (IOException e) {
                System.out.println("El diretorio no pudo ser creado");
            }
        }

    }


    public void crearArchivo(String ruta, String contenido) {
        //  System.out.println("INgrese la ruta del archivo");
        //   String ruta = teclado.next();
        Path archivo = Paths.get(ruta);
        //System.out.println("Igrese el texto que almacenaras en el archivo");
        contenido = teclado.next();
        try {
            Files.write(archivo, contenido.getBytes());
            System.out.println("El contenido del archivo es: \n" + contenido);
        } catch (IOException e) {
            System.out.println("Elacrivo n pudo ser creado");

        }
    }

    public String leerArchivo(String ruta) {
        //  System.out.println("ingresa la ruta del archivo");
        //  String ruta = teclado.next();
        Path archivo = Paths.get(ruta);
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(archivo));
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("el archivo no puede ser leido");
        }
        return contenido;
    }

    public void copiarArchivo(String ruta, String newRuta) {
        //  System.out.println("ingresa la ruta del archivo original");
        //   String ruta = teclado.next();
        //  System.out.println("ingresa la ruta del adestino de la copia");
        //   String newRuta = teclado.next();
        Path archivo = Paths.get(ruta);
        Path newArchivo = Paths.get(newRuta);
        try {
            Files.copy(archivo, newArchivo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("se a copiado exitosaente");
        } catch (Exception e) {
            System.out.println("El archivo no puede ser copiado");
        }

    }


    //nuevaLinea
    public void nuevaLinea(String ruta, String contenido) {
        String oldContenido = leerArchivo(ruta);
        crearArchivo(ruta, oldContenido + "\n" + contenido);


    }


    void eliminarArchivo(String ruta) {
        //  System.out.println("ingresa la ruta del archivo");
        //String ruta = teclado.next();
        Path archivo = Paths.get(ruta);

        try {
            Files.deleteIfExists(archivo);
            System.out.println("El archivo fue eliminado exitosamente");
        } catch (IOException e) {
            System.out.println("el archivo no pudo ser eliminado");
        }

    }

    public String[] listaArchivos(String ruta) {//me lista los archivos que hay en una carpeta ruta util para los graficos y resultados
        File f = new File(ruta);
        String[] archivos = f.list();
        return archivos;
    }
}