package br.edu.fateczl.atividade13.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.atividade13.Persistence.AlunoDao;
import br.edu.fateczl.atividade13.model.Aluno;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class AlunoController {
    private AlunoDao alunoDao;

    public AlunoController(Context context) {
        alunoDao = new AlunoDao(context);
    }

    public void insertAluno(Aluno aluno) {
        alunoDao.open();
        alunoDao.insert(aluno);
        alunoDao.close();
    }

    public void updateAluno(Aluno aluno) {
        alunoDao.open();
        alunoDao.update(aluno);
        alunoDao.close();
    }

    public void deleteAluno(Aluno aluno) {
        alunoDao.open();
        alunoDao.delete(aluno);
        alunoDao.close();
    }

    public Aluno findAlunoById(int id) {
        alunoDao.open();
        Aluno aluno = alunoDao.findOne(id);
        alunoDao.close();
        return aluno;
    }

    public List<Aluno> getAllAlunos() {
        alunoDao.open();
        List<Aluno> alunos = alunoDao.findAll();
        alunoDao.close();
        return alunos;
    }
}

