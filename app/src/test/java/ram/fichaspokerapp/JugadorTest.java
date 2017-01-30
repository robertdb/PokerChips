package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;
import ram.fichaspokerapp.error.JugadorNoPuedePasarSiHayAgresorError;
import ram.fichaspokerapp.error.JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.InfoJugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class JugadorTest {

    private Jugador jugador;
    private  InfoJugada infoJugada;
    private Crupier crupier = new Crupier();

    @Before
    public void setUp() {

        crupier.asignarJuego(null, new Mesa(null,null));

        jugador = new Jugador("RAM", crupier);

        infoJugada = new InfoJugada(new Pozo(15000), 40);

    }

    @Test(expected = JugadorNoPuedeApostarMasFichasQueSuPilaError.class)
    public void jugadorNoPuedeApostarMasFichasQueSuPilaTest() {

        jugador.subir(infoJugada, 1501);

    }

    @Ignore
    @Test(expected = JugadorNoPuedePasarSiHayAgresorError.class)
    public void jugadorNoPuedePasarSiHayAgresorTest() {

    }

    @Test
    public void realizarUnaSubidaDebitaCorrectamenteTest(){

        // Hipotetico caso: el jugador realiza una subida +60,
        // paga los 40 de la ciega grande y agrega +20.
        jugador.subir(infoJugada, 60);

        assertEquals(1440, jugador.getFichas());

    }

    @Test(expected = JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError.class)
    public void jugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaTest(){

        // Apuesta minima es de 40.
        jugador.subir(infoJugada, 20);

    }
}
