package ram.fichaspokerapp.modelo;

/**
 * Created by Robert on 4/2/17.
 */

public interface CrupierMediador {

    public void subir(int apuesta);

    public void igualar(int debitar);

    public void retirar();

    public void pasar();

}
