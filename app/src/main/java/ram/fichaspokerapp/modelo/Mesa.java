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

	private Pozo pozo;

	private Jugador boton;

	private int fichasTotales;

	public Mesa(String nombre, Jugador jugador) {

		this.nombre = nombre;
		this.listaDeJugadores = new ListaCircular<Jugador>();
		this.boton = jugador;
		this.cantidadMaximaDeJugadores = 10;
		// Todo: el jugador tiene que volar del contructor. Hay que crear una instancia de crupier o
		// Todo: o que lo reciba en el constructor.

		this.agregarJugador(jugador.getNombre());

	}

	public int cantidadDeJugadoresSentados() {

		return this.listaDeJugadores.size();

	}

	public void agregarJugador(String nombre) {
		// TODO refactorizar
		// ya se le estan agregando en el constructor
		// de jugador, despues vemos donde se van a agregar.
		// por ahora dejo comentado aca para que no rompa tests.
		//jugador.acreditarFichas(1500);
		Jugador jugador = new Jugador(nombre, new Crupier());


		if(mesaLlena())
			throw new MesaNoSoportaMasDeDiezJugadoresError();

		if(listaDeJugadores.contains(nombre))
			throw new UnJugadorNoPuedeEstarRepetidoError();

		listaDeJugadores.add(nombre);
		
	}

	private boolean mesaLlena() {
		return (cantidadMaximaDeJugadores == listaDeJugadores.size());
	}

	public void comenzarPartida() {
		// Todo determinar el boton y las ciegas.
		if (this.listaDeJugadores.size() == 1) {
			throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
		}	else {
			// Comienza la partida.
			this.fichasTotales = listaDeJugadores.size() * this.cantidadDeFichasIniciales;

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

	public Pozo getPozo() {
		return pozo;
	}

	public void actualizarVista(Jugada jugada) {
	}

	public int getFichasTotales() {
		return fichasTotales;
	}
}