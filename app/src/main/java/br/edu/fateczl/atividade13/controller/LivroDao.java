package br.edu.fateczl.atividade13.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.atividade13.model.Livro;

public class LivroDao implements ICRUDDao<Livro> {
    private List<Livro> livros = new ArrayList<>();

    @Override
    public void insert(Livro livro) {
        livros.add(livro);
    }

    @Override
    public void update(Livro livro) {
        int index = livros.indexOf(findOne(livro.getCodigo()));
        if (index >= 0) {
            livros.set(index, livro);
        }
    }

    @Override
    public void delete(Livro livro) {
        livros.remove(livro);
    }

    @Override
    public Livro findOne(int id) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == id) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public List<Livro> findAll() {
        return livros;
    }
}

