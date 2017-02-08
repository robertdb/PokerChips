package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class PreFlop extends Ronda {

    private Crupier crupier;

    private Jugador jugadorCiegaGrande;

    private int apuestaMinima;

    public PreFlop(Crupier crupier) {

        this.crupier = crupier;

        this.jugadorCiegaGrande = crupier.getJugadorCiegaGrande();

        this.apuestaMinima = crupier.getApuestaMinima();

    }


    @Override
    public Ronda rondaTerminada() {

        crupier.nuevaRonda();

        return (Ronda)new Flop(crupier);

    }

    @Override
    public boolean cambiarRonda(Agresor agresor, Jugador proximoJugador){

        if(seguirRonda() == false || super.cambiarRonda(agresor, proximoJugador) == true)
            return true;

        return false;

    }

    @Override
    public boolean rondaSinApuestasTermina(Agresor agresor, Jugador proximoJugador){

        return false;

    }

    private boolean seguirRonda(){

        if (crupier.getJugadorActual() == jugadorCiegaGrande && apuestaMinima == crupier.getApuestaMinima()) {

            return false;
        }

        return true;

    }
}
