package ram.fichaspokerapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;


/**
 * Created by Robert on 20/1/17.
 */

public class ListaCircularTest {

    private String marcos = "marcos";
    private String andres = "andres";
    private String robert =  "robert";
    private String charly = "charly";
    private String braian =  "braian";

    private ListaCircular getListaConNombres(){

        ListaCircular lista = new ListaCircular();

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

        assertEquals("marcos", lista.getFirstElement());

    }

    @Test
    public void ultimoElementoDeLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertEquals("braian", lista.getLastElement());

    }

    @Test
    public void siguienteElementoDeLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertEquals("andres", lista.getFirst().next.data);

    }

    @Test
    public void laListaVueleAempezarEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertEquals("marcos", lista.getLast().next.data);

    }

    @Test
    public void laCantidadDeElementosEs5EsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertEquals(5, lista.size());

    }

    @Test
    public void siSeBorraAlPrimeroDeLaListaElSiguientePasaASerElSiguienteDelUlitmoEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        lista.removeAtFirst();
        // andres pasa a ser el primero de la lista ahora, se elimino a marcos.
        assertEquals("andres", lista.getLast().next.data);

    }

    @Test
    public void siSeBorraElUltimoeDeLaListaElAnteriorPasaASerUlitmoEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        lista.removeAtLast();
        // se elimninó a braian ahora charly es ultimo de la lista. Marcos es el primero.
        assertEquals("charly", lista.getLastElement());
        assertEquals("marcos", lista.getLast().next.data);

    }

    @Test
    public void borrarUnElementoEspecificoLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        // se elimninó a braian
        assertEquals("braian", lista.removeAt(4));

    }

    @Test
    public void elementoExisteEnLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertTrue(lista.contains(marcos));

    }

    @Test
    public void elementoNoExisteEnLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        String pablo = "pablo";

        assertFalse(lista.contains(pablo));

    }

    @Test
    public void siguienteDeUnElementoEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iterador = new IteradorListaCircular(lista, marcos);

        assertEquals(andres, iterador.next());

    }












}
