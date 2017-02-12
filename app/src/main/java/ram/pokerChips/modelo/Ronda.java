package ram.pokerChips.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public abstract class Ronda {

    public abstract Ronda rondaTerminada();

    public boolean rondaSinApuestasTermina(Agresor agresor, Jugador proximoJugador){

        return (!agresor.seguirRonda(proximoJugador));

    }

    public boolean cambiarRonda(Agresor agresor, Jugador proximoJugador){

        return !agresor.seguirRonda(proximoJugador)  ||
                (rondaSinApuestasTermina(agresor, proximoJugador));

    }
}
