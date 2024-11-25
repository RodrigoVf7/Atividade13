package br.edu.fateczl.atividade13.model;

public class Revista extends Exemplar {
    private String ISSN;

    public Revista(int codigo, int qtdPaginas, String ISSN) {
        super(codigo, qtdPaginas);
        this.ISSN = ISSN;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    @Override
    public String toString() {
        return super.toString() + ", ISSN: " + ISSN;
    }
}

