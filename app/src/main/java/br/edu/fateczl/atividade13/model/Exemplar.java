package br.edu.fateczl.atividade13.model;

public abstract class Exemplar {
    private int codigo;
    private int qtdPaginas;

    public Exemplar(int codigo, int qtdPaginas) {
        this.codigo = codigo;
        this.qtdPaginas = qtdPaginas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Páginas: " + qtdPaginas;
    }
}

