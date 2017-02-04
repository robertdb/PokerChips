package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Crupier {

    private IteradorListaCircular jugadoresActivos;

    private Mesa mesa;

    private Jugada jugada;

    public Crupier() {

    }

    public Jugador getJugadorActual(){
        return (Jugador) this.jugadoresActivos.actual();
    }

    public void subir(Jugada jugada) {

        this.mesa.actualizarVista(jugada);

    }

    public void asignarJuego(IteradorListaCircular iter, Mesa mesa, Jugada jugada) {

        this.jugadoresActivos = iter;

        this.mesa = mesa;

        this.jugada = jugada;
        
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
        
        ciegaChicainiciaRonda();
    }

    private void ciegaChicainiciaRonda() {
    }

    public int getApuestaMinima() {

        return jugada.getApuestaMinima();

    }
}
