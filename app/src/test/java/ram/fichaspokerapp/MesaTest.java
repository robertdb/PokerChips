package ram.fichaspokerapp;

import org.junit.Ignore;
import org.junit.Test;

import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoEnLaMesaError;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class MesaTest {

    private Jugador unJugador = new Jugador();
    private Jugador otroJugador = new Jugador();
    private Mesa mesa;


    @Test
    public void mesaSeInicializaConUnJugadorTest() {

        mesa = new Mesa("Prueba", unJugador);
        assertEquals(1, mesa.cantidadDeJugadoresSentados());

    }

    @Test
    public void mesaSoportaDosJugadoresTest() {

        Jugador otroJugador = new Jugador();
        mesa = new Mesa("Prueba", unJugador);
        mesa.agregarJugador(otroJugador);
        assertEquals(2, mesa.cantidadDeJugadoresSentados());

    }

    @Ignore
    @Test(expected = PartidaNoPuedeComenzarConUnSoloJugadorError.class)
    public void partidaNoPuedeComenzarConUnSoloJugadorTest() {

        mesa = new Mesa("Prueba", unJugador);
        mesa.agregarJugador(unJugador);
        mesa.comenzarPartida();

    }

    @Ignore
    @Test
    public void elPrimerJugadorEsAdministradorTest() {

        mesa = new Mesa("Prueba", unJugador);
//        assertEquals(unJugador, mesa.getAdministrador());

    }

    @Test(expected = UnJugadorNoPuedeEstarRepetidoEnLaMesaError.class)
    public void unJugadorNoPuedeEstarRepetidoTest() {

        mesa = new Mesa("prueba", unJugador);
        mesa.agregarJugador(unJugador);

    }

    @Test
    public void lasCiegasSeDebitanYCobranCorrectamenteTest() {

        mesa = new Mesa("Prueba", unJugador);
        mesa.agregarJugador(otroJugador);

    }
}