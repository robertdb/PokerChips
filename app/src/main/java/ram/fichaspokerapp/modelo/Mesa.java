package ram.fichaspokerapp.modelo;
import java.util.ArrayList;
import java.util.List;

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

		listaDeJugadores.add(jugador);

	}

	public Administrador getAdministrador() {
		return administrador;
	}
}
