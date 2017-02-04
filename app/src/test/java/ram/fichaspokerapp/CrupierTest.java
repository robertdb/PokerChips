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

    @Test
    public void siSeTerminaUnaRondaYElJugadorConlaCiegaChicaSeRetiroArrancaSuSiguienteEnLaNuevaRondaDeLaManoTest() {

        Crupier  crupier = getCrupierCargado(new Crupier());

        // Arranca una ronda y el jugador con la ciega chica es turno para jugar.
        crupier.nuevaRonda();

        // Se retira el jugador con la ciega chica de la ronda.
        crupier.retirar();

        // Termina otra ronda.
        crupier.nuevaRonda();

        // la ciega chica era andres pero al retirarse en
        // la siguiente ronda de la mano arranca robert.
        assertEquals(robert, crupier.getJugadorActual());

    }

    @Test
    public void siUnjugadorApuestaYnoHayNuevoAgresorLaRontaTerminaTest(){

        Crupier  crupier = getCrupierCargado(new Crupier());

        crupier.crearMano();

        // Se simula una vuelta entera.
        //charly
        crupier.getJugadorActual().igualar(crupier.getJugada());

        // marcos
        crupier.getJugadorActual().subir(crupier.getJugada(), 80);

        // andres
        crupier.getJugadorActual().igualar(crupier.getJugada());

        // robert
        crupier.getJugadorActual().igualar(crupier.getJugada());

        // charly iguala la apuesta de marcos y termina la ronda.
        crupier.getJugadorActual().igualar(crupier.getJugada());

        // Si una ronda termino la apuesta minima tiene que ser cero.
        // Y el jugador actual tiene que la ciega chica.
        assertEquals(0, crupier.getApuestaMinima());
        assertEquals(andres, crupier.getJugadorActual());
        
    }




}
