package ram.fichaspokerapp.modelo.jugadas;

/**
 * Created by Marcos on 22/01/2017.
 */

public class Pasar extends Jugadas {

    public Pasar () {
    }

    public Pasar(Jugadas jugadasAnterior) {

        this.actuar(jugadasAnterior);

    }

    @Override
    public void pasar() {

    }

    @Override
    public void subir() {


    }

    @Override
    public void igualar() {

    }

    @Override
    public void retirar() {

    }

    @Override
    public void actuar(Jugadas jugadasAnterior) {
        jugadasAnterior.pasar();
    }
}
