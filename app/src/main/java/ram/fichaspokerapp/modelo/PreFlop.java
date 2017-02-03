package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class PreFlop extends Ronda {

    private Crupier crupier;

    private Jugador jugadorCiegaGrande;

    private Agresor agresor;

    public PreFlop(Crupier crupier) {

        this.crupier = crupier;

        this.jugadorCiegaGrande = crupier.getJugadorCiegaGrande();

        this.agresor = new AgresorPasivo();

    }


    @Override
    public Ronda rondaTerminada() {

        crupier.nuevaRonda();

        return (Ronda)new Flop(crupier);

    }
}
