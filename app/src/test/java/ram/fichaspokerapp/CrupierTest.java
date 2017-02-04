package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 22/01/2017.
 */

public class CrupierTest {

    private Jugador marcos;
    private Jugador andres;
    private Jugador robert;
    private Jugador charly;

    private Crupier getCrupierCargado(Crupier crupier){

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

        return crupier;

    }

    @Test
    public void siSeTerminaUnaRondaLaApuestaMinimaEsCeroTest() {

        Crupier  crupier = getCrupierCargado(new Crupier());

        // Al inicio de una mano la apuestaMinima es la apuesta de la ciega grande.
        assertEquals(40, crupier.getApuestaMinima());

        // se termina una ronda.
        crupier.nuevaRonda();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void siSeTerminaUnaRondaElJugadorConlaCiegaChicaArrancaLaNuevaRondaSiContinuaEnLaManoTest() {

        Crupier  crupier = getCrupierCargado(new Crupier());

        // El jugador actual es el que ya termino su turno o lo esta por realizar.
        // En el inicio de cada mano(pre flop) charly va empezar a jugar.
        assertEquals(charly, crupier.getJugadorActual());

        // se termina una ronda.
        crupier.nuevaRonda();

        // la ciega chica es andres por la tanto debe arrancar la nueva mano.
        assertEquals(andres, crupier.getJugadorActual());

    }


}
