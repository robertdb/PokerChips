package ram.pokerChips;

import org.junit.*;

import ram.pokerChips.error.NoSePuedeIgualarSiNoHuboSubidaError;
import ram.pokerChips.error.NoSePuedePasarSiSeSubeError;
import ram.pokerChips.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;
import ram.pokerChips.modelo.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by Samsung on 01/02/2017.
 */

public class JugadaTest {

    @Test(expected = NoSePuedePasarSiSeSubeError.class )
    public void noSePuedePasarDespuesDeLaCiegaGrandeTest(){

        int ciegaGrande = 40;

        Jugada jugada = new Jugada(ciegaGrande);

        int fichasEnJuego = 0;

        jugada.pasar(fichasEnJuego);

    }

    @Test
    public void seActualizaLaApuestaMinimaLuegoDeSubidaTest(){


        int ciegaGrande = 40;
        Jugada jugada = new Jugada(ciegaGrande);
        int apuesta = 500;

        jugada.subir(apuesta);

        assertEquals(500,jugada.getApuestaMinima());
    }

    @Test(expected = NoSePuedeSubirMenosQueLaSubidaMinimaError.class )
    public void noSePuedeSubirMenosQueLaSubidaMinimaTest(){


        int apuestaMinima = 100;
        int ciegaGrande = 40;
        Jugada jugada = new Jugada(ciegaGrande);
        jugada.subir(apuestaMinima);

        int intentoApuesta = 30;

        jugada.subir(intentoApuesta);

    }

    @Test(expected = NoSePuedeIgualarSiNoHuboSubidaError.class)
    public void noSePuedeIgualarSiNoHuboSubidaTest(){

        int ciegaGrande = 40;
        Jugada jugada = new Jugada(ciegaGrande);

        jugada.apuestaMinimaNula();

        jugada.igualar();
    }
}
