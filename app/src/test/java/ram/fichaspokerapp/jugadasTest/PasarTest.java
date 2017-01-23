package ram.fichaspokerapp.jugadasTest;

import org.junit.Test;

import ram.fichaspokerapp.error.NoSePuedePasarSiSeIgualaError;
import ram.fichaspokerapp.error.NoSePuedePasarSiSeSubeError;
import ram.fichaspokerapp.modelo.jugadas.*;

/**
 * Created by Marcos on 22/01/2017.
 */

public class PasarTest {

    @Test(expected = NoSePuedePasarSiSeSubeError.class)
    public void noSePuedePasarSiHayAgresorTest() {

        Jugada jugadaAnterior = new Subir();
        Jugada jugada = new Pasar(jugadaAnterior);

    }

    @Test(expected = NoSePuedePasarSiSeIgualaError.class)
    public void noSePuedePasarSiSeIgualaTest() {

        Jugada jugadaAnterior = new Igualar();
        Jugada jugada = new Pasar(jugadaAnterior);

    }

    @Test
    public void sePuedePasarSiSePasaTest() {

        Jugada jugadaAnterior = new Pasar();
        Jugada jugada = new Pasar(jugadaAnterior);

    }
}