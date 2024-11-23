package entities;

import entities.ENUM.GeneroFilme;

public class ReceptorGenero {
    private GeneroFilme genero;

    public ReceptorGenero(GeneroFilme genero) {
        this.genero = genero;
    }

    public GeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
    }
}
