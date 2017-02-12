package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.modelo.Crupier;
import ram.pokerChips.modelo.Flop;
import ram.pokerChips.modelo.Jugador;
import ram.pokerChips.modelo.Mesa;
import ram.pokerChips.modelo.Ronda;
import ram.pokerChips.modelo.Turn;

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

        crupier.iniciarMano(mesa);

        Ronda flop = new Flop(crupier);

        assertEquals(40, crupier.getApuestaMinima());

        flop.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaFlopTerminaYArrancaElTurnEsCorrectoTest(){


        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1");

        mesa.agregarJugador("j2");

        crupier.iniciarMano(mesa);

        Ronda flop = new Flop(crupier);

        Ronda ronda = flop.rondaTerminada();

        assertTrue(ronda instanceof Turn);

    }

    @Test
    public void laRondaTerminaSiLaApuestaMinimaSeMantieneEnCeroDuranteUnaVueltaDeRonda(){

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.iniciarMano(mesa);

        Jugador j1 = crupier.getJugadorActual();
        assertEquals("j1 boton", crupier.getJugadorActual().getNombre());
        j1.igualar(crupier);

        Jugador j2 = crupier.getJugadorActual();
        j2.igualar(crupier);

        // el actual es j3 y el proximo es j1.
        Jugador j3 = crupier.getJugadorActual();
        j3.pasar(crupier);

        // Nueva ronda
        // j2 es la ciega chica y deberia comenzar el flop
        assertEquals(j2, crupier.getJugadorActual());
        j2.pasar(crupier);

        j3.pasar(crupier);

        // Estado del juego: j1 es el actual
        //  el proximo es j2.
        j1.pasar(crupier);

        // si pasaron todos deberia haber un cambio de ronda.
        assertEquals(0, crupier.getApuestaMinima());
        assertEquals(j2, crupier.getJugadorActual());

    }
}
