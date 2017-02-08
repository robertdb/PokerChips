package ram.fichaspokerapp;

import org.junit.Test;


import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Mano;
import ram.fichaspokerapp.modelo.Mesa;
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

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.asignarJuego(mesa);

        Ronda turn = new Turn(crupier, new Mano(crupier));

        turn.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaTurnTerminaYarrancaElRiverEsCorrectoTest(){

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.asignarJuego(mesa);

        Ronda turn = new Turn(crupier, new Mano(crupier));

        Ronda ronda = turn.rondaTerminada();

        assertTrue(ronda instanceof River);

    }

}
