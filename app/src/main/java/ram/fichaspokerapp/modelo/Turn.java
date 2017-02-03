package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class Turn extends Ronda{

    private Crupier crupier;

    public Turn(Crupier crupier) {

        this.crupier = crupier;

    }

    @Override
    public Ronda rondaTerminada() {

        crupier.nuevaRonda();

        return (Ronda) new River();

    }
}
