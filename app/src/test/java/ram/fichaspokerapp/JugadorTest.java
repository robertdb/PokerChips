package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;
import ram.fichaspokerapp.error.JugadorNoPuedePasarSiHayAgresorError;
import ram.fichaspokerapp.error.JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class JugadorTest {

    private Jugador jugador;
    private Jugada jugada;
    private Crupier crupier = new Crupier();

    @Before
    public void setUp() {

        crupier.asignarJuego(null, new Mesa(null,null));

        jugador = new Jugador("RAM", crupier);

        jugada = new Jugada(new Pozo(15000), 40,40);

    }

    @Test(expected = JugadorNoPuedeApostarMasFichasQueSuPilaError.class)
    public void jugadorNoPuedeApostarMasFichasQueSuPilaTest() {

        jugador.subir(jugada, 1501);

    }

    @Ignore
    @Test(expected = JugadorNoPuedePasarSiHayAgresorError.class)
    public void jugadorNoPuedePasarSiHayAgresorTest() {

    }

    @Test
    public void realizarUnaSubidaDebitaCorrectamenteTest(){

        // Hipotetico caso: el jugador realiza una subida +60,
        // paga los 40 de la ciega grande y agrega +20.
        jugador.subir(jugada, 60);

        assertEquals(1440, jugador.getFichas());

    }

    @Test(expected = JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError.class)
    public void jugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaTest(){

        // Apuesta minima es de 40.
        jugador.subir(jugada, 20);

    }
}
