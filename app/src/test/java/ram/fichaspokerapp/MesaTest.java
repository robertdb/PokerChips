package ram.fichaspokerapp;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ram.fichaspokerapp.error.MesaNoSoportaMasDeDiezJugadoresError;
import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoError;

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

    @Before
    public void setUp() {

        mesa = new Mesa("Prueba", unJugador);

    }

    @Test
    public void mesaSeInicializaConUnJugadorTest() {

        assertEquals(1, mesa.cantidadDeJugadoresSentados());

    }

    @Test
    public void mesaSoportaDosJugadoresTest() {

        mesa.agregarJugador(otroJugador);
        assertEquals(2, mesa.cantidadDeJugadoresSentados());

    }

    @Test(expected = MesaNoSoportaMasDeDiezJugadoresError.class)
    public void mesaNoSoportaMasDeDiezJugadoresTest() {

        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        Jugador jugador6 = new Jugador();
        Jugador jugador7 = new Jugador();
        Jugador jugador8 = new Jugador();
        Jugador jugador9 = new Jugador();
        Jugador jugador10 = new Jugador();
        Jugador jugador11 = new Jugador();

        mesa.agregarJugador(otroJugador);
        mesa.agregarJugador(jugador3);
        mesa.agregarJugador(jugador4);
        mesa.agregarJugador(jugador5);
        mesa.agregarJugador(jugador6);
        mesa.agregarJugador(jugador7);
        mesa.agregarJugador(jugador8);
        mesa.agregarJugador(jugador9);
        mesa.agregarJugador(jugador10);
        mesa.agregarJugador(jugador11);

    }

    @Test(expected = PartidaNoPuedeComenzarConUnSoloJugadorError.class)
    public void partidaNoPuedeComenzarConUnSoloJugadorTest() {

        mesa.comenzarPartida();

    }

    @Test(expected = UnJugadorNoPuedeEstarRepetidoError.class)
    public void unJugadorNoPuedeEstarRepetidoTest() {

        mesa.agregarJugador(unJugador);

    }

    @Test
    public void lasCiegasSeDebitanCorrectamenteTest() { // no se si este es unitario, pero buen...

        Jugador jugador3 = new Jugador();
        Jugador ciegaChica;
        Jugador ciegaGrande;

        mesa.agregarJugador(otroJugador);
        mesa.agregarJugador(jugador3);
        mesa.comenzarPartida();
        ciegaChica = mesa.getCiegaChica();
        ciegaGrande = mesa.getCiegaGrande();
        ciegaChica.apostar(10);
        ciegaGrande.apostar(20);
        assertEquals(1490, ciegaChica.getFichas());
        assertEquals(1480, ciegaGrande.getFichas());

    }
}