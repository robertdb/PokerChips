package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.MesaNoSoportaMasDeDiezJugadoresError;
import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;
import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoError;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

public class Mesa {

	private ListaCircular<Jugador> listaDeJugadores;

	private String nombre;

	private int cantidadDeFichasIniciales;

	private int cantidadMaximaDeJugadores;

	private TipoDePoker tipoDePoker;

	private int pozo;

	private Jugador boton;

	public Mesa(String nombre, Jugador jugador) {

		this.nombre = nombre;
		this.listaDeJugadores = new ListaCircular<Jugador>();
		this.listaDeJugadores.add(jugador);
		this.boton = jugador;
		this.cantidadMaximaDeJugadores = 10;

	}

	public int cantidadDeJugadoresSentados() {

		return this.listaDeJugadores.size();

	}

	public void agregarJugador(Jugador jugador) {

		jugador.acreditarFichas(1500);

		if(mesaLlena())
			throw new MesaNoSoportaMasDeDiezJugadoresError();

		if(listaDeJugadores.contains(jugador))
			throw new UnJugadorNoPuedeEstarRepetidoError();

		listaDeJugadores.add(jugador);
		
	}

	private boolean mesaLlena() {
		return (cantidadMaximaDeJugadores == listaDeJugadores.size());
	}

	public void comenzarPartida() {

		if (this.listaDeJugadores.size() == 1) {
			throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
		}	else {
			// Comienza la partida.
		}

	}

	public Jugador getBoton() {
		return boton;
	}

	public Jugador getCiegaChica() {
		return listaDeJugadores.next(getBoton());
	}

	public Jugador getCiegaGrande() {
		return listaDeJugadores.next(getCiegaChica());
	}

	public int getPozo() {
		return pozo;
	}

	public void actualizarVista(InfoJugada infoJugada) {
	}
}