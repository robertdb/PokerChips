package ram.pokerChips.testIntegracion;

import org.junit.*;
import ram.pokerChips.modelo.*;
import ram.pokerChips.modelo.LinkedList.*;
import ram.pokerChips.modelo.linkedList.ListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */

public class JugarTest {

    private Crupier crupier;
    private Jugada jugada;
    private ListaCircular<Jugador> lista = new ListaCircular<>();

    @Before

    public void setUp() {

        crupier = new Crupier();

        //admin y jugador.
        Jugador braian = new Jugador("Braian", 1500);

        Mesa mesa = new Mesa(20); // apuesta ciega chica 20

        lista.add(new Jugador("Marcos", 1500)); // ciega chica.
        lista.add(new Jugador("Robert", 1500)); // ciega grande.
        lista.add(braian);                        // arranca este jugador.
        lista.add(new Jugador("Andres", 1500));
        lista.add(new Jugador("veronica", 1500));
        lista.add(new Jugador("Charly", 1500));

        int ciegaGrande = 40;
        jugada = new Jugada(ciegaGrande);

        crupier.iniciarMano(mesa);

    }

}
