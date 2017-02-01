package ram.fichaspokerapp.modelo.jugadas;

/**
 * Created by Marcos on 22/01/2017.
 */

public class Retirar extends Jugadas {

    private Jugadas jugadas;

    public Retirar(Jugadas anterior) {

        this.jugadas = anterior;

    }

    @Override
    public void pasar() {

        jugadas.pasar();

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

    }
}
