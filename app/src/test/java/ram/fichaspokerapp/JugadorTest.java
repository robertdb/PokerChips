package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;
import ram.fichaspokerapp.error.JugadorNoPuedePasarSiHayAgresorError;
import ram.fichaspokerapp.error.JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.InfoJugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class JugadorTest {

    private Jugador jugador;
    private Jugador jugador2;
    private Crupier crupier;
    @Before
    public void setUp() {

        crupier = new Crupier(new Mesa(null, null));
        jugador = new Jugador("RAM", crupier);
        jugador2 = new Jugador("Braian de America",crupier);

    }

    @Test(expected = JugadorNoPuedeApostarMasFichasQueSuPilaError.class)
    public void jugadorNoPuedeApostarMasFichasQueSuPilaTest() {

        jugador.subir(new InfoJugada(60 ,40), 1501);

    }

    @Ignore
    @Test(expected = JugadorNoPuedePasarSiHayAgresorError.class)
    public void jugadorNoPuedePasarSiHayAgresorTest() {

    }

    @Test
    public void realizarUnaSubidaDebitaCorrectamenteTest(){

        // pozo = 60 apuestaMinima = 40
        InfoJugada infoJugada = new InfoJugada(60 ,40);

        // Hipotetico caso: el jugador realiza una subida +60,
        // paga los 40 de la ciega grande y agrega +20.
        jugador.subir(infoJugada, 60);

        assertEquals(1440, jugador.getFichas());

    }

    @Test(expected = JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError.class)
    public void jugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaTest(){

        // pozo = 60 apuestaMinima = 40
        InfoJugada infoJugada = new InfoJugada(60 ,40);

        jugador.subir(infoJugada, 20);

    }
}
