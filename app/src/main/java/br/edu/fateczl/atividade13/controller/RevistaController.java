package br.edu.fateczl.atividade13.controller;

import android.content.Context;
import java.util.List;
import br.edu.fateczl.atividade13.Persistence.RevistaDao;
import br.edu.fateczl.atividade13.model.Revista;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public class RevistaController {
    private RevistaDao revistaDao;

    public RevistaController(Context context) {
        revistaDao = new RevistaDao(context);
    }

    public void insertRevista(Revista revista) {
        revistaDao.open();
        revistaDao.insert(revista);
        revistaDao.close();
    }

    public void updateRevista(Revista revista) {
        revistaDao.open();
        revistaDao.update(revista);
        revistaDao.close();
    }

    public void deleteRevista(Revista revista) {
        revistaDao.open();
        revistaDao.delete(revista);
        revistaDao.close();
    }

    public Revista findRevistaById(int id) {
        revistaDao.open();
        Revista revista = revistaDao.findOne(id);
        revistaDao.close();
        return revista;
    }

    public List<Revista> getAllRevistas() {
        revistaDao.open();
        List<Revista> revistas = revistaDao.findAll();
        revistaDao.close();
        return revistas;
    }
}

