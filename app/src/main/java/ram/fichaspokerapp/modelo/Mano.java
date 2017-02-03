package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class Mano {

    private Pozo pozo;

    private Crupier crupier;

    private Ronda ronda;

    public Mano(Pozo pozo, Crupier crupier) {

        this.pozo = pozo;

        this.crupier = crupier;

        this.ronda = new PreFlop(crupier);

    }


    public boolean cambiarRonda() {

        return true;

    }
}
