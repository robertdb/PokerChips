package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Flop;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Ronda;
import ram.fichaspokerapp.modelo.Turn;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class FlopTest {

    @Test
    public void laRondaFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){


        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1");

        mesa.agregarJugador("j2");

        crupier.asignarJuego(mesa);

        Ronda flop = new Flop(crupier);

        assertEquals(40, crupier.getApuestaMinima());

        flop.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaFlopTerminaYarrancaElTurnEsCorrectoTest(){


        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1");

        mesa.agregarJugador("j2");

        crupier.asignarJuego(mesa);

        Ronda flop = new Flop(crupier);

        Ronda ronda = flop.rondaTerminada();

        assertTrue(ronda instanceof Turn);

    }
}
