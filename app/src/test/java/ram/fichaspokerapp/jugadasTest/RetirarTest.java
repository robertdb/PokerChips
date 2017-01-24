package ram.fichaspokerapp.jugadasTest;

import org.junit.Test;

import ram.fichaspokerapp.error.NoSePuedePasarSiSeSubeError;
import ram.fichaspokerapp.modelo.jugadas.Jugada;
import ram.fichaspokerapp.modelo.jugadas.Pasar;
import ram.fichaspokerapp.modelo.jugadas.Retirar;
import ram.fichaspokerapp.modelo.jugadas.Subir;

/**
 * Created by Robert on 23/1/17.
 */

public class RetirarTest {

    @Test(expected = NoSePuedePasarSiSeSubeError.class)
    public void pasarConUnaSubidaEsUnError(){

        // jugador 1 sube la apuesta.
        Jugada subida = new Subir();

        // jugador 2 se retira.
        Jugada retirada = new Retirar(subida);

        // jugador 3 intenta pasar y no puede ya que hubo una subida previa.
        Jugada jugada = new Pasar(retirada);

    }

}
