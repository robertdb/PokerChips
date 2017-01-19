package ram.fichaspokerapp.modelo;
import java.util.ArrayList;
import java.util.List;

import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoEnLaMesaError;

public class Mesa {

	private List<Jugador> listaDeJugadores;

	private String nombre;

	private int cantidadDeFichasIniciales;

	private TipoDePoker tipoDePoker;

	private int pozo;

	private Administrador administrador;

	public Mesa(String nombre, Administrador administrador) {

		this.nombre = nombre;
		this.administrador = administrador;
		this.listaDeJugadores = new ArrayList<>();
		this.listaDeJugadores.add(administrador);

	}

	public int cantidadDeJugadoresSentados() {

		return this.listaDeJugadores.size();

	}

	public void agregarJugador(Jugador jugador) {

		if (! listaDeJugadores.contains(jugador)) {
			listaDeJugadores.add(jugador);
		}	else {
			throw new UnJugadorNoPuedeEstarRepetidoEnLaMesaError();
		}

	}

	public Administrador getAdministrador() {
		return administrador;
	}
}
