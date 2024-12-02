package br.edu.fateczl.atividade13.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.atividade13.Persistence.LivroDao;
import br.edu.fateczl.atividade13.model.Livro;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class LivroController {
    private LivroDao livroDao;

    public LivroController(Context context) {
        livroDao = new LivroDao(context);
    }

    public void inserirLivro(Livro livro) {
        livroDao.open();
        livroDao.insert(livro); // Certifique-se de que o DAO implementa corretamente o método insert
        livroDao.close();
    }

    public void atualizarLivro(Livro livro) {
        livroDao.open();
        livroDao.update(livro);
        livroDao.close();
    }

    public void excluirLivro(Livro livro) {
        livroDao.open();
        livroDao.delete(livro);
        livroDao.close();
    }

    public Livro buscarLivro(int id) {
        livroDao.open();
        Livro livro = livroDao.findOne(id);
        livroDao.close();
        return livro;
    }

    public List<Livro> listarTodos() {
        livroDao.open();
        List<Livro> livros = livroDao.findAll();
        livroDao.close();
        return livros;
    }
}


