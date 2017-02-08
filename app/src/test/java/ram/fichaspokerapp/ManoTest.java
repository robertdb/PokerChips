package ram.fichaspokerapp;

import org.junit.Ignore;
import org.junit.Test;

import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Jugador;
import ram.fichaspokerapp.modelo.Mano;
import ram.fichaspokerapp.modelo.Mesa;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class ManoTest {

    private Jugador marcos;
    private Jugador andres;
    private Jugador robert;
    private Jugador charly;

    private Mano getManoCargado(Crupier crupier){

        // Pozo vacio.
        Pozo pozo = new Pozo(15000);

        // Jugada inical con apuesta minima de 40.
        int ciegaGrandeApuesta = 40;
        Jugada jugada = new Jugada(ciegaGrandeApuesta);

        // Lista Con jugadores activos para jugar.
        ListaCircular<String> listaJugadoreActivos = new ListaCircular<String>();
        marcos = new Jugador("marcos", 1500);
        andres = new Jugador("andres", 1500);
        robert = new Jugador("robert", 1500);
        charly = new Jugador("charly", 1500);
        listaJugadoreActivos.add(marcos);
        listaJugadoreActivos.add(andres);
        listaJugadoreActivos.add(robert);
        listaJugadoreActivos.add(charly);

        // Iterador de los jugadores activos.
        IteradorListaCircular iterActivos = new IteradorListaCircular(listaJugadoreActivos, charly);

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
        crupier.asignarJuego(mesa);

        return new Mano(crupier);

    }

    @Test
    public void cambiarRondaAlInicioDeLaManoEsFalsoTest(){

        Mano mano = getManoCargado(new Crupier());

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

        assertEquals(560,pozo.getCantidadDeFichasActuales());

    }

    //Todo: creo que este es un test de mano
    @Ignore
    @Test
    public void lasCiegasSeAcreditanEnElPozoCorrectamenteTest() {

    }

}
