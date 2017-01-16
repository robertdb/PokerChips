package ram.fichaspokerapp;
import java.util.ArrayList;
import java.util.List;

public class Mesa {

	private List<Jugador> listaDeJugadores;

	private String nombre;

	private int cantidadDeFichasIniciales;

	private TipoDePoker tipoDePoker;

	private int pozo;

	private Jugador jugador;

	private Administrador administrador;

	public Mesa(String nombre, Jugador jugador) {

		this.nombre = nombre;
		this.listaDeJugadores = new ArrayList<Jugador>();
		this.listaDeJugadores.add(jugador);

	}

	public int cantidadDeJugadoresSentados() {

		return this.listaDeJugadores.size();

	}

	public void agregarJugador(Jugador jugador) {

		listaDeJugadores.add(jugador);

	}
}
