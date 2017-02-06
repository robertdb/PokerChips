package ram.fichaspokerapp.modelo;

import java.util.List;

import ram.fichaspokerapp.error.MesaNoSoportaMasDeDiezJugadoresError;
import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;
import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoError;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

import static android.os.Build.VERSION_CODES.M;

public class Mesa {

    private final static int cantidadMaximaDeJugadores = 10; // le frutee el static porque es atributo de clase, jeje
    private Crupier crupier;
    private ListaCircular<Jugador> listaDeJugadores;
    private Jugador boton;
    private int cantidadDeFichasIniciales = 1500; // por ahora lo hardcodeo, en el futuro estaria encapsulado en ReglasDePartida o algo asi.
    private int fichasTotales;

    public Mesa() {
        this.listaDeJugadores = new ListaCircular<Jugador>();
        this.crupier = new Crupier();
    }

    public int cantidadDeJugadoresSentados() {
        return this.listaDeJugadores.size();
    }

    public void agregarJugador(String nombre) {

        if (mesaLlena())
            throw new MesaNoSoportaMasDeDiezJugadoresError();

        Jugador jugador = new Jugador(nombre, crupier, cantidadDeFichasIniciales);

        if (listaDeJugadores.contains(jugador))
            throw new UnJugadorNoPuedeEstarRepetidoError();

        listaDeJugadores.add(jugador);

    }

    private boolean mesaLlena() {
        return (cantidadMaximaDeJugadores == listaDeJugadores.size());
    }

    public void comenzarPartida() {
        // Todo determinar el boton y las ciegas.
        if (this.listaDeJugadores.size() == 1) {
            throw new PartidaNoPuedeComenzarConUnSoloJugadorError();
        } else {
            // Comienza la partida.
            this.fichasTotales = listaDeJugadores.size() * this.cantidadDeFichasIniciales;
//            boton = sortearBoton();
        }

    }

//    private Jugador sortearBoton() {
//        // TODO: 06/02/2017
//    }

    public Jugador getBoton() {
        return boton;
    }

    public Jugador getCiegaChica() {
        return listaDeJugadores.next(getBoton());
    }

    public Jugador getCiegaGrande() {
        return listaDeJugadores.next(getCiegaChica());
    }

    public void actualizarVista(Jugada jugada) {
    }

    public int getFichasTotales() {
        return fichasTotales;
    }

    public ListaCircular<Jugador> getListaDeJugadores() {
        return listaDeJugadores;
    }
//  No se si esto esta bien, ya que por ahora solo lo estoy usando para un test
    public Crupier getCrupier() {
        return crupier;
    }
}