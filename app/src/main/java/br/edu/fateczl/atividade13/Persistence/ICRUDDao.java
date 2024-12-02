package br.edu.fateczl.atividade13.Persistence;

import java.util.List;
/*@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043*/

public interface ICRUDDao<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    T findOne(int id);
    List<T> findAll();
}

