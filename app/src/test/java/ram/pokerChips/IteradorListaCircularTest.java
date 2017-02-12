package ram.pokerChips;

import org.junit.Test;

import ram.pokerChips.modelo.linkedList.IteradorListaCircular;
import ram.pokerChips.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;


/**
 * Created by Robert on 20/1/17.
 */

public class IteradorListaCircularTest {

    private String marcos = "marcos";
    private String andres = "andres";
    private String robert =  "robert";
    private String charly = "charly";
    private String braian =  "braian";

    private ListaCircular getListaConNombres(){

        ListaCircular<String> lista = new ListaCircular<>();

        lista.add(marcos);
        lista.add(andres);
        lista.add(robert);
        lista.add(charly);
        lista.add(braian);

        return lista;

    }

    @Test
    public void primerElementoDeLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista);

        assertEquals("marcos", iter.actual());

    }

    @Test
    public void siguienteDelPrimerElementoDeLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista);

        assertEquals("andres", iter.siguiente());

    }

    @Test
    public void laListaVuelveAEmpezarDespuesDelPrimeroCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista);
        iter.siguiente();
        iter.siguiente();
        iter.siguiente();
        iter.siguiente();
        // aca esta parado en braian.
        iter.siguiente();

        assertEquals("marcos", iter.actual());
    }

    @Test
    public void seCreaAlIteradorDesdeUnElementoParticularCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "robert");
        // luego de robert viene charli.
        assertEquals("charly", iter.siguiente());
    }
    @Test
    public void borrarUnElementoEspecificoLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "robert");

        iter.removerActual();
        // se elimino a robert
        assertEquals(4, lista.size());

        // si se elimina el elemento,
        // el actual pasa a ser el anterior.
        assertEquals("andres", iter.actual());
    }

    @Test
    public void borrandoElPrimerElementoElActualPasaASerElAnteriorDeLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "marcos");

        iter.removerActual();
        // se elimino a marcos y el actual ahora es braian
        assertEquals("braian", iter.actual());

    }

    @Test
    public void borrandoElUltimoElementoElActualPasaASerElAnteriorDeLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "braian");

        iter.removerActual();
        // se elimino a braian y el actual ahora es charly
        assertEquals("charly", iter.actual());

    }


    @Test(expected = UnsupportedOperationException.class)
    public void listaConUnSoloElementoNoTieneActualErrorEsCorrecto(){


        ListaCircular<String> nueva = new ListaCircular<>();

        nueva.add(marcos);

        IteradorListaCircular iter = new IteradorListaCircular(nueva);

        iter.removerActual();

        // se elimino a marcos y ya no hay actual
        iter.actual();
    }

    @Test
    public void listaConDosElementoNoTieneActualErrorEsCorrecto(){


        ListaCircular<String> nueva = new ListaCircular<>();

        nueva.add(marcos);
        nueva.add(andres);

        IteradorListaCircular iter = new IteradorListaCircular(nueva, marcos);

        iter.removerActual();

        // se elimino a marcos y ya no hay actual
        // se elimino a braian y el actual ahora es charly
        assertEquals(andres, iter.actual());
    }



    @Test
    public void moverElIteradorAunElementoParticularEsCorrectoTest(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "robert");

        assertEquals(robert, iter.actual());

        iter.moverActual(marcos);

        assertEquals(marcos, iter.actual());

    }

    @Test
    public void verAlSiguienteAlActualSinModificarAlActualEsCorrectoTest(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, marcos);

        assertEquals(andres, iter.verSiguiente());

    }

    @Test
    public void laCantidadDeElementosSiSeBorraUnoEsCorrectoTest(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, marcos);

        iter.removerActual();

        assertEquals(4, iter.listaSize());

    }

}
