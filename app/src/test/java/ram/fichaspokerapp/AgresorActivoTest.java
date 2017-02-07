package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Agresor;
import ram.fichaspokerapp.modelo.AgresorActivo;
import ram.fichaspokerapp.modelo.Jugador;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 3/2/17.
 */

public class AgresorActivoTest {

    @Test
    public void seguirRondaSiElProximoJugadorEnJugarNoEsElAgresor(){

        Jugador charli = new Jugador("charli", 1500);

        Agresor agresor = new AgresorActivo(charli);

        assertTrue(agresor.seguirRonda(new Jugador("veronica", 1500)));

    }

    @Test
    public void terminarRondaSiElProximoJugadorEnJugarEsElAgresor(){

        Jugador charli = new Jugador("charli", 1500);

        Agresor agresor = new AgresorActivo(charli);

        assertFalse(agresor.seguirRonda(charli));

    }


}
