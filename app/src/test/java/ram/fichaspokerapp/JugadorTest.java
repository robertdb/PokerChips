package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.JugadorNoPuedePasarSiHayAgresorError;
import ram.fichaspokerapp.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class JugadorTest {

    private Crupier crupier;

    @Before
    public void setUp() {

        crupier = new Crupier();

    }

    @Ignore
    @Test(expected = JugadorNoPuedePasarSiHayAgresorError.class)
    public void jugadorNoPuedePasarSiHayAgresorTest() {

    }

    @Test
    public void realizarUnaSubidaDebitaCorrectamenteTest(){

        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("j1");

        crupier.asignarJuego(mesa);

        Jugador jugador = crupier.getJugadorActual();

        // Hipotetico caso: el jugador realiza una subida +80,
        // paga los 40 de la ciega grande y agrega +40.
        jugador.subir(crupier, 80);

        assertEquals(1420, jugador.getFichas());

    }

    @Test(expected = NoSePuedeSubirMenosQueLaSubidaMinimaError.class)
    public void noSePuedeSubirMenosQueLaSubidaMinimaTest(){

        Mesa mesa = new Mesa(20); // apuesta ciega chica

        mesa.agregarJugador("j1");

        crupier.asignarJuego(mesa);

        Jugador jugador = crupier.getJugadorActual();

        // Apuesta minima es de 40.
        jugador.subir(crupier, 20);

    }

    @Test
    public void realizarUnaIgualadaDebitaCorrectamenteTest() {

        Mesa mesa = new Mesa(40); // apuesta ciega chica 40

        mesa.agregarJugador("j1");

        mesa.agregarJugador("j2");

        // En la mesa hay 2 jugadores, se le descuentan las ciegas correspondientes.
        crupier.asignarJuego(mesa);


        // este jugador es la ciega chica y es el que empieza a jugar
        // dado que es el siguiente de la ciega grande.
        Jugador jugador2 = crupier.getJugadorActual();

        // jugador2 iguala las 80 fichas de la ciega grande
        // y sube 320 fichas mas.
        // 400 fichas apostadas.
        int apuesta = 400;
        jugador2.subir(crupier, apuesta);

        // jugador1 es el boton y la ciega grande.
        Jugador jugador1 = crupier.getJugadorActual();

        // // iguala los 400 del jugador 2.
        jugador1.igualar(crupier);

        assertEquals(1100, jugador1.getFichas());
    }

    @Test
    public void primerJugadorEnJugarIgualaLaCiegaGrandeDeLaRondaDebitandoCorrectamenteTest() {

        Mesa mesa = new Mesa(40); // apuesta ciega chica 40

        mesa.agregarJugador("j1");

        mesa.agregarJugador("j2");

        crupier.asignarJuego(mesa);

        // este jugador es la ciega chica y es el que empieza a jugar
        // dado que es el siguiente de la ciega grande.
        Jugador jugador2 = crupier.getJugadorActual();

        // el jugador iguala los 80 de la ciega grande.//
        jugador2.igualar(crupier);

        assertEquals(1420, jugador2.getFichas());

    }



    @Test
    public void jugadorSeRetiraNoModificaSusFichasTest() {

        Mesa mesa = new Mesa(0); // descuenta cero al jugador

        mesa.agregarJugador("j1");

        crupier.asignarJuego(mesa);

        Jugador jugador = crupier.getJugadorActual();

        jugador.retirar(crupier);

        assertEquals(1500, jugador.getFichas());


    }

}
