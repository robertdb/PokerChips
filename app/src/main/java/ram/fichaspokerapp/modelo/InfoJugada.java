package ram.fichaspokerapp.modelo;

/**
 * Created by Samsung on 27/01/2017.
 */
public class InfoJugada {

    private int pozo;
    private int apuestaMinima;


    public InfoJugada(int pozo, int apuestaMinima) {

        this.pozo = pozo;
        this.apuestaMinima = apuestaMinima;

    }

    public void actualizar(int apuesta) {


    }

    public int apuestaMinima() {
        return apuestaMinima;
    }
}
