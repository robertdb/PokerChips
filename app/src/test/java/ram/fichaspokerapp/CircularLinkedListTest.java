package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.linkedList.CircularLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Robert on 20/1/17.
 */

public class CircularLinkedListTest {

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

        assertEquals("marcos", lista.getFirstElement());

    }

    @Test
    public void ultimoElementoDeLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        assertEquals("braian", lista.getLastElement());

    }

    @Test
    public void siguienteElementoDeLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        assertEquals("andres", lista.getFirst().next.data);

    }

    @Test
    public void laListaVueleAempezarEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        assertEquals("marcos", lista.getLast().next.data);

    }

    @Test
    public void laCantidadDeElementosEs5EsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        assertEquals(5, lista.size());

    }

    @Test
    public void siSeBorraAlPrimeroDeLaListaElSiguientePasaASerElSiguienteDelUlitmoEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        lista.removeAtFirst();
        // andres pasa a ser el primero de la lista ahora, se elimino a marcos.
        assertEquals("andres", lista.getLast().next.data);

    }

    @Test
    public void siSeBorraElUltimoeDeLaListaElAnteriorPasaASerUlitmoEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        lista.removeAtLast();
        // se elimninó a braian ahora charly es ultimo de la lista. Marcos es el primero.
        assertEquals("charly", lista.getLastElement());
        assertEquals("marcos", lista.getLast().next.data);

    }

    @Test
    public void borrarUnElementoEspecificoLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        // se elimninó a braian
        assertEquals("braian", lista.removeAt(4));

    }

    @Test
    public void elementoExisteEnLaListaEsCorrecto(){

        CircularLinkedList lista = getListaConNombres();

        assertTrue(lista.contains("marcos"));


    }










}
