package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.AgresorApuestaNula;
import ram.fichaspokerapp.modelo.AgresorPreFlop;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Flop;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.PreFlop;
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

    @Test
    public void laRondaTerminaSiLaApuestaMinimaSeMantieneEnCeroDuranteUnaVueltaDeRonda(){

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.asignarJuego(mesa);

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
