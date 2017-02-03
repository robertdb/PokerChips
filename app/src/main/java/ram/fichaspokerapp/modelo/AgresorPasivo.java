package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */
public class AgresorPasivo implements Agresor{

    @Override
    public boolean seguirRonda(Jugador jugadorProximoEnJugar) {
        return true;
    }
}
