package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;

public class Jugador {

    private String nombre;

    private PilaDeFichas pilaDeFichas;

    public Jugador() {
    }

    public Jugador(String nombre, int cantidadDeFichasIniciales) {

        this.nombre = nombre;

        this.pilaDeFichas = new PilaDeFichas(cantidadDeFichasIniciales);

    }

    public int getFichas() {
        return pilaDeFichas.getCantidadDeFichas();
    }

    public void acreditarFichas(int fichas) {
        pilaDeFichas.acreditar(fichas);
    }

    public void pasar(CrupierMediador crupier) {

        crupier.pasar();

    }

    public void subir(CrupierMediador crupier, int apuesta) {

        crupier.getJugada().subir(apuesta);

        crupier.subir(this.pilaDeFichas.debitar(apuesta));

    }

    public void igualar(CrupierMediador crupier) {

        Jugada jugada = crupier.getJugada();

        int apuestaMinima = jugada.getApuestaMinima();

//		this.fichasSuficientes(apuestaMinima);

        jugada.igualar();

//		this.apostar(apuestaMinima);

        crupier.igualar(this.pilaDeFichas.debitar(apuestaMinima));
    }

    public void retirar() {

        // Todavia no le avisen al crupier jeje
        //this.crupier.retirar();
    }

    public void apuestaObligatoria(int apuesta) {

        this.pilaDeFichas.debitar(apuesta);

    }

    public String getNombre(){

        return nombre;

    }


}


