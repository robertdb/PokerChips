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
        Jugada jugada = new Jugada(pozo, ciegaGrandeApuesta);

        // Lista Con jugadores activos para jugar.
        ListaCircular<String> listaJugadoreActivos = new ListaCircular<String>();
        marcos = new Jugador("marcos", crupier);
        andres = new Jugador("andres", crupier);
        robert = new Jugador("robert", crupier);
        charly = new Jugador("charly", crupier);
        listaJugadoreActivos.add(marcos);
        listaJugadoreActivos.add(andres);
        listaJugadoreActivos.add(robert);
        listaJugadoreActivos.add(charly);

        // Iterador de los jugadores activos.
        IteradorListaCircular iterActivos = new IteradorListaCircular(listaJugadoreActivos, charly);

        // Mesa se crea con el jugador marcos
        Mesa mesa = new Mesa("Ram", marcos);
        mesa.agregarJugador(andres);
        mesa.agregarJugador(robert);
        mesa.agregarJugador(charly);


        // Comienza una nueva mano.
        // boton = marcos.
        // ciegaChica = andres.
        // ciegaGrande = robert.
        // arrancaLaMano = charly.
        crupier.asignarJuego(iterActivos, mesa, jugada);

        return new Mano(pozo, crupier);

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
        charly.igualar(crupier.getJugada());
        marcos.igualar(crupier.getJugada());
        andres.igualar(crupier.getJugada());

        // Cuando la mano recibe a un jugador se considera que este ya jugo.
        // Por lo tanto vamos a suponer que robert paso y no aposto.
        // robert.pasar();


        // Como la apuesta minima no se modifico durante una vuelta entera,
        // el jugador con la ciega grande (robert) no aposto se cambia de ronda.
        assertTrue(mano.cambiarRonda());

    }
}
