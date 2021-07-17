package modelo;

public class Agua extends Persona {
	private int PrecioAguaLitro;
	private int horas;


	public Agua(String nombre, TipoRecurso tipoRecurso) {
		super(nombre, tipoRecurso);//ocultamiento de datos reemplazael dato nombre y tipo de recurso de la clase persona
	}

	public void objeto(Persona persona) {
		throw new UnsupportedOperationException();
	} //throw new UnsupportedOperationException() indicar que el método en cuestión no está implementado actualmente


	public static void gasto(){
		throw new UnsupportedOperationException();
	}
}//