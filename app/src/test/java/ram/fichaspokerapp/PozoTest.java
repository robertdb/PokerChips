package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.error.PozoDesbordadoPorFichasError;
import ram.fichaspokerapp.modelo.Pozo;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert on 27/1/17.
 */

public class PozoTest {

    @Test
    public void seIngresanFichaEnElPozoCorrectamenteTest(){

        // Es un pozo limitado en cantidad de fichas.
        int cantidadMaximaDeFichas = 15000;

        Pozo pozo = new Pozo(cantidadMaximaDeFichas);

        pozo.agregarFichas(60);

        assertEquals(60, pozo.getCantidadDeFichasActuales());

    }

    @Test
    public void elPozoSeReiniciaConCeroFichasEsCorrectoTest(){

        // Es un pozo limitado en cantidad de fichas.
        int cantidadMaximaDeFichas = 15000;

        Pozo pozo = new Pozo(cantidadMaximaDeFichas);

        pozo.agregarFichas(1000);

        pozo.reiniciar();

        assertEquals(0, pozo.getCantidadDeFichasActuales());

    }

    @Test(expected = PozoDesbordadoPorFichasError.class)
    public void seAgreganFichasQueSuperanElLimiteDelPozoTest(){

        int cantidadMaximaDeFichas = 15000;

        Pozo pozo = new Pozo(cantidadMaximaDeFichas);

        pozo.agregarFichas(15001);

    }

    @Test
    public void pozoSecreaConApuestasObligatoriasTest(){

        int cantidadMaximaDeFichas = 15000;

        int cantidadCiegaChica = 20;

        Pozo pozo = new Pozo(cantidadMaximaDeFichas, cantidadCiegaChica);

        // El pozo se creo con la suma de la ciega chica y la grande.
        assertEquals(60, pozo.getCantidadDeFichasActuales());

    }

}
