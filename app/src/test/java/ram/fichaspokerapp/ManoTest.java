package ram.fichaspokerapp;

import org.junit.Ignore;
import org.junit.Test;

import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mano;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class ManoTest {

    private Jugador marcos;
    private Jugador andres;
    private Jugador robert;
    private Jugador charly;

    private Mano getManoCargado(Crupier crupier){

        // Pozo vacio.
        Pozo pozo = new Pozo(15000);

        // Jugada inical con apuesta minima de 40.
        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        // Lista Con jugadores activos para jugar.
        ListaCircular<String> listaJugadoreActivos = new ListaCircular<String>();
        marcos = new Jugador("marcos", 1500);
        andres = new Jugador("andres", 1500);
        robert = new Jugador("robert", 1500);
        charly = new Jugador("charly", 1500);
        listaJugadoreActivos.add(marcos);
        listaJugadoreActivos.add(andres);
        listaJugadoreActivos.add(robert);
        listaJugadoreActivos.add(charly);

        // Iterador de los jugadores activos.
        IteradorListaCircular iterActivos = new IteradorListaCircular(listaJugadoreActivos, charly);

        // Mesa se crea con el jugador marcos
        Mesa mesa = new Mesa();
        mesa.agregarJugador("marcos");
        mesa.agregarJugador("andres");
        mesa.agregarJugador("robert");
        mesa.agregarJugador("charly");


        // Comienza una nueva mano.
        // boton = marcos.
        // ciegaChica = andres.
        // ciegaGrande = robert.
        // arrancaLaMano = charly.
        crupier.asignarJuego(mesa);

        return new Mano(crupier);

    }

    @Test
    public void cambiarRondaAlInicioDeLaManoEsFalsoTest(){

        Mano mano = getManoCargado(new Crupier());

        assertFalse(mano.cambiarRonda());

    }

    @Ignore // La mano se crea en crupier. Este test puede que quede obsoleto.
    @Test
    public void cambiarRondaAlInicioSiNoHayApuestasQueSuperanLaMinimaEnLaPrimerVueltaTest(){

        Crupier crupier = new Crupier();

        Mano mano = getManoCargado(crupier);

        // la ronda la empieza charly
        charly.igualar(crupier);
        marcos.igualar(crupier);
        andres.igualar(crupier);

        // Cuando la mano recibe a un jugador se considera que este ya jugo.
        // Por lo tanto vamos a suponer que robert paso y no aposto.
        // robert.pasar();


        // Como la apuesta minima no se modifico durante una vuelta entera,
        // el jugador con la ciega grande (robert) no aposto se cambia de ronda.
        assertTrue(mano.cambiarRonda());

    }
    @Ignore
    @Test
    public void seActualizaElPozoLuegoDeSubidaTest(){

        // 10 jugadores con 1500 fichas c/u y ciegaChica = 20
        Pozo pozo = new Pozo(15000,20);
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(ciegaGrande);
        int apuesta = 500;

        jugada.subir(apuesta);

        assertEquals(560,pozo.getCantidadDeFichasActuales());

    }
    /*
    //Todo: creo que este es un test de mano
    @Ignore
    @Test
    public void lasCiegasSeAcreditanEnElPozoCorrectamenteTest() {

        Jugador jugador3 = new Jugador();
        Jugador ciegaChica;
        Jugador ciegaGrande;

        mesa.agregarJugador("j2");
        mesa.agregarJugador("j3");
        mesa.comenzarPartida();
        ciegaChica = mesa.getCiegaChica();
        ciegaGrande = mesa.getCiegaGrande();
        ciegaChica.apuestaObligatoria(10);
        ciegaGrande.apuestaObligatoria(20);
//        assertEquals(30, mesa.getPozo());

    }
    */
}
