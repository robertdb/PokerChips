package ram.fichaspokerapp;

import org.junit.*;
import ram.fichaspokerapp.modelo.*;
import ram.fichaspokerapp.error.*;
import static org.junit.Assert.*;

public class MesaTest {

    private Jugador unJugador = new Jugador("p1", null);
    private Jugador otroJugador = new Jugador("p2", null);
    private Mesa mesa;

    @Before
    public void setUp() {

        mesa = new Mesa("Prueba", null);



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



        mesa.agregarJugador("j1");
        mesa.agregarJugador("j3");
        mesa.agregarJugador("j4");
        mesa.agregarJugador("j5");
        mesa.agregarJugador("j6");
        mesa.agregarJugador("j7");
        mesa.agregarJugador("j8");
        mesa.agregarJugador("j9");
        mesa.agregarJugador("j10");
        mesa.agregarJugador("j11");

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

        Jugador jugador3 = new Jugador("p3", null);
        Jugador ciegaChica;
        Jugador ciegaGrande;

        mesa.agregarJugador(otroJugador);
        mesa.agregarJugador(jugador3);
        mesa.comenzarPartida();
        ciegaChica = mesa.getCiegaChica();
        ciegaGrande = mesa.getCiegaGrande();
        ciegaChica.apuestaObligatoria(10);
        ciegaGrande.apuestaObligatoria(20);
        assertEquals(1490, ciegaChica.getFichas());
        assertEquals(1480, ciegaGrande.getFichas());

    }

    @Ignore
    @Test
    public void lasCiegasSeAcreditanEnElPozoCorrectamenteTest() {

        Jugador jugador3 = new Jugador();
        Jugador ciegaChica;
        Jugador ciegaGrande;

        mesa.agregarJugador(otroJugador);
        mesa.agregarJugador(jugador3);
        mesa.comenzarPartida();
        ciegaChica = mesa.getCiegaChica();
        ciegaGrande = mesa.getCiegaGrande();
        ciegaChica.apuestaObligatoria(10);
        ciegaGrande.apuestaObligatoria(20);
        assertEquals(30, mesa.getPozo());

    }
}