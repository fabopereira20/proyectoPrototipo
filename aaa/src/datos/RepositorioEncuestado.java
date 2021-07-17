package datos;
import modelo.Persona;

import java.io.*;

public class RepositorioEncuestado {
    public static boolean guardarEncuestado(Persona persona){
        try{
            BufferedWriter bw =new BufferedWriter(new FileWriter("./persona.csv",true));
            bw.write(persona.toCSV()+"\n");
            bw.close();
            return true;



        }catch (IOException e){
            e.printStackTrace();
            return false;


        }

    }
}
