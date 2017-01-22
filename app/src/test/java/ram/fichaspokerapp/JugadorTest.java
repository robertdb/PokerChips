package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;
import ram.fichaspokerapp.error.JugadorNoPuedePasarSiHayAgresorError;
import ram.fichaspokerapp.modelo.Jugador;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class JugadorTest {

    private Jugador jugador;
    private Jugador jugador2;

    @Before
    public void setUp() {

        Jugador jugador = new Jugador("RAM");
        Jugador jugador2 = new Jugador("Braian de America");

    }

    @Test(expected = JugadorNoPuedeApostarMasFichasQueSuPilaError.class)
    public void jugadorNoPuedeApostarMasFichasQueSuPilaTest() {

        jugador.apostar(1501);

    }

    @Test
    public void laApuestaSeDebitaCorrectamenteTest() {

        jugador.apostar(1500);
        assertEquals(0, jugador.getFichas());

    }

    @Test(expected = JugadorNoPuedePasarSiHayAgresorError.class)
    public void jugadorNoPuedePasarSiHayAgresorTest() {

        jugador.apostar(500);
        jugador2.pasar();

    }
}
