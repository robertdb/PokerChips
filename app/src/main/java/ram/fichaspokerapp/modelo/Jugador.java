package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;

public class Jugador {

	private String nombre;

	private int cantidadDeFichas;

	private CrupierMediador crupier;

	public Jugador() {
	}

	public Jugador (String nombre, CrupierMediador crupier) {

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

		crupier.pasar();

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

		this.crupier.subir();

	}

	public void igualar(Jugada jugada) {

		int apuestaMinima = jugada.getApuestaMinima();

		this.fichasSuficientes(apuestaMinima);

		jugada.igualar();

		this.apostar(apuestaMinima);

		this.crupier.igualar();
	}

	public void retirar() {

		// Todavia no le avisen al crupier jeje
		//this.crupier.retirar();
	}

	public void apuestaObligatoria(int apuesta) {

		apostar(apuesta);

	}



}


