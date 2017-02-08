package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 8/2/17.
 */
public class AgresorApuestaNula implements Agresor {

    private int apuestaMinima;

    private Crupier crupier;

    private Jugador jugadorCiegaChica;


    public AgresorApuestaNula(Crupier crupier, Jugador jugadorActual) {

        this.apuestaMinima = crupier.getApuestaMinima();

        this.crupier = crupier;

        this.jugadorCiegaChica = jugadorActual;

    }

    @Override
    public boolean seguirRonda(Jugador jugadorProximoEnJugar) {

        if(jugadorCiegaChica == jugadorProximoEnJugar && apuestaMinima == crupier.getApuestaMinima())
            return false;

        return true;
    }
}
