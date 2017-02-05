package ram.fichaspokerapp;

import org.junit.Ignore;
import org.junit.Test;

import ram.fichaspokerapp.modelo.AgresorPasivo;
import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Flop;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.PreFlop;
import ram.fichaspokerapp.modelo.Ronda;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class PreFlopTest {

    @Test
    public void laRondaPreFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){


        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", crupier);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", crupier);

        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        crupier.asignarJuego(iter, new Mesa("--",new Jugador()), jugada);

        Ronda preFlop = new PreFlop(crupier);

        preFlop.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaPreFlopTerminaYarrancaElFlopEsCorrectoTest(){

        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", crupier);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", crupier);

        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        crupier.asignarJuego(iter, new Mesa("--",new Jugador()), jugada);

        Ronda preFlop = new PreFlop(crupier);

        Ronda ronda = preFlop.rondaTerminada();

        assertTrue(ronda instanceof Flop);

    }

    @Test
    public void cambiarRondaSiLaCiegaGrandeNoApostoEnSuTurnoEsTrueTest(){

        Crupier crupier = new Crupier();

        Jugador boton = new Jugador();
        Jugador ciegaChica = new Jugador();
        Jugador ciegaGrande = new Jugador();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        lista.add(boton);
        lista.add(ciegaChica);
        lista.add(ciegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);


        Mesa mesa = new Mesa("Ram", boton);
        mesa.agregarJugador(ciegaChica);
        mesa.agregarJugador(ciegaGrande);

        crupier.asignarJuego(iter, mesa, jugada);

        Ronda preFlop = new PreFlop(crupier);

        // Estado del juego: el jugador con la ciega grande ya jugo
        // y la apuestaMinima se mantuvo con el valor de la ciegaGrande
        // en este caso termina la ronda.
        assertEquals(ciegaGrande, crupier.getJugadorActual());
        assertEquals(ciegaGrande, crupier.getJugadorCiegaGrande());
        assertTrue(preFlop.cambiarRonda(new AgresorPasivo(), new Jugador()));

    }

    @Ignore// necesita correciones o eliminarlo.
    @Test
    public void rondaNoCambiaSiLaCiegaGrandeApuestaEnSuTurnoTest(){


        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", crupier);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", crupier);

        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        crupier.asignarJuego(iter, new Mesa("--",new Jugador()), jugada);

        crupier.crearMano();

        Ronda preFlop = new PreFlop(crupier);


        int apuestaDelJugadorConLaCiegaGrande = 80;
        crupier.getJugadorActual().subir(jugada, apuestaDelJugadorConLaCiegaGrande);

        // Estado del juego: el jugador con la ciega grande ya jugo
        // y la apuestaMinima nose mantuvo con el valor de la ciegaGrande
        // en este caso termina la ronda.
        assertEquals(ciegaGrande, crupier.getJugadorActual());

        assertFalse(preFlop.cambiarRonda(new AgresorPasivo(), new Jugador()));

    }


    @Test
    public void determinarGanadorEsCorrectoTest(){

    Crupier crupier = new Crupier();

    ListaCircular<Jugador> lista = new ListaCircular<Jugador>();

    lista.add(new Jugador("pepe", crupier));

    IteradorListaCircular iter = new IteradorListaCircular(lista);

    Pozo pozo = new Pozo(1000);

    crupier.asignarJuego(iter, new Mesa(" ", new Jugador()), new Jugada(20));

    Ronda preFlop = new PreFlop(crupier);

    assertTrue(preFlop.comprobarGanador(new IteradorListaCircular(lista), pozo));

    }

}
