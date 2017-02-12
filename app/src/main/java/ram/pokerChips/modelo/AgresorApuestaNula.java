package ram.pokerChips.modelo;

/**
 * Created by Robert on 8/2/17.
 */
public class AgresorApuestaNula implements Agresor {

    private int apuestaMinima;

    private Crupier crupier;

    private Jugador jugadorCiegaChica;


    public AgresorApuestaNula(Crupier crupier) {

        this.apuestaMinima = 0;

        this.crupier = crupier;

        this.jugadorCiegaChica = crupier.getJugadorActual();

    }

    @Override
    public boolean seguirRonda(Jugador jugadorProximoEnJugar) {

        return !(jugadorCiegaChica == jugadorProximoEnJugar && apuestaMinima == crupier.getApuestaMinima());

    }
}
