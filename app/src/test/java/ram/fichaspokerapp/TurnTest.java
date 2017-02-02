package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Flop;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.River;
import ram.fichaspokerapp.modelo.Ronda;
import ram.fichaspokerapp.modelo.Turn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class TurnTest {

    @Test
    public void laRondaFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){

        int ciegaGrande = 40;

        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);

        Ronda turn = new Turn(jugada);

        turn.rondaTerminada();

        assertEquals(0, jugada.getApuestaMinima());

    }

    @Test
    public void laRondaTurnTerminaYarrancaElRiverEsCorrectoTest(){

        int ciegaGrande = 40;

        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);

        Ronda turn = new Turn(jugada);

        Ronda ronda = turn.rondaTerminada();

        assertTrue(ronda instanceof River);

    }

}
