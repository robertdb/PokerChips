package ram.pokerChips;

import org.junit.Test;


import ram.pokerChips.modelo.Crupier;
import ram.pokerChips.modelo.Mano;
import ram.pokerChips.modelo.Mesa;
import ram.pokerChips.modelo.River;
import ram.pokerChips.modelo.Ronda;
import ram.pokerChips.modelo.Turn;

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

        crupier.iniciarMano(mesa);

        Ronda turn = new Turn(crupier, new Mano(crupier));

        turn.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaTurnTerminaYArrancaElRiverEsCorrectoTest(){

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.iniciarMano(mesa);

        Ronda turn = new Turn(crupier, new Mano(crupier));

        Ronda ronda = turn.rondaTerminada();

        assertTrue(ronda instanceof River);

    }

}
