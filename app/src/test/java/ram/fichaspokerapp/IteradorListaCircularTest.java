package ram.fichaspokerapp;

import org.junit.Test;

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

    private ram.fichaspokerapp.modelo.linkedList.ListaCircular getListaConNombres(){

        ram.fichaspokerapp.modelo.linkedList.ListaCircular lista = new ram.fichaspokerapp.modelo.linkedList.ListaCircular();

        lista.add(marcos);
        lista.add(andres);
        lista.add(robert);
        lista.add(charly);
        lista.add(braian);

        return lista;

    }

    @Test
    public void primerElementoDeLaListaEsCorrecto(){

        ram.fichaspokerapp.modelo.linkedList.ListaCircular lista = getListaConNombres();

        ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular iter = new ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular(lista);

        assertEquals("marcos", iter.actual());

    }

    @Test
    public void siguienteDelPrimerElementoDeLaListaEsCorrecto(){

        ram.fichaspokerapp.modelo.linkedList.ListaCircular lista = getListaConNombres();

        ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular iter = new ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular(lista);

        assertEquals("andres", iter.next());

    }

    @Test
    public void laListaVuelveAempezarDespuesDelPrimeroCorrecto(){

        ram.fichaspokerapp.modelo.linkedList.ListaCircular lista = getListaConNombres();

        ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular iter = new ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular(lista);
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

        ram.fichaspokerapp.modelo.linkedList.ListaCircular lista = getListaConNombres();

        ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular iter = new ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular(lista, "robert");
        // luego de robert viene charli.
        assertEquals("charly", iter.next());
    }
    @Test
    public void borrarUnElementoEspecificoLaListaEsCorrecto(){

        ram.fichaspokerapp.modelo.linkedList.ListaCircular lista = getListaConNombres();

        ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular iter = new ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular(lista, "robert");

        iter.removeActual();
        // se elimninó a robert
        assertEquals(4, lista.size());

        //quiero hacer algunos chequeos mas, disculpe señor Fontela y muchachos.
        // ahora el actual es charly y el siguiente es braian.
        assertEquals("braian", iter.next());
    }

    @Test
    public void borrandoUnElementoElActualPasaAserElsiguienteDeLaListaEsCorrecto(){

        ram.fichaspokerapp.modelo.linkedList.ListaCircular lista = getListaConNombres();

        ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular iter = new ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular(lista, "robert");

        iter.removeActual();
        // se elimninó a robert y el actual ahora es charly
        assertEquals("charly", iter.actual());

    }







}
