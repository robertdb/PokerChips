package ram.fichaspokerapp;

import org.junit.Test;


import ram.fichaspokerapp.modelo.Crupier;
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

        /*int ciegaGrande = 40;
        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);*/
        // Dentro de crupier se crea la jugada.
        Crupier crupier = new Crupier();

        Ronda turn = new Turn(crupier);

        turn.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaTurnTerminaYarrancaElRiverEsCorrectoTest(){

        Ronda turn = new Turn(new Crupier());

        Ronda ronda = turn.rondaTerminada();

        assertTrue(ronda instanceof River);

    }

}
