package br.edu.fateczl.atividade13.model;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class Exemplar {
    private int codigo;
    private String nome;
    private int qtdPaginas;

    public Exemplar(int codigo, String nome, int qtdPaginas) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdPaginas = qtdPaginas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", QtPaginas: " + qtdPaginas;
    }
}


