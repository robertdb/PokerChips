package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Crupier {

    private IteradorListaCircular iterJugadoresActivos;

    private Mesa mesa;

    private Jugada jugada;

    private Jugador ciegaChica;

    public Crupier() {

    }

    public Jugador getJugadorActual(){
        return (Jugador) this.iterJugadoresActivos.actual();
    }

    public void subir(Jugada jugada) {

        this.mesa.actualizarVista(jugada);

    }

    public void asignarJuego(IteradorListaCircular iter, Mesa mesa, Jugada jugada) {

        this.iterJugadoresActivos = iter;

        this.mesa = mesa;

        this.jugada = jugada;

        this.ciegaChica = mesa.getCiegaChica();
        
    }

    public void igualar(Jugada jugada) {
    }

    public void retirar() {
    }

    public Jugador getJugadorCiegaGrande() {

        return null;
    }

    public void nuevaRonda() {
        
        jugada.apuestaMinimaNula();
        
        ciegaChicaIniciaNuevaRonda();

    }

    private void ciegaChicaIniciaNuevaRonda() {

        iterJugadoresActivos.moverActual(ciegaChica);

    }

    public int getApuestaMinima() {

        return jugada.getApuestaMinima();

    }

    public Jugada getJugada() {

        return jugada;

    }
}
