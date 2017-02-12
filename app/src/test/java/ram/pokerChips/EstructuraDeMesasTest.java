package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.error.MesaNoSoportaMasDeDiezJugadoresError;
import ram.pokerChips.error.MesaNoSoportaMenosDeDosJugadoresError;
import ram.pokerChips.modelo.EstructuraDeMesas;

/**
 * Created by Marcos on 09/02/2017.
 */

public class EstructuraDeMesasTest {

    @Test(expected = MesaNoSoportaMasDeDiezJugadoresError.class)
    public void mesaNoSoportaMasDeDiezJugadoresTest() {
        EstructuraDeMesas unaEstructuraDeMesas = new EstructuraDeMesas();

        unaEstructuraDeMesas.setCantidadDeJugadores(11);
    }

    @Test(expected = MesaNoSoportaMenosDeDosJugadoresError.class)
    public void mesaNoSoportaMenosDeDosJugadoresTest() {
        EstructuraDeMesas unaEstructuraDeMesas = new EstructuraDeMesas();

        unaEstructuraDeMesas.setCantidadDeJugadores(1);
    }
}
