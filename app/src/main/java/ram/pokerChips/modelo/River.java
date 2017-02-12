package ram.pokerChips.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class River extends Ronda {

    private Mano mano;

    public River(Mano mano) {

        this.mano = mano;

    }
    @Override
    public Ronda rondaTerminada() {

        mano.determinarGanadores();

        return this;

    }
}
