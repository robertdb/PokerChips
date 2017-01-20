package ram.fichaspokerapp;

import org.junit.Test;
import org.junit.Assert;

import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.ListaDeJugadores;

import static org.junit.Assert.assertEquals;

/**
 * Created by Samsung on 20/01/2017.
 */

public class ListaDeJugadoresTest {

    @Test
    public void pasaAlSiguienteJugadorNoUltimoTest() {

        ListaDeJugadores lista = new ListaDeJugadores();
        Jugador jugador3 = new Jugador("Marcos");
        Jugador jugador4 = new Jugador("Robert");
        Jugador jugador5 = new Jugador("Braian");
        Jugador jugador6 = new Jugador("Andres");
        Jugador jugador7 = new Jugador("Pablo Repetto");

        lista.add(jugador3);
        lista.add(jugador4);
        lista.add(jugador5);
        lista.add(jugador6);
        lista.add(jugador7);

        //Jugador jugadorPosicion1 = lista.getListaDeJugadores().get(1);
        //Jugador jugadorPosicion2 = jugadorPosicion1.si
       assertEquals("Robert", lista.get(1).getNombre());





    }


}
