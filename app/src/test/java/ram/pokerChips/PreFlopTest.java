package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.modelo.AgresorPreFlop;
import ram.pokerChips.modelo.Crupier;
import ram.pokerChips.modelo.Flop;
import ram.pokerChips.modelo.Jugador;
import ram.pokerChips.modelo.Mesa;
import ram.pokerChips.modelo.PreFlop;
import ram.pokerChips.modelo.Ronda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class PreFlopTest {

    @Test
    public void laRondaPreFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.iniciarMano(mesa);

        Ronda preFlop = new PreFlop(crupier);

        preFlop.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaPreFlopTerminaYArrancaElFlopEsCorrectoTest(){

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.iniciarMano(mesa);

        Ronda preFlop = new PreFlop(crupier);

        Ronda ronda = preFlop.rondaTerminada();

        assertTrue(ronda instanceof Flop);

    }

    @Test
    public void cambiarRondaSiLaCiegaGrandeNoApostoEnSuTurnoEsTrueTest(){


        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        mesa.agregarJugador("j3 ciega grande");

        crupier.iniciarMano(mesa);

        Ronda preFlop = new PreFlop(crupier);

        // Estado del juego: el jugador con la ciega grande ya jugo
        // y la apuestaMinima se mantuvo con el valor de la ciegaGrande
        // en este caso termina la ronda.

        Jugador j1 = crupier.getJugadorActual();
        j1.igualar(crupier);

        Jugador j2 = crupier.getJugadorActual();
        j2.igualar(crupier);

        assertTrue(preFlop.cambiarRonda(new AgresorPreFlop(), j1));

    }

    @Test
    public void determinarGanadorEsCorrectoTest(){

        assertTrue(true);

    }

}
