package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Flop;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.PreFlop;
import ram.fichaspokerapp.modelo.Ronda;
import ram.fichaspokerapp.modelo.Turn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class FlopTest {

    @Test
    public void laRondaFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){

        int ciegaGrande = 40;
        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);

        Ronda flop = new Flop(jugada);

        flop.rondaTerminada();

        assertEquals(0, jugada.getApuestaMinima());

    }

    @Test
    public void laRondaFlopTerminaYarrancaElTurnEsCorrectoTest(){

        int ciegaGrande = 40;
        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);

        Ronda flop = new Flop(jugada);

        Ronda ronda = flop.rondaTerminada();

        assertTrue(ronda instanceof Turn);

    }
}
