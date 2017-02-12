package ram.pokerChips;

import org.junit.Ignore;
import org.junit.Test;

import ram.pokerChips.modelo.Crupier;
import ram.pokerChips.modelo.Jugada;
import ram.pokerChips.modelo.Jugador;
import ram.pokerChips.modelo.Mano;
import ram.pokerChips.modelo.Mesa;
import ram.pokerChips.modelo.Pozo;
import ram.pokerChips.modelo.linkedList.IteradorListaCircular;
import ram.pokerChips.modelo.linkedList.ListaCircular;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Robert on 2/2/17.
 */

public class ManoTest {

    private Jugador marcos;
    private Jugador andres;
    private Jugador robert;
    private Jugador charly;

    private Mano getManoCargada(Crupier crupier){

        // Pozo vacio.
        Pozo pozo = new Pozo(15000);

        // Jugada inicial con apuesta minima de 40.
        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        // Lista Con jugadores activos para jugar.
        ListaCircular<String> listaJugadorActivos = new ListaCircular<>();
        marcos = new Jugador("marcos", 1500);
        andres = new Jugador("andres", 1500);
        robert = new Jugador("robert", 1500);
        charly = new Jugador("charly", 1500);
        listaJugadorActivos.add(marcos);
        listaJugadorActivos.add(andres);
        listaJugadorActivos.add(robert);
        listaJugadorActivos.add(charly);

        // Iterador de los jugadores activos.
        IteradorListaCircular iterActivos = new IteradorListaCircular(listaJugadorActivos, charly);

        // Mesa se crea con el jugador marcos
        Mesa mesa = new Mesa(20); //apuesta ciega chica 20
        mesa.agregarJugador("marcos");
        mesa.agregarJugador("andres");
        mesa.agregarJugador("robert");
        mesa.agregarJugador("charly");


        // Comienza una nueva mano.
        // boton = marcos.
        // ciegaChica = andres.
        // ciegaGrande = robert.
        // arrancaLaMano = charly.
        crupier.iniciarMano(mesa);

        return new Mano(crupier);

    }

    @Test
    public void cambiarRondaAlInicioDeLaManoEsFalsoTest(){

        Mano mano = getManoCargada(new Crupier());

        assertFalse(mano.cambiarRonda());

    }


    @Ignore
    @Test
    public void seActualizaElPozoLuegoDeSubidaTest(){

        // 10 jugadores con 1500 fichas c/u y ciegaChica = 20
        Pozo pozo = new Pozo(15000,20);
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(ciegaGrande);
        int apuesta = 500;

        jugada.subir(apuesta);

        assertEquals(560,pozo.getCantidadDeFichas());

    }

    @Ignore
    @Test
    public void lasApuestasSeAcreditanEnElPozoCorrectamenteTest() {
        int apuesta = 50;
        Mano mano = new Mano(new Crupier());

        mano.acumularAlPozo(apuesta);
        assertEquals(50, mano.getFichasEnElPozo());
    }
}
