package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mano;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class ManoTest {

    @Test
    public void elAgresorEnUnaNuevaManoEsElJugadorConLaCiegaGrandeCorrectoTest(){

        int ciegaGrandeApuesta = 40;

        Pozo pozo = new Pozo(1000);

        Jugada jugada = new Jugada(pozo, ciegaGrandeApuesta);

        Crupier crupier = new Crupier();

        ListaCircular<Jugador> lista = new ListaCircular<Jugador>();
        Jugador ciegaGrande = new Jugador("pepe", crupier);
        Jugador siguienteAlaCiegaGrande = new Jugador("jaimito", crupier);
        lista.add(ciegaGrande);
        lista.add(siguienteAlaCiegaGrande);
        IteradorListaCircular iter = new IteradorListaCircular(lista, ciegaGrande);


        crupier.asignarJuego(iter, new Mesa("--",new Jugador()), jugada);

        Mano mano = new Mano(pozo, crupier);

        assertTrue(mano.cambiarRonda());

    }
}
