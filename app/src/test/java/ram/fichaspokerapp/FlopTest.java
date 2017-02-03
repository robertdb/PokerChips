package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Flop;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.Ronda;
import ram.fichaspokerapp.modelo.Turn;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class FlopTest {

    @Test
    public void laRondaFlopTerminaYlaApuestaMinimaVuelveACeroEsCorrectoTest(){


        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", crupier);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", crupier);

        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrandeApuesta);

        crupier.asignarJuego(iter, new Mesa("--",new Jugador()), jugada);


        Ronda flop = new Flop(crupier);

        flop.rondaTerminada();

        assertEquals(0, crupier.getApuestaMinima());

    }

    @Test
    public void laRondaFlopTerminaYarrancaElTurnEsCorrectoTest(){


        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", crupier);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", crupier);

        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);

        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);

        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrandeApuesta);

        crupier.asignarJuego(iter, new Mesa("--",new Jugador()), jugada);

        Ronda flop = new Flop(crupier);

        Ronda ronda = flop.rondaTerminada();

        assertTrue(ronda instanceof Turn);

    }
}
