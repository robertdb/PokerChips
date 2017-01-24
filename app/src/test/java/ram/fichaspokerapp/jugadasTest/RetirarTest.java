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

    @Test(expected = NoSePuedePasarSiSeSubeError.class)
    public void pasarConUnaSubidaDeAlgunoDeLaMesaDeJuegoEsUnError(){

        // jugador 1 sube la apuesta.
        Jugada subida = new Subir();

        // jugador 2 se retira.
        Jugada retirada1 = new Retirar(subida);

        //jugador 3 se retira.
        Jugada retirada2 = new Retirar(retirada1);

        //jugador 4 se retira.
        Jugada retirada3 = new Retirar(retirada2);

        //jugador 5 se retira.
        Jugada retirada4 = new Retirar(retirada3);

        // jugador  intenta pasar y no puede ya que hubo una subida previa.
        Jugada jugada = new Pasar(retirada4);

    }



}
