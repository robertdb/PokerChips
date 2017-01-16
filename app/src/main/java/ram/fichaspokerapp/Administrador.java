package ram.fichaspokerapp;

import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;

public class Administrador extends Jugador {

	public void comenzarPartida() {
		throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
	}

}
