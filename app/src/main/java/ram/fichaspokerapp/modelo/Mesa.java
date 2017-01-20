package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;

public class Mesa {

	private ListaDeJugadores listaDeJugadores;

	private String nombre;

	private int cantidadDeFichasIniciales;

	private TipoDePoker tipoDePoker;

	private int pozo;

	private Jugador boton;

	public Mesa(String nombre, Jugador jugador) {

		this.nombre = nombre;
		this.listaDeJugadores = new ListaDeJugadores();
		this.listaDeJugadores.add(jugador);
		this.boton = jugador;

	}

	public int cantidadDeJugadoresSentados() {

		return this.listaDeJugadores.size();

	}

	public void agregarJugador(Jugador jugador) {

		jugador.acreditarFichas(1500);
		listaDeJugadores.add(jugador);

	}

	public void comenzarPartida() {

		if (this.listaDeJugadores.size() == 1) {
			throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
		}	else {

		}

	}

	public Jugador getBoton() {
		return boton;
	}

	public Jugador getCiegaChica() {
		return listaDeJugadores.siguiente(this.getBoton());
	}

	public Jugador getCiegaGrande() {
		return listaDeJugadores.siguiente(this.getCiegaChica());
	}

	public int getPozo() {
		return pozo;
	}
}