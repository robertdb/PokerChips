package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Crupier {

    private IteradorListaCircular jugadoresActivos;

    private Mesa mesa;
    
    // se crea una jugada falopa, todavia no se sabe donde se va a crear
    // pero es seguro que crupier la tiene que conocer.
    private Jugada jugada;
    
    

    public Crupier() {

        this.jugada = new Jugada(new Pozo(15000), 40);
        
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
