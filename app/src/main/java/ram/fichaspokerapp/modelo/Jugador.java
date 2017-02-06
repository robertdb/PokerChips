package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.JugadorNoPuedeApostarMasFichasQueSuPilaError;

public class Jugador {

    private String nombre;
    private PilaDeFichas pilaDeFichas;


    private CrupierMediador crupier;

    public Jugador() {
    }

    public Jugador(String nombre, CrupierMediador crupier, int cantidadDeFichasIniciales) {

        this.nombre = nombre;
        this.crupier = crupier;
        this.pilaDeFichas = new PilaDeFichas(cantidadDeFichasIniciales);

    }

    public int getFichas() {
        return pilaDeFichas.getCantidadDeFichas();
    }

    public void acreditarFichas(int fichas) {
        pilaDeFichas.acreditar(fichas);
    }

    public void pasar() {
        crupier.pasar();
    }

    public void subir(Jugada jugada, int apuesta) {

        jugada.subir(apuesta);

        this.crupier.subir(this.pilaDeFichas.debitar(apuesta));

    }

    public void igualar(Jugada jugada) {

        int apuestaMinima = jugada.getApuestaMinima();

//		this.fichasSuficientes(apuestaMinima);

        jugada.igualar();

//		this.apostar(apuestaMinima);

        this.crupier.igualar(this.pilaDeFichas.debitar(apuestaMinima));
    }

    public void retirar() {

        // Todavia no le avisen al crupier jeje
        //this.crupier.retirar();
    }

    public void apuestaObligatoria(int apuesta) {

        this.pilaDeFichas.debitar(apuesta);

    }


}


