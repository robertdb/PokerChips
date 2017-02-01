package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Crupier {

    private IteradorListaCircular jugadoresActivos;

    private Mesa mesa;

    public Crupier() {

    }

    public Jugador getJugadorActual(){
        return (Jugador) this.jugadoresActivos.actual();
    }

    public void subir(Jugada jugada) {

        this.mesa.actualizarVista(jugada);

    }

    public void asignarJuego(IteradorListaCircular iter, Mesa mesa) {

        this.jugadoresActivos = iter;

        this.mesa = mesa;

    }

    public void igualar(Jugada jugada) {
    }

    public void retirar() {
    }
}
