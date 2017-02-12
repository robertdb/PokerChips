package ram.pokerChips.modelo;

import ram.pokerChips.error.MesaNoSoportaMasDeDiezJugadoresError;
import ram.pokerChips.error.MesaNoSoportaMenosDeDosJugadoresError;

/**
 * Created by Marcos on 09/02/2017.
 */

public class EstructuraDeMesas {
    private int cantidadDeJugadores = 10; // Por ahora...
    private int apuestaCiegaChica;
    private EstructuraDeCiegas estructuraDeCiegas;

    public EstructuraDeMesas() {
        estructuraDeCiegas = new EstructuraDeCiegas();
    }

    public int getApuestaCiegaChica() {
        return estructuraDeCiegas.getNivelDeCiegasActual().getCiegaChica();
    }

    public int getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }

    public void setCantidadDeJugadores(int cantidadDeJugadores) {
        if (cantidadDeJugadores > 10) {
            throw new MesaNoSoportaMasDeDiezJugadoresError();
        }
        if (cantidadDeJugadores < 2) {
            throw new MesaNoSoportaMenosDeDosJugadoresError();
        }
        this.cantidadDeJugadores = cantidadDeJugadores;
    }
}
