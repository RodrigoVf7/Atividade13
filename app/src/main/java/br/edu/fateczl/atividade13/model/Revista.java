package br.edu.fateczl.atividade13.model;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class Revista extends Exemplar {
    private String nome;    // Nome da revista
    private String isbn;    // ISBN da revista
    private int edicao;     // Edição da revista

    public Revista(int codigo, String nome, int qtdPaginas, String isbn, int edicao) {
        super(codigo, nome, qtdPaginas);  // Chama o construtor da classe Exemplar
        this.nome = nome;   // Armazena o nome da revista
        this.isbn = isbn;   // Armazena o ISBN da revista
        this.edicao = edicao; // Armazena a edição da revista
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nome: " + nome + ", ISBN: " + isbn + ", Edição: " + edicao;
    }
}




