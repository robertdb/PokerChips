package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.modelo.EstructuraDeCiegas;
import ram.pokerChips.modelo.NivelDeCiegas;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcos on 09/02/2017.
 */

public class EstructuraDeCiegasTest {

    @Test
    public void estructuraDeCiegasEmpiezaEnElNivelUnoTest() {
        EstructuraDeCiegas unaEstructuraDeCiegas = new EstructuraDeCiegas();
        NivelDeCiegas unNivelDeCiegas;

        unNivelDeCiegas = unaEstructuraDeCiegas.getNivelDeCiegasActual();
        assertEquals(1, unNivelDeCiegas.getNivelDeCiegas());
    }

    @Test
    public void estructuraDeCiegasAvanzaDeAUnoTest() {
        EstructuraDeCiegas unaEstructuraDeCiegas = new EstructuraDeCiegas();
        NivelDeCiegas unNivelDeCiegas;

        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas();
        unNivelDeCiegas = unaEstructuraDeCiegas.getNivelDeCiegasActual();
        assertEquals(2, unNivelDeCiegas.getNivelDeCiegas());
    }

    @Test
    public void laCiegaGrandeEsElDobleDeLaCiegaChicaTest() {
        EstructuraDeCiegas unaEstructuraDeCiegas = new EstructuraDeCiegas();
        NivelDeCiegas unNivelDeCiegas;
        int ciegaChica;
        int ciegaGrande;

        unNivelDeCiegas = unaEstructuraDeCiegas.getNivelDeCiegasActual();
        ciegaChica = unNivelDeCiegas.getCiegaChica();
        ciegaGrande = unNivelDeCiegas.getCiegaGrande();
        assertEquals(ciegaGrande, ciegaChica * 2);
    }

    @Test
    public void avanzarNivelDeCiegasEnElUltimoNivelMantieneElUltimoNivelTest() {
        EstructuraDeCiegas unaEstructuraDeCiegas = new EstructuraDeCiegas();
        NivelDeCiegas unNivelDeCiegas;

        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 2
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 3
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 4
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 5
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 6
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 7
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 8
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 9
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 10
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 11
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 12
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 13
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 14
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 15
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 16
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 17
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 18
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 19
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 20
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 21
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 22
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 23
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 24

        unNivelDeCiegas = unaEstructuraDeCiegas.getNivelDeCiegasActual();
        assertEquals(24, unNivelDeCiegas.getNivelDeCiegas());

        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 25

        unNivelDeCiegas = unaEstructuraDeCiegas.getNivelDeCiegasActual();
        assertEquals(25, unNivelDeCiegas.getNivelDeCiegas());

        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 25

        unNivelDeCiegas = unaEstructuraDeCiegas.getNivelDeCiegasActual();
        assertEquals(25, unNivelDeCiegas.getNivelDeCiegas());
        unaEstructuraDeCiegas.avanzarDeNivelDeCiegas(); // 25

        unNivelDeCiegas = unaEstructuraDeCiegas.getNivelDeCiegasActual();
        assertEquals(25, unNivelDeCiegas.getNivelDeCiegas());
    }
}
