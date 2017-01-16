package ram.fichaspokerapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    @Test
    public void mesaSeInicializaConUnJugadorTest() {

        Jugador unJugador = new Jugador();
        Mesa mesita = new Mesa(unJugador);
        assertEquals(1, mesita.cantidadDeJugadoresSentados());

    }

    @Test
    public void mesaSoportaDosJugadoresTest() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Mesa mesita = new Mesa(unJugador);
        mesita.agregarJugador(otroJugador);
        assertEquals(2, mesita.cantidadDeJugadoresSentados());

    }
    
}