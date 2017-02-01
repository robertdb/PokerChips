package ram.fichaspokerapp;

import org.junit.*;

import ram.fichaspokerapp.error.NoSePuedeIgualarSiNoHuboSubidaError;
import ram.fichaspokerapp.error.NoSePuedePasarSiSeSubeError;
import ram.fichaspokerapp.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;
import ram.fichaspokerapp.modelo.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by Samsung on 01/02/2017.
 */

public class JugadaTest {

    @Test(expected = NoSePuedePasarSiSeSubeError.class )
    public void noSePuedePasarDespuesDeLaCiegaGrandeTest(){
        // 10 jugadores con 1500 fichas c/u y ciegaChica = 20
        Pozo pozo = new Pozo(15000,20);
        int apuestaIgualar = 40;
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(pozo,apuestaIgualar,ciegaGrande);

        jugada.pasar();

    }

    @Test
    public void seActualizaElPozoLuegoDeSubidaTest(){

        // 10 jugadores con 1500 fichas c/u y ciegaChica = 20
        Pozo pozo = new Pozo(15000,20);
        int apuestaIgualar = 40;
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(pozo,apuestaIgualar,ciegaGrande);
        int apuesta = 500;

        jugada.subir(apuesta);

        assertEquals(560,pozo.getCantidadDeFichasActuales());

    }

    @Test
    public void seActualizaLaApuestaMinimaLuegoDeSubidaTest(){

        // 10 jugadores con 1500 fichas c/u y ciegaChica = 20
        Pozo pozo = new Pozo(15000,20);
        int apuestaIgualar = 40;
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(pozo,apuestaIgualar,ciegaGrande);
        int apuesta = 500;

        jugada.subir(apuesta);

        assertEquals(500,jugada.getApuestaMinima());
    }

    @Test(expected = NoSePuedeSubirMenosQueLaSubidaMinimaError.class )
    public void noSePuedeSubirMenosQueLaSubidaMinimaTest(){

        // 10 jugadores con 1500 fichas c/u y ciegaChica = 20
        Pozo pozo = new Pozo(15000,20);
        int apuestaMinima = 100;
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(pozo,apuestaMinima,ciegaGrande);
        int apuesta = 30;

        jugada.subir(apuesta);
    }

    @Test(expected = NoSePuedeIgualarSiNoHuboSubidaError.class)
    public void noSePuedeIgualarSiNoHuboSubidaTest(){

        // 10 jugadores con 1500 fichas c/u y ciegaChica = 20
        Pozo pozo = new Pozo(15000,20);
        int apuestaMinima = 0;
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(pozo,apuestaMinima,ciegaGrande);

        jugada.igualar();
    }
}
