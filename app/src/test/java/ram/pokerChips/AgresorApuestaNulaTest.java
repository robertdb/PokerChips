package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.modelo.Agresor;
import ram.pokerChips.modelo.AgresorApuestaNula;
import ram.pokerChips.modelo.Crupier;
import ram.pokerChips.modelo.Jugador;
import ram.pokerChips.modelo.Mesa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Robert on 8/2/17.
 */

public class AgresorApuestaNulaTest {

    @Test
    public void terminarRondaSiNoHuboApuestasTest(){

        Crupier crupier = new Crupier();

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1");

        mesa.agregarJugador("j2");

        crupier.iniciarMano(mesa);

        Jugador j2 = crupier.getJugadorActual();
        j2.igualar(crupier);

        Jugador j1 = crupier.getJugadorActual();
        j1.pasar(crupier);

        // nueva ronda.
        assertEquals(0, crupier.getApuestaMinima());
        assertEquals(j2, crupier.getJugadorActual());
        // j2 es el actual y el agresor se crea con j2 como jugador
        // que comienza una nueva ronda.
        Agresor agresor = new AgresorApuestaNula(crupier);

        // si j2 es el proximo y la apuesta minima de cero
        // no subio, entonces la ronda no deberia seguir.
        assertFalse(agresor.seguirRonda(j2));

    }


}
