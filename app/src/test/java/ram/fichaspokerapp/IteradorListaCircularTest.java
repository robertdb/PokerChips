package ram.fichaspokerapp;

import org.junit.Test;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

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

        ListaCircular<String> lista = new ListaCircular<String>();

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

        assertEquals("andres", iter.next());

    }

    @Test
    public void laListaVuelveAempezarDespuesDelPrimeroCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista);
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        // aca esta parado en braian.
        iter.next();

        assertEquals("marcos", iter.actual());
    }

    @Test
    public void seCreaAliteradorDesdeUnElementoParticularCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "robert");
        // luego de robert viene charli.
        assertEquals("charly", iter.next());
    }
    @Test
    public void borrarUnElementoEspecificoLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "robert");

        iter.removeActual();
        // se elimninó a robert
        assertEquals(4, lista.size());

        //quiero hacer algunos chequeos mas, disculpe señor Fontela y muchachos.
        // ahora el actual es charly y el siguiente es braian.
        assertEquals("braian", iter.next());
    }

    @Test
    public void borrandoUnElementoElActualPasaAserElsiguienteDeLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iter = new IteradorListaCircular(lista, "robert");

        iter.removeActual();
        // se elimninó a robert y el actual ahora es charly
        assertEquals("charly", iter.actual());

    }
}