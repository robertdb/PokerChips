package ram.pokerChips.modelo;

/**
 * Created by Marcos on 09/02/2017.
 */

public class NivelDeCiegas {
    private int ciegaChica;
    private int ciegaGrande;
    private int ante;
    private int minutosParaSiguienteNivel;
    private int numeroDeNivelDeCiegas;

    public NivelDeCiegas(int numeroDeNivelDeCiegas, int ciegaChica, int ciegaGrande, int ante, int minutosParaSiguienteNivel) {
        this.numeroDeNivelDeCiegas = numeroDeNivelDeCiegas;
        this.ciegaChica = ciegaChica;
        this.ciegaGrande = ciegaGrande;
        this.ante = ante;
        this.minutosParaSiguienteNivel = minutosParaSiguienteNivel;
    }
    // TODO: timer
    public int getMinutosParaSiguienteNivel() {
        return minutosParaSiguienteNivel;
    }
    // TODO: ante
    public int getAnte() {
        return ante;
    }

    public int getCiegaGrande() {
        return ciegaGrande;
    }

    public int getCiegaChica() {
        return ciegaChica;
    }

    public int getNivelDeCiegas() {
        return numeroDeNivelDeCiegas;
    }
}
