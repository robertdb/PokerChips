package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class Turn extends Ronda{

    private Jugada jugada;

    public Turn(Jugada jugada) {

        this.jugada = jugada;

    }

    @Override
    public Ronda rondaTerminada() {

        jugada.apuestaMinimaNula();

        return (Ronda) new River();

    }
}
