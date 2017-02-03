package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 2/2/17.
 */

public interface Agresor{

    // Pre: recibe un agresor.
    // Post: devuelve false si el agresor y proximo jugador
    // en realizar su jugada coinciden.
    public boolean seguirRonda(Jugador jugadorProximoEnJugar);

}
