package ram.fichaspokerapp.modelo;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Samsung on 20/01/2017.
 */

public class IteradorJugadores implements Iterator<Jugador> {
    private int cursor;
    private List<Jugador> lista;

    public IteradorJugadores(List<Jugador> listaDeJugadores, int pos ) {
        lista = listaDeJugadores;
        cursor = pos;
    }

    public IteradorJugadores(List<Jugador> listaDeJugadores) {
        lista = listaDeJugadores;
        cursor = 0;
    }

    public boolean hasNext(){

        if ( cursor < (lista.size()-1)){
            return true;

        }else{
            return false;
        }
    }
    public Jugador next() {
        if (!this.hasNext()){
            cursor = 0;
            return lista.get(cursor);
        }else{
            cursor++;
            return lista.get(cursor);
        }
    }

    public void remove(){

    }
}
