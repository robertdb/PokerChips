package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;

public class Administrador extends Jugador {

	public void comenzarPartida() {
		throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
	}

}
