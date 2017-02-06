package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.PilaDeFichas;
import ram.fichaspokerapp.error.NoHaySuficientesFichasError;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Samsung on 05/02/2017.
 */

public class PilaDeFichasTest {

    @Test
    public void seDebitanCorrectamenteLasFichasTest(){

        PilaDeFichas unaPila = new PilaDeFichas(1500);
        unaPila.debitar(1500);

        assertEquals(0,unaPila.getCantidadDeFichas());

    }

    @Test
    public void seAcreditanCorrectamenteLasFichasTest(){

        PilaDeFichas unaPila = new PilaDeFichas(1500);
        unaPila.acreditar(500);

        assertEquals(2000,unaPila.getCantidadDeFichas());

    }

    @Test
    public void fichasQueSeDebitanVanALasFichasEnJuegoTest(){

        PilaDeFichas unaPila = new PilaDeFichas(800);
        unaPila.debitar(500);
        unaPila.debitar(600);

        assertEquals(200,unaPila.getCantidadDeFichas());

    }

    @Test
    public void siNoHaySuficientesFichasSeDebitaLaCantidadQueHayaTest(){

        PilaDeFichas unaPila = new PilaDeFichas(500);
        unaPila.debitar(400);
        unaPila.debitar(600);

        assertEquals(0,unaPila.getCantidadDeFichas());

    }
}
