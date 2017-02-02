package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.UltimaRondaTerminadaNoHayProximaError;

/**
 * Created by Robert on 2/2/17.
 */
public class River extends Ronda {

    @Override
    public Ronda rondaTerminada() {

        throw new UltimaRondaTerminadaNoHayProximaError();

    }
}
