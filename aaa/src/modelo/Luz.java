package modelo;

public class Luz extends Persona {

	public Luz(String nombre, TipoRecurso tipoEnergia) {
		super(nombre, tipoEnergia);
	}

	public void objeto(Persona personaje) {
		throw new UnsupportedOperationException();
	}
}