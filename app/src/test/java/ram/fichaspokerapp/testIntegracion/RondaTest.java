package ram.fichaspokerapp.testIntegracion;

import org.junit.*;
import ram.fichaspokerapp.modelo.*;
import ram.fichaspokerapp.modelo.linkedList.*;

/**
 * Created by Samsung on 27/01/2017.
 */

public class RondaTest {

    private Crupier crupier;
    private Jugada jugada;
    private ListaCircular<Jugador> lista = new ListaCircular<Jugador>();

    @Before

    public void setUp() {

        crupier = new Crupier();

        //admin y jugador.
        Jugador braian = new Jugador("Braian",crupier);

        Mesa mesa = new Mesa("RAM", braian);

        lista.add(new Jugador("Marcos",crupier)); // ciega chica.
        lista.add(new Jugador("Robert",crupier)); // ciega grande.
        lista.add(braian);                        // arranca este jugador.
        lista.add(new Jugador("Andres",crupier));
        lista.add(new Jugador("veronica",crupier));
        lista.add(new Jugador("Charly",crupier));

        IteradorListaCircular iter = new IteradorListaCircular(lista, braian);

        int ciegaGrande = 40;
        jugada = new Jugada(ciegaGrande);

        crupier.asignarJuego(iter,mesa, jugada);

        crupier.crearMano();

    }

    @Ignore
    @Test
    public void actualizarFichasSubidaPrimerJugadorTest() {

        // antes de que el jugador actue mostramos la vista
       // crupier.getJugadorActual().actuar(jugada,"subir", 500);

    }
}
