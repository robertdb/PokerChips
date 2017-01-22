package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.linkedList.CircularLinkedList;
import ram.fichaspokerapp.modelo.linkedList.IterListCircular;

import static org.junit.Assert.assertEquals;

/**
 * Created by Robert on 20/1/17.
 */

public class IterListCircularTest {

    private String marcos = "marcos";
    private String andres = "andres";
    private String robert =  "robert";
    private String charly = "charly";
    private String braian =  "braian";

    private CircularLinkedList getListaConNombres(){

        CircularLinkedList lista = new CircularLinkedList();

        lista.add(marcos);
        lista.add(andres);
        lista.add(robert);
        lista.add(charly);
        lista.add(braian);

        return lista;

    }

    @Test
    public void primerElementoDeLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        IterListCircular iter = new IterListCircular(lista);

        assertEquals("marcos", iter.actual());

    }

    @Test
    public void siguienteDelPrimerElementoDeLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        IterListCircular iter = new IterListCircular(lista);

        assertEquals("andres", iter.next());

    }

    @Test
    public void laListaVuelveAempezarDespuesDelPrimeroCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        IterListCircular iter = new IterListCircular(lista);
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

        CircularLinkedList lista = getListaConNombres();

        IterListCircular iter = new IterListCircular(lista, "robert");
        // luego de robert viene charli.
        assertEquals("charly", iter.next());
    }
    @Test
    public void borrarUnElementoEspecificoLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        IterListCircular iter = new IterListCircular(lista, "robert");

        iter.removeActual();
        // se elimninó a robert
        assertEquals(4, lista.size());

        //quiero hacer algunos chequeos mas, disculpe señor Fontela y muchachos.
        // ahora el actual es charly y el siguiente es braian.
        assertEquals("braian", iter.next());
    }

    @Test
    public void borrandoUnElementoElActualPasaAserElsiguienteDeLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        IterListCircular iter = new IterListCircular(lista, "robert");

        iter.removeActual();
        // se elimninó a robert y el actual ahora es charly
        assertEquals("charly", iter.actual());

    }







}
