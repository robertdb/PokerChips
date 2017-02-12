package ram.pokerChips.modelo;

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

        crupier.subir(apuesta);

    }

    public void igualar(CrupierMediador crupier) {

        crupier.igualar();

    }

    public void retirar(CrupierMediador crupier) {

        crupier.retirar();

    }

    public void apuestaObligatoria(int apuesta) {

        this.pilaDeFichas.debitar(apuesta);

    }

    public String getNombre(){

        return nombre;

    }


    public void debitarFichas(int apuesta) {

        this.pilaDeFichas.debitar(apuesta);

    }

    public int getFichasEnJuego() {

        return pilaDeFichas.getFichasEnJuego();

    }

    public boolean estaEnAllIn() {

        return pilaDeFichas.getCantidadDeFichas() == 0;

    }
}


