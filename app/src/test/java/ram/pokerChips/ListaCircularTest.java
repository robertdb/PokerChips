package ram.pokerChips;

import org.junit.Test;

import javax.crypto.IllegalBlockSizeException;

import ram.pokerChips.modelo.linkedList.IteradorListaCircular;
import ram.pokerChips.modelo.linkedList.ListaCircular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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

        assertEquals("andres", lista.next(lista.getFirstElement()));

    }

    @Test
    public void laListaVueleAEmpezarEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertEquals("marcos", lista.next(braian));

    }

    @Test
    public void laCantidadDeElementosEs5EsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertEquals(5, lista.size());

    }

    @Test
    public void siSeBorraAlPrimeroDeLaListaElSiguientePasaASerElSiguienteDelUltimoEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        lista.removeAtFirst();
        // andres pasa a ser el primero de la lista ahora, se elimino a marcos.
        assertEquals("andres", lista.getFirstElement());

    }

    @Test
    public void siSeBorraElUltimoDeLaListaElAnteriorPasaASerUltimoEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        lista.removeAtLast();
        // se elimino a braian ahora charly es ultimo de la lista. Marcos es el primero.
        assertEquals("charly", lista.getLastElement());
        assertEquals("marcos", lista.getFirstElement());

    }

    @Test
    public void borrarUnElementoEspecificoLaListaEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        // se elimino a braian
        assertEquals("braian", lista.removeElement(braian));

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
    public void siguienteDeUnElementoConIteradorEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iterador = new IteradorListaCircular(lista, robert);

        assertEquals(charly, iterador.siguiente());

    }

    @Test
    public void siguienteDelUltimoElementoConIteradorEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iterador = new IteradorListaCircular(lista, lista.getLastElement());

        assertEquals(marcos, iterador.siguiente());

    }

    @Test
    public void siguienteDelPrimerElementoConIteradorEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        IteradorListaCircular iterador = new IteradorListaCircular(lista, lista.getFirstElement());

        assertEquals(andres, iterador.siguiente());

    }

    @Test
    public void siguienteDelUltimoElementoEsCorrecto(){

        ListaCircular lista = getListaConNombres();

        assertEquals(marcos, lista.next(braian));

    }

    @Test(expected = IllegalArgumentException.class)
    public void elementoQueNoSeEncuentraEnLaListaNoTieneSiguienteTest() {

        ListaCircular lista = getListaConNombres();

        String pablo = "pablo";

        lista.next(pablo);
    }

    @Test
    public void listaConUnSoloElementoSuSiguienteEsElMismoEsCorrecto(){

        ListaCircular lista = new ListaCircular();

        lista.add(marcos);

        assertEquals(marcos, lista.next(marcos));

    }

    @Test
    public void listaVaciaEsCorrecto(){

        ListaCircular lista = new ListaCircular();

        assertEquals(0 , lista.size());

    }

    @Test
    public void listaSeClonaConTamanioCorrectoTest() throws IllegalBlockSizeException {

        ListaCircular lista = getListaConNombres();

        ListaCircular listaClonada = lista.cloneList();

        assertEquals(5, listaClonada.size());

    }

    @Test
    public void listaSeClonaConElementosCorrectamenteTest() throws IllegalBlockSizeException {

        ListaCircular lista = getListaConNombres();

        ListaCircular listaClonada = lista.cloneList();

        assertEquals(marcos, listaClonada.getFirstElement());

        assertEquals(andres, listaClonada.next(marcos));

        assertEquals(robert, listaClonada.next(andres));

        assertEquals(charly, listaClonada.next(robert));

        assertEquals(braian, listaClonada.next(charly));

    }

}
