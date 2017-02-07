package ram.fichaspokerapp;

import org.junit.Test;


import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.River;
import ram.fichaspokerapp.modelo.Ronda;
import ram.fichaspokerapp.modelo.Turn;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class TurnTest {

    @Test
    public void laRondaFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){

        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", 1500);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", 1500);

        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        crupier.asignarJuego(new Mesa());

        Ronda turn = new Turn(crupier);

        turn.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaTurnTerminaYarrancaElRiverEsCorrectoTest(){

        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", 1500);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", 1500);

        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        crupier.asignarJuego(new Mesa());

        Ronda turn = new Turn(crupier);

        Ronda ronda = turn.rondaTerminada();

        assertTrue(ronda instanceof River);

    }

}
