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

    @Test
    public void siSeTerminaUnaRondaLaApuestaMinimaEsCeroTest() {

        Crupier  crupier = getCrupierCargado(new Crupier());

        // Al inicio de una mano la apuestaMinima es la apuesta de la ciega grande.
        assertEquals(40, crupier.getApuestaMinima());

        // se termina una ronda.
        crupier.nuevaRonda();

        assertEquals(0, crupier.getApuestaMinima());

    }

    private Crupier getCrupierCargado(Crupier crupier){

        // Pozo vacio.
        Pozo pozo = new Pozo(15000);

        // Jugada inical.
        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(pozo, ciegaGrandeApuesta);

        // Lista Con jugadores activos para jugar.
        ListaCircular<String> lista = new ListaCircular<String>();
        Jugador marcos = new Jugador("marcos", crupier);
        Jugador andres = new Jugador("andres", crupier);
        Jugador robert = new Jugador("robert", crupier);
        Jugador charly = new Jugador("charly", crupier);
        lista.add(marcos);
        lista.add(andres);
        lista.add(robert);
        lista.add(charly);

        // Iterador de los jugadores activos.
        IteradorListaCircular iterActivos = new IteradorListaCircular(lista);

        // Mesa
        Mesa mesa = new Mesa("Ram", marcos);

        // Comienza una nueva mano.
        crupier.asignarJuego(iterActivos, mesa, jugada);

        return crupier;

    }
}
