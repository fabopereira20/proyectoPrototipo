package modelo;

import datos.ParseCSV;
import datos.RepositorioEncuestado;

public abstract class Persona implements ParseCSV {

    protected String nombre;
    protected TipoRecurso tipoRecurso;
    protected ListaObjetos listaObjetos;

    public Persona(String nombre, TipoRecurso tipoRecurso) {
        this.nombre = nombre;
        this.tipoRecurso = tipoRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public ListaObjetos getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(ListaObjetos listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public abstract void objeto(Persona persona);

    @Override
    public String toString() {
        return "Tipo : " + this.getClass().toString().split("\\.")[1] +
                " - tipo Recurso: " + this.tipoRecurso.toString() +
                " - nombre: " + this.nombre;

    }




    @Override
    public String toCSV(){
        return "*"+this.nombre+";"+this.tipoRecurso+";"+this.getClass().toString().split("\\.")[1]+";";
    }

    public boolean save(){
        return RepositorioEncuestado.guardarEncuestado(this);
    }
}