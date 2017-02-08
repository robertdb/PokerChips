package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.modelo.*;
import ram.fichaspokerapp.error.*;

import static org.junit.Assert.*;

public class MesaTest {

    private Mesa mesa;

    @Before
    public void setUp() {

        mesa = new Mesa(20); // apuesta ciega chica 20
        mesa.agregarJugador("j1");

    }

    @Test
    public void mesaSoportaDosJugadoresTest() {

        mesa.agregarJugador("j2");
        assertEquals(2, mesa.cantidadDeJugadoresSentados());

    }

    @Test(expected = MesaNoSoportaMasDeDiezJugadoresError.class)
    public void mesaNoSoportaMasDeDiezJugadoresTest() {

        mesa.agregarJugador("j2");
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

        mesa.comenzarJuego();

    }

    @Test(expected = UnJugadorNoPuedeEstarRepetidoError.class)
    public void unJugadorNoPuedeEstarRepetidoTest() {

        mesa.agregarJugador("j1");

    }

    @Test
    public void lasCiegasSeDebitanCorrectamenteTest() { // no se si este es unitario, pero buen...

        Jugador ciegaChica;
        Jugador ciegaGrande;

        mesa.agregarJugador("j2");
        mesa.agregarJugador("j3");
        mesa.comenzarJuego();
        ciegaChica = mesa.getCiegaChica();
        ciegaGrande = mesa.getCiegaGrande();
        ciegaChica.apuestaObligatoria(10);
        ciegaGrande.apuestaObligatoria(20);
        assertEquals(1490, ciegaChica.getFichas());
        assertEquals(1480, ciegaGrande.getFichas());

    }

}