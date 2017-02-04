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

		this.cantidadDeFichas -= fichasAapostar;

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

	public void actuar(Jugada infoJugada, String jugada, int apuesta  ) {

		// actualizarVista

		if (jugada == "subir"){
			
			this.subir(infoJugada,apuesta);
		}
	}

	private void fichasSuficientes(int apuesta){
		if (this.cantidadDeFichas < apuesta) {
			throw new JugadorNoPuedeApostarMasFichasQueSuPilaError();
		}
	}

	public void subir(Jugada jugada, int apuesta) {

		this.fichasSuficientes(apuesta);

		jugada.subir(apuesta);

		this.apostar(apuesta);

		this.crupier.subir(jugada);

	}

	public void igualar(Jugada jugada) {

		int apuestaMinima = jugada.getApuestaMinima();

		this.fichasSuficientes(apuestaMinima);

		jugada.igualar();

		this.apostar(apuestaMinima);

		this.crupier.igualar(jugada);
	}

	public void retirar() {

		this.crupier.retirar();
	}

	public void apuestaObligatoria(int apuesta) {

		apostar(apuesta);

	}



}


