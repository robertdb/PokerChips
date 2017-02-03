package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.Crupier;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Mano;
import ram.fichaspokerapp.modelo.Pozo;

import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class ManoTest {

    @Test
    public void elAgresorEnUnaNuevaManoEsElJugadorConLaCiegaGrandeCorrectoTest(){

        int ciegaGrande = 40;

        Pozo pozo = new Pozo(1000);

        Jugada jugada = new Jugada(pozo, ciegaGrande);

        Crupier crupier = new Crupier();

        Mano mano = new Mano(pozo, crupier);

        assertTrue(mano.cambiarRonda());

    }
}
