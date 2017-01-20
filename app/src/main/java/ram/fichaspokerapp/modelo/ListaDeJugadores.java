package ram.fichaspokerapp.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import ram.fichaspokerapp.error.MesaNoSoportaMasDeDiezJugadoresError;
import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoError;

/**
 * Created by Marcos on 19/01/2017.
 */
public class ListaDeJugadores {

    private List<Jugador> listaDeJugadores;

    public ListaDeJugadores() {

        this.listaDeJugadores = new ArrayList<>();

    }

    public void add(Jugador jugador) {

        if (!this.existe(jugador) && !this.mesaLlena()) {
            listaDeJugadores.add(jugador);
        }

    }

    private boolean mesaLlena() {

        boolean mesaLlena = (this.listaDeJugadores.size() >= 10);

        if (mesaLlena) {
            throw new MesaNoSoportaMasDeDiezJugadoresError();
        }
        return false; // siempre es falso
    }

    private boolean existe(Jugador jugador) {

        boolean existe = listaDeJugadores.contains(jugador);

        if (existe) {
            throw new UnJugadorNoPuedeEstarRepetidoError();
        }
        return false; // siempre es falso
    }



    public int size() {
        return this.listaDeJugadores.size();
    }

    public Jugador get(int index) {
        return this.listaDeJugadores.get(index);
    }

    public Jugador siguiente(Jugador unJugador) {

        Iterator<Jugador> iter = listaDeJugadores.iterator();

        if (iter.hasNext()) {
            return (Jugador)iter.next();
        }   else {
                return (listaDeJugadores.get(0));
        }

    }

    public List<Jugador> getListaDeJugadores(){
        return this.listaDeJugadores;
    }
}