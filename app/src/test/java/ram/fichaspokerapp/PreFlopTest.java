package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Flop;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.PreFlop;
import ram.fichaspokerapp.modelo.Ronda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class PreFlopTest {

    @Test
    public void laRondaPreFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){

        int ciegaGrande = 40;
        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);

        Ronda preFlop = new PreFlop(jugada);

        preFlop.rondaTerminada();

        assertEquals(0, jugada.getApuestaMinima());

    }

    @Test
    public void laRondaPreFlopTerminaYarrancaElFlopEsCorrectoTest(){

        int ciegaGrande = 40;
        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);

        Ronda preFlop = new PreFlop(jugada);

        Ronda ronda = preFlop.rondaTerminada();

        assertTrue(ronda instanceof Flop);

    }



}
