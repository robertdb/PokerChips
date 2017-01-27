package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;
import ram.fichaspokerapp.error.JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError;

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

	private void apostar(int fichasAapostar) {

		if (this.cantidadDeFichas < fichasAapostar) {
			throw new JugadorNoPuedeApostarMasFichasQueSuPilaError();
		}	else {
			this.cantidadDeFichas -= fichasAapostar;
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

	public void subir(InfoJugada infoJugada, int apuesta) {

		if(infoJugada.apuestaMinima() >=  apuesta)
			throw new JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError();

		this.apostar(apuesta);

		infoJugada.actualizar(apuesta);

		this.crupier.subir(infoJugada);

	}

	public void apuestaObligatoria(int apuesta) {

		apostar(apuesta);

	}
}


