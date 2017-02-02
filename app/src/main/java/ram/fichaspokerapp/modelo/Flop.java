package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class Flop extends Ronda{

    private Jugada jugada;

    public Flop(Jugada jugada) {

        this.jugada = jugada;

    }

    @Override
    public Ronda rondaTerminada() {

        this.jugada.apuestaMinimaNula();

        return (Ronda) new Turn();

    }
}
