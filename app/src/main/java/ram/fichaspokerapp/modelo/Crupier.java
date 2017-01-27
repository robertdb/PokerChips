package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Crupier {

    private IteradorListaCircular jugadoresActivos;

    private Mesa mesa;

    public Crupier(Mesa mesa) {

        this.mesa = mesa;

    }

    public Jugador getJugadorActual(){
        return (Jugador) this.jugadoresActivos.actual();
    }

    public void subir(InfoJugada infoJugada) {

        this.mesa.actualizarVista(infoJugada);

    }

    public void asignarJuego(IteradorListaCircular iter, Mesa mesa) {

        this.jugadoresActivos = iter;

        this.mesa = mesa;

    }
}
