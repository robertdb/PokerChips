package ram.fichaspokerapp;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    private Administrador unAdministrador = new Administrador();
    private Jugador unJugador = new Jugador();
    private Mesa mesa;


    @Test
    public void mesaSeInicializaConUnJugadorTest() {

        mesa = new Mesa("Prueba", unAdministrador);
        assertEquals(1, mesa.cantidadDeJugadoresSentados());

    }

    @Test
    public void mesaSoportaDosJugadoresTest() {

        Jugador otroJugador = new Jugador();
        mesa = new Mesa("Prueba", unAdministrador);
        mesa.agregarJugador(otroJugador);
        assertEquals(2, mesa.cantidadDeJugadoresSentados());

    }

    @Ignore
    @Test(expected = PartidaNoPuedeComenzarConUnSoloJugadorError.class)
    public void partidaNoPuedeComenzarConUnSoloJugadorTest() {

        mesa = new Mesa("Prueba", unAdministrador);
        mesa.agregarJugador(unAdministrador);
        unAdministrador.comenzarPartida();

    }

    @Test
    public void elPrimerJugadorEsAdministradorTest() {

        mesa = new Mesa("Prueba", unAdministrador);
        assertEquals(unAdministrador, mesa.getAdministrador());

    }
}