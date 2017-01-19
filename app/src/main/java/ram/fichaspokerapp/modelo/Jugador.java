package ram.fichaspokerapp.modelo;

public class Jugador {

	private String nombre;

	private int cantidadDeFichas;

	public void apostar(int fichas) {

		this.cantidadDeFichas = this.cantidadDeFichas - fichas;

	}

	public int getFichas() {
		return cantidadDeFichas;
	}

	public void acreditarFichas(int fichas) {
		this.cantidadDeFichas = this.cantidadDeFichas + fichas;
	}
}
