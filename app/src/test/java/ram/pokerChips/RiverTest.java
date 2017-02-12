package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.modelo.Crupier;
import ram.pokerChips.modelo.Mano;
import ram.pokerChips.modelo.Mesa;
import ram.pokerChips.modelo.River;
import ram.pokerChips.modelo.Ronda;


import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class RiverTest {


    @Test
    public void UltimaRondaTerminadaNoHayProximaTest(){



        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1 boton");

        mesa.agregarJugador("j2 ciega chica");

        crupier.iniciarMano(mesa);

        Ronda river = new River(new Mano(crupier));

        Ronda ronda = river.rondaTerminada();

        assertTrue(ronda instanceof River);

    }

}
