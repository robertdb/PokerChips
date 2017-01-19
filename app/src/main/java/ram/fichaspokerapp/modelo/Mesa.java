package ram.fichaspokerapp.modelo;
import java.util.ArrayList;
import java.util.List;

import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;
import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoEnLaMesaError;

public class Mesa {

	private List<Jugador> listaDeJugadores;

	private String nombre;

	private int cantidadDeFichasIniciales;

	private TipoDePoker tipoDePoker;

	private int pozo;

	public Mesa(String nombre, Jugador jugador) {

		this.nombre = nombre;
		this.listaDeJugadores = new ArrayList<>();
		this.listaDeJugadores.add(jugador);

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

	public void comenzarPartida() {
		throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
	}
}
