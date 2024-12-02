package br.edu.fateczl.atividade13.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.atividade13.Persistence.AluguelDao;
import br.edu.fateczl.atividade13.model.Aluguel;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class AluguelController {
    private AluguelDao aluguelDao;

    public AluguelController(Context context) {
        aluguelDao = new AluguelDao(context);
    }

    public void insertAluguel(Aluguel aluguel) {
        aluguelDao.open();
        aluguelDao.insert(aluguel);
        aluguelDao.close();
    }

    public void updateAluguel(Aluguel aluguel) {
        aluguelDao.open();
        aluguelDao.update(aluguel);
        aluguelDao.close();
    }

    public void deleteAluguel(Aluguel aluguel) {
        aluguelDao.open();
        aluguelDao.delete(aluguel);
        aluguelDao.close();
    }

    public Aluguel findAluguelById(int id) {
        aluguelDao.open();
        Aluguel aluguel = aluguelDao.findOne(id);
        aluguelDao.close();
        return aluguel;
    }

    public List<Aluguel> getAllAlugueis() {
        aluguelDao.open();
        List<Aluguel> alugueis = aluguelDao.findAll();
        aluguelDao.close();
        return alugueis;
    }
}

