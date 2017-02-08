package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class Turn extends Ronda{

    private Crupier crupier;

    private Mano mano;

    public Turn(Crupier crupier, Mano mano) {

        this.crupier = crupier;

        this.mano = mano;

    }

    @Override
    public Ronda rondaTerminada() {

        crupier.nuevaRonda();

        return (Ronda) new River(mano);

    }
}
