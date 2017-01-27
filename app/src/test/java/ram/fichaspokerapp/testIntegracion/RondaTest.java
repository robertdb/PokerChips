package ram.fichaspokerapp.testIntegracion;

import org.junit.*;
import ram.fichaspokerapp.modelo.*;
import ram.fichaspokerapp.modelo.linkedList.*;

/**
 * Created by Samsung on 27/01/2017.
 */

public class RondaTest {

    private Crupier crupier;
    private ListaCircular<Jugador> lista = new ListaCircular<Jugador>();

    @Before

    public void setUp() {


        crupier = new Crupier(new Mesa(null, null));
        Jugador marcos = new Jugador("Marcos",crupier);
        Jugador braian = new Jugador("Braian",crupier);
        Jugador robert = new Jugador("Robert",crupier);
        Jugador andres = new Jugador("Andres",crupier);
        Jugador charly = new Jugador("Charly",crupier);

        lista.add(marcos); //ciega chica
        lista.add(andres); //ciega grande
        lista.add(robert);
        lista.add(charly);
        lista.add(new Jugador("veronica",crupier));
        lista.add(braian);

        IteradorListaCircular iter = new IteradorListaCircular(lista, robert);
        Mesa mesa = new Mesa("RAM", braian);

        crupier.asignarJuego(iter, mesa);




    }
    @Test
    public void actualizarFichasSubidaPrimerJugadorTest() {

        int pozo = 60;
        int apuestaMinima = 40;
        InfoJugada infoJugada = new InfoJugada(pozo, apuestaMinima);
        // antes de que el jugador actue mostramos la vista
        crupier.getJugadorActual().actuar(infoJugada,"subir", 500);


    }
}
