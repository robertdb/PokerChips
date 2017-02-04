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

    private Jugador ciegaGrande;

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

        this.ciegaGrande = mesa.getCiegaGrande();
        
    }

    public void igualar() {

        iterJugadoresActivos.next();

    }

    // Si el jugador actual se retira el actual pasa a ser su siguiente.
    public void retirar() {

        if(iterJugadoresActivos.actual() == ciegaChica)
            ciegaChica = (Jugador) iterJugadoresActivos.seeNext();

        iterJugadoresActivos.removeActual();

    }

    public Jugador getJugadorCiegaGrande() {

        return ciegaGrande;
    }

    public void nuevaRonda() {
        
        jugada.apuestaMinimaNula();
        
        ciegaChicaIniciaNuevaRonda();

    }

    private void ciegaChicaIniciaNuevaRonda() {

        iterJugadoresActivos.moveActual(ciegaChica);

    }

    public int getApuestaMinima() {

        return jugada.getApuestaMinima();

    }

    public Jugada getJugada() {

        return jugada;

    }

    public Jugador getProximoJugador() {

        return (Jugador) iterJugadoresActivos.seeNext();

    }

    public void pasar() {

        iterJugadoresActivos.next();

    }

    public IteradorListaCircular getCandidatos() {

        return null;

    }
}
