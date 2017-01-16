package ram.fichaspokerapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    private Jugador unJugador = new Jugador();
    private Mesa mesa;
    private Administrador unAdministrador = new Administrador();

    @Test
    public void mesaSeInicializaConUnJugadorTest() {

        mesa = new Mesa("prueba", unJugador);
        assertEquals(1, mesa.cantidadDeJugadoresSentados());

    }

    @Test
    public void mesaSoportaDosJugadoresTest() {

        Jugador otroJugador = new Jugador();
        mesa = new Mesa("prueba", unJugador);
        mesa.agregarJugador(otroJugador);
        assertEquals(2, mesa.cantidadDeJugadoresSentados());

    }

    @Test
    public void partidaNoPuedeComenzarConUnSoloJugadorTest() {

        mesa = new Mesa("prueba", unJugador);
        mesa.agregarJugador(unAdministrador);

    }
}