package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;

public class Mesa {

	private ListaDeJugadores listaDeJugadores;

	private String nombre;

	private int cantidadDeFichasIniciales;

	private TipoDePoker tipoDePoker;

	private int pozo;

	public Mesa(String nombre, Jugador jugador) {

		this.nombre = nombre;
		this.listaDeJugadores = new ListaDeJugadores();
		this.listaDeJugadores.add(jugador);

	}

	public int cantidadDeJugadoresSentados() {

		return this.listaDeJugadores.size();

	}

	public void agregarJugador(Jugador jugador) {

		listaDeJugadores.add(jugador);

	}

	public void comenzarPartida() {
		throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
	}
}
