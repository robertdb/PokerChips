package ram.fichaspokerapp.modelo.jugadas;

/**
 * Created by Marcos on 22/01/2017.
 */

public abstract class Jugadas {

    public abstract void pasar();

    public abstract void subir();

    public abstract void igualar();

    public abstract void retirar();

    public abstract void actuar(Jugadas jugadasAnterior);

}
