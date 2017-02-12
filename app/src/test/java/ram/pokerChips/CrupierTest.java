package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.error.NoSePuedePasarSiSeSubeError;
import ram.pokerChips.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;
import ram.pokerChips.modelo.Crupier;
import ram.pokerChips.modelo.Jugador;
import ram.pokerChips.modelo.Mesa;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class CrupierTest {

    private Jugador marcos;
    private Jugador andres;
    private Jugador robert;
    private Jugador charly;

    private Crupier getCrupierCargado(Crupier crupier) {
        Mesa mesa = new Mesa(20);// apuesta ciega chica 20

        mesa.agregarJugador("marcos");
        mesa.agregarJugador("andres");
        mesa.agregarJugador("robert");
        mesa.agregarJugador("charly");

        // Comienza una nueva mano.
        // boton = marcos.
        // ciegaChica = andres.
        // ciegaGrande = robert.
        // arrancaLaMano = charly.
        crupier.iniciarMano(mesa);

        return crupier;
    }

    @Test
    public void alInicioDeUnaManoLaApuestaMinimaEsLaCiegaGrandeTest() {
        Crupier crupier = getCrupierCargado(new Crupier());

        assertEquals(40, crupier.getApuestaMinima());
    }

    @Test
    public void siSeTerminaUnaRondaLaApuestaMinimaEsCeroTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // se termina una ronda.
        crupier.nuevaRonda();

        assertEquals(0, crupier.getApuestaMinima());
    }

    @Test
    public void siSeTerminaUnaRondaElJugadorConLaCiegaChicaArrancaLaNuevaRondaSiContinuaEnLaManoTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // El jugador actual es el que ya termino su turno o lo esta por realizar.
        // En el inicio de cada mano(pre flop) charly va empezar a jugar.
        assertEquals("charly", crupier.getJugadorActual().getNombre());

        // se termina una ronda.
        crupier.nuevaRonda();

        // la ciega chica es andres por la tanto debe arrancar la nueva mano.
        assertEquals("andres", crupier.getJugadorActual().getNombre());

    }

    @Test
    public void siSeTerminaUnaRondaYElJugadorConLaCiegaChicaSeRetiroArrancaSuSiguienteEnLaNuevaRondaDeLaManoTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // Arranca una ronda y el jugador con la ciega chica es turno para jugar.
        crupier.nuevaRonda();

        // Se retira el jugador con la ciega chica de la ronda.
        andres = crupier.getJugadorActual();
        assertEquals(andres.getNombre(), "andres");
        andres.retirar(crupier);

        // Termina otra ronda.
        crupier.nuevaRonda();

        // la ciega chica era andres pero al retirarse en
        // la siguiente ronda de la mano arranca robert.
        assertEquals("robert", crupier.getJugadorActual().getNombre());

    }

    @Test
    public void siUnJugadorApuestaYNoHayNuevoAgresorLaRondaTerminaTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una vuelta entera.
        //charly
        crupier.getJugadorActual().igualar(crupier);

        // marcos
        crupier.getJugadorActual().subir(crupier, 80);

        // andres
        crupier.getJugadorActual().igualar(crupier);

        // robert
        crupier.getJugadorActual().igualar(crupier);

        // charly iguala la apuesta de marcos y termina la ronda.
        crupier.getJugadorActual().igualar(crupier);

        // Si una ronda termino, la apuesta minima tiene que ser cero.
        // Y el jugador actual tiene que ser la ciega chica.
        assertEquals(0, crupier.getApuestaMinima());
        assertEquals("andres", crupier.getJugadorActual().getNombre());

    }


    @Test
    public void laRondaFlopTerminaSiLaApuestaMinimaSeMantieneEnCeroDuranteUnaVueltaDeRonda() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una ronda PreFlop.

        //charly
        crupier.getJugadorActual().igualar(crupier);

        // marcos
        crupier.getJugadorActual().igualar(crupier);

        // andres
        crupier.getJugadorActual().igualar(crupier);

        // robert
        crupier.getJugadorActual().pasar(crupier);

        // Se termina el preFlop
        // Comienza el flop
        // andres ciega chica
        crupier.getJugadorActual().pasar(crupier);

        // robert ciega grande
        crupier.getJugadorActual().pasar(crupier);

        // charly post ciega grande
        crupier.getJugadorActual().pasar(crupier);

        // marcos boton
        crupier.getJugadorActual().pasar(crupier);


        // Si una ronda termino, la apuesta minima tiene que ser cero.
        // Y el jugador actual tiene que ser la ciega chica.
        assertEquals(0, crupier.getApuestaMinima());
        assertEquals("andres", crupier.getJugadorActual().getNombre());

    }

    @Test(expected = NoSePuedePasarSiSeSubeError.class)
    public void noSePuedePasarEnPreFlopSiElJugadorEsElSiguienteAlaCiegaGrandeTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una ronda PreFlop.

        //charly
        crupier.getJugadorActual().pasar(crupier);

    }

    @Test
    public void sePuedePasarEnFlopSiElJugadorEsLaCiegaChicaTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una ronda PreFlop.

        //charly
        crupier.getJugadorActual().igualar(crupier);

        // marcos
        crupier.getJugadorActual().igualar(crupier);

        // andres
        crupier.getJugadorActual().igualar(crupier);

        // robert
        crupier.getJugadorActual().pasar(crupier);

        // Se termina el preFlop
        // Comienza el flop
        // andres ciega chica
        crupier.getJugadorActual().pasar(crupier);

        // el siguiente jugador es robert
        assertEquals(0, crupier.getApuestaMinima());
        assertEquals("robert", crupier.getJugadorActual().getNombre());

    }

    // Todo: este test fue creado bajo la ignorancia
    // Todo: de que un jugador puede hacer all-in.
    // Todo: un vez implementado ese comportamiento lo revisamos de nuevo.
    @Test(expected = NoSePuedeSubirMenosQueLaSubidaMinimaError.class)
    public void noSePuedeSubirEnUnaRondaMenosQueLaSubidaMinimaTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una ronda PreFlop.
        // la ciega grande esta en 40.

        //charly
        crupier.getJugadorActual().igualar(crupier);

        // marcos sube a +80
        crupier.getJugadorActual().subir(crupier, 80);
        assertEquals(80, crupier.getApuestaMinima());

        // andres sube  a +120
        crupier.getJugadorActual().subir(crupier, 120);
        assertEquals(120, crupier.getApuestaMinima());

        // robert sube a +150
        // su apuesta no cubre la subida minima que es de 160 fichas.
        crupier.getJugadorActual().subir(crupier, 150);

    }


    @Test
    public void preFlopNoTerminaSiLaCiegaGrandeApuestaEnSuTurnoTest() {

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una ronda PreFlop.

        //charly
        crupier.getJugadorActual().igualar(crupier);

        // marcos
        crupier.getJugadorActual().igualar(crupier);

        // andres
        crupier.getJugadorActual().igualar(crupier);

        // robert ciega grande
        crupier.getJugadorActual().subir(crupier, 80);


        // el pre flop no termina y charly tiene que jugar.
        assertEquals(80, crupier.getApuestaMinima());
        assertEquals("charly", crupier.getJugadorActual().getNombre());

    }

    @Test
    public void jugadorSeRetiraYelSiguienteEsElAgresorActivoLaRondaTieneQueTerminarTest(){

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una vuelta entera.
        //charly
        crupier.getJugadorActual().igualar(crupier);

        // marcos
        crupier.getJugadorActual().subir(crupier, 80);

        // andres
        crupier.getJugadorActual().igualar(crupier);

        // robert
        crupier.getJugadorActual().igualar(crupier);

        // charly se retira y el proximo en jugar es marcos
        // como es el agresor activo la ronda tiene que terminar.
        crupier.getJugadorActual().retirar(crupier);

        // la ronda tuvo que haber terminado.
        assertEquals(0, crupier.getApuestaMinima());
        assertEquals("andres", crupier.getJugadorActual().getNombre());

    }

    @Test// Todo checkeo del ganador unico harcodeado
    public void siUnJugadorQuedaSoloEnLaManoSeAdjudicaComoGanadorDeLaManoTest(){

        Crupier crupier = getCrupierCargado(new Crupier());

        // Se simula una vuelta entera.
        //charly
        crupier.getJugadorActual().igualar(crupier);
        assertEquals(null, crupier.getGanador());

        // marcos
        crupier.getJugadorActual().subir(crupier, 80);
        assertEquals(null, crupier.getGanador());

        // andres
        crupier.getJugadorActual().retirar(crupier);
        assertEquals(null, crupier.getGanador());

        // robert
        crupier.getJugadorActual().retirar(crupier);
        assertEquals(null, crupier.getGanador());

        // charly se retira y el proximo en jugar es marcos,
        // el deberia ganar la mano
        crupier.getJugadorActual().retirar(crupier);


        // la mano ya tiene un ganador
        assertEquals("marcos", crupier.getGanador().getNombre());

    }


}
