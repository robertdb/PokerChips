package ram.fichaspokerapp;
import java.util.ArrayList;
import java.util.List;

class Mesa {

	private List<Jugador> listaDeJugadores;

	private String nombre;

	private int cantidadDeFichasIniciales;

	private TipoDePoker tipoDePoker;

	private int pozo;

	private Administrador administrador;

	Mesa(String nombre, Administrador administrador) {

		this.nombre = nombre;
		this.administrador = administrador;
		this.listaDeJugadores = new ArrayList<>();
		this.listaDeJugadores.add(administrador);

	}

	int cantidadDeJugadoresSentados() {

		return this.listaDeJugadores.size();

	}

	void agregarJugador(Jugador jugador) {

		listaDeJugadores.add(jugador);

	}

	Administrador getAdministrador() {
		return administrador;
	}
}
