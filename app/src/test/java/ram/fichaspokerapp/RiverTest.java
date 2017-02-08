package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.error.UltimaRondaTerminadaNoHayProximaError;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Mano;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.River;
import ram.fichaspokerapp.modelo.Ronda;


import static org.junit.Assert.assertEquals;
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

        crupier.asignarJuego(mesa);

        Ronda river = new River(new Mano(crupier));

        Ronda ronda = river.rondaTerminada();

        assertTrue(ronda instanceof River);

    }

}
