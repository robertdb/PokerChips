package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;

public class Jugador {

	private String nombre;

	private int cantidadDeFichas;

	public Jugador() {
	}

	public Jugador (String nombre) {

		this.nombre = nombre;
		this.cantidadDeFichas = 1500;
	}

	public void apostar(int fichasAApostar) {

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
}


