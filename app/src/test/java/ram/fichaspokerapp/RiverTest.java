package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.error.UltimaRondaTerminadaNoHayProximaError;
import ram.fichaspokerapp.modelo.Jugada;
import ram.fichaspokerapp.modelo.Pozo;
import ram.fichaspokerapp.modelo.River;
import ram.fichaspokerapp.modelo.Ronda;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 2/2/17.
 */

public class RiverTest {


    @Test(expected = UltimaRondaTerminadaNoHayProximaError.class)
    public void UltimaRondaTerminadaNoHayProximaTest(){

        int ciegaGrande = 40;

        Jugada jugada = new Jugada(new Pozo(1000), ciegaGrande);

        Ronda river = new River();

        Ronda ronda = river.rondaTerminada();

    }

}
