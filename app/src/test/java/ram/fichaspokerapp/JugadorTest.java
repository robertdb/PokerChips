package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.JugadorNoPuedePasarSiHayAgresorError;
import ram.fichaspokerapp.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class JugadorTest {

    private Jugador jugador;

    private Jugada jugada;

    private Crupier crupier;

    @Before
    public void setUp() {

        crupier = new Crupier();

        int ciegaGrande = 40;
        jugada = new Jugada(ciegaGrande);

        jugador = new Jugador("RAM", 1500);

        ListaCircular<String> lista = new ListaCircular<String>();
        lista.add(jugador);

        crupier.asignarJuego(new Mesa());

        crupier.crearMano();

    }

    @Ignore
    @Test(expected = JugadorNoPuedePasarSiHayAgresorError.class)
    public void jugadorNoPuedePasarSiHayAgresorTest() {

    }

    @Test
    public void realizarUnaSubidaDebitaCorrectamenteTest(){

        // Hipotetico caso: el jugador realiza una subida +80,
        // paga los 40 de la ciega grande y agrega +40.
        jugador.subir(crupier, 80);

        assertEquals(1420, jugador.getFichas());

    }

    @Test(expected = NoSePuedeSubirMenosQueLaSubidaMinimaError.class)
    public void noSePuedeSubirMenosQueLaSubidaMinimaTest(){

        // Apuesta minima es de 40.
        jugador.subir(crupier, 20);

    }

    @Test
    public void realizarUnaIgualadaDebitaCorrectamenteTest() {

        crupier = new Crupier();

        int ciegaGrande = 60;
        jugada = new Jugada(ciegaGrande);

        jugador = new Jugador("RAM", 1500);

        ListaCircular<String> lista = new ListaCircular<String>();
        lista.add(jugador);

        crupier.asignarJuego(new Mesa());

        crupier.crearMano();


        // Un jugador sube +400.
        int apuesta = 400;

        Jugador jugador2 = new Jugador("j2", 1500);

        jugador2.subir(crupier, apuesta);

        // jugador intenta igualar los 400.
        jugador.igualar(crupier);

        assertEquals(1100, jugador.getFichas());
    }

    @Test
    public void primerJugadorEnJugarIgualaLaCiegaGrandeDeLaRondaDebitandoCorrectamenteTest() {

        // el jugador iguala los 60 de la ciega grande.
        int ciegaGrande = 60;
        Jugada jugadaNueva = new Jugada(ciegaGrande);
        jugador.igualar(crupier);

        assertEquals(1440, jugador.getFichas());
    }



    @Test
    public void jugadorSeRetiraNoModificaPozoTest() {

        int apuestaMinima = 400;
        int ciegaGrande = 60;
        Jugada jugadaNueva = new Jugada(ciegaGrande);
        jugador.retirar();

        assertEquals(1500, jugador.getFichas());


    }

}
