package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;

public class Jugador {

	private String nombre;

	private int cantidadDeFichas;

	private Crupier crupier;

	public Jugador() {
	}

	public Jugador (String nombre, Crupier crupier) {

		this.nombre = nombre;
		this.cantidadDeFichas = 1500;
		this.crupier = crupier;
	}

	private void apostar(int fichasAApostar) {

		if (this.cantidadDeFichas < fichasAApostar) {
			throw new JugadorNoPuedeApostarMasFichasQueSuPilaError();
		}	else {
			this.cantidadDeFichas -= fichasAApostar;
		}

	}

	public int getFichas() {
		return cantidadDeFichas;
	}

	public void acreditarFichas(int fichas) {
		this.cantidadDeFichas = this.cantidadDeFichas + fichas;
	}

	public String getNombre() {
		return nombre;
	}

	public void pasar() {


	}

	public void actuar(InfoJugada infoJugada, String jugada, int apuesta  ) {

		// actualizarVista

		if (jugada == "subir"){
			
			this.subir(infoJugada,apuesta);
		}
	}

	private void subir(InfoJugada infoJugada, int apuesta) {

		this.apostar(apuesta);
		infoJugada.actualizar(apuesta);
		this.crupier.subir(infoJugada);

	}
}


