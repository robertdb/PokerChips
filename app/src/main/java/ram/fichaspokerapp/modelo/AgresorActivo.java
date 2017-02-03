package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */

public class AgresorActivo implements Agresor {

    private Jugador agresorActivo;

    public AgresorActivo(Jugador agresor){

        this.agresorActivo = agresor;

    }

    @Override
    public boolean seguirRonda(Jugador proximoJugador) {

        if(agresorActivo == proximoJugador)
            return false;

        return true;

    }
}
