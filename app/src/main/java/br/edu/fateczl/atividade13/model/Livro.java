package br.edu.fateczl.atividade13.model;

public class Livro extends Exemplar {
    private String ISBN;
    private int edicao;

    public Livro(int codigo, int qtdPaginas, String ISBN, int edicao) {
        super(codigo, qtdPaginas);
        this.ISBN = ISBN;
        this.edicao = edicao;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return super.toString() + ", ISBN: " + ISBN + ", Edição: " + edicao;
    }
}

