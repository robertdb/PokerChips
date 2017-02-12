package ram.pokerChips.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class Flop extends Ronda{

    private Crupier crupier;

    public Flop(Crupier crupier) {

        this.crupier = crupier;

    }

    @Override
    public Ronda rondaTerminada() {

        crupier.nuevaRonda();

        return new Turn(crupier, new Mano(crupier));

    }
}
