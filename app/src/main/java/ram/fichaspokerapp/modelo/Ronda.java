package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Robert on 2/2/17.
 */
public abstract class Ronda {

    public abstract Ronda rondaTerminada();

    public boolean cambiarRonda(Agresor agresor, Jugador proximoJugador){

        return (!agresor.seguirRonda(proximoJugador));

    }
}
