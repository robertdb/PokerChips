package ram.fichaspokerapp.modelo;

import javax.crypto.IllegalBlockSizeException;

import ram.fichaspokerapp.error.MesaNoSoportaMasDeDiezJugadoresError;
import ram.fichaspokerapp.error.PartidaNoPuedeComenzarConUnSoloJugadorError;
import ram.fichaspokerapp.error.UnJugadorNoPuedeEstarRepetidoError;
import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;
import ram.fichaspokerapp.modelo.linkedList.ListaCircular;

public class Mesa {

    private final int cantidadMaximaDeJugadores; // le frutee el static porque creo que es atributo de clase, jeje

    private ListaCircular<Jugador> listaDeJugadores;

    private Jugador boton;

    private int cantidadDeFichasIniciales = 1500; // por ahora lo hardcodeo, en el futuro estaria encapsulado en ReglasDePartida o algo asi.

    private int fichasTotales;

    private int apuestaCiegaChica;

    public Mesa(int apuestaCiegaChica) {

        this.apuestaCiegaChica = apuestaCiegaChica;

        this.cantidadMaximaDeJugadores = 10;

        this.listaDeJugadores = new ListaCircular<Jugador>();

    }

    public int cantidadDeJugadoresSentados() {
        return this.listaDeJugadores.size();
    }

    public void agregarJugador(String nombre) {


        if (mesaLlena())
            throw new MesaNoSoportaMasDeDiezJugadoresError();

        Jugador jugador = new Jugador(nombre, cantidadDeFichasIniciales);

        if (jugadorYaEstaEnLaMesa(nombre))
            throw new UnJugadorNoPuedeEstarRepetidoError();

        //// TODO: Hardcodeo de jugador boton.
        if(listaDeJugadores.size() == 0)
            boton = jugador;


        listaDeJugadores.add(jugador);

    }

    private boolean jugadorYaEstaEnLaMesa(String nombre) {

        if(listaDeJugadores.size() == 0)
            return false;

        IteradorListaCircular iterJugadores = new IteradorListaCircular(listaDeJugadores);

        int i = 0;

        while (i < listaDeJugadores.size()) {

            if(((Jugador)iterJugadores.actual()).getNombre() == nombre)
                return true;

            iterJugadores.next();
            i++;
        }

        return false;

    }

    private boolean mesaLlena() {
        return (cantidadMaximaDeJugadores == listaDeJugadores.size());
    }

    public void comenzarJuego() {
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
        return listaDeJugadores.next((Jugador)getBoton());
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

    public ListaCircular getListaClonadaDeActivos() {

        return listaDeJugadores.cloneList();

    }

    public int getApuestaCiegaChica(){
        return apuestaCiegaChica;
    }
}