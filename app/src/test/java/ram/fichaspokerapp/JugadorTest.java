package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;
import ram.fichaspokerapp.error.JugadorNoPuedePasarSiHayAgresorError;
import ram.fichaspokerapp.error.JugadorNoPuedeSubirSiNoSuperaLaApuestaMinimaError;
import ram.fichaspokerapp.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;
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

        int apuestaMinima = 40;
        int ciegaGrande = 40;
        jugada = new Jugada(new Pozo(15000), apuestaMinima,ciegaGrande);

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

        // Hipotetico caso: el jugador realiza una subida +80,
        // paga los 40 de la ciega grande y agrega +40.
        jugador.subir(jugada, 80);

        assertEquals(1420, jugador.getFichas());

    }

    @Test(expected = NoSePuedeSubirMenosQueLaSubidaMinimaError.class)
    public void noSePuedeSubirMenosQueLaSubidaMinimaTest(){

        // Apuesta minima es de 40.
        jugador.subir(jugada, 20);

    }

    @Test
    public void realizarUnaIgualadaDebitaCorrectamenteTest() {

        // el jugador realiza una igualada +400.
        int apuestaMinima = 400;
        int ciegaGrande = 60;
        Jugada jugadaNueva = new Jugada(new Pozo(15000),apuestaMinima,ciegaGrande);
        jugador.igualar(jugadaNueva);

        assertEquals(1100, jugador.getFichas());
    }

    @Test
    public void jugadorSeRetiraNoModificaPozoTest() {

        int apuestaMinima = 400;
        int ciegaGrande = 60;
        Jugada jugadaNueva = new Jugada(new Pozo(15000),apuestaMinima,ciegaGrande);
        jugador.retirar();

        assertEquals(1500, jugador.getFichas());


    }
}
