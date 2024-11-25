package br.edu.fateczl.atividade13.controller;

import java.util.List;

public interface ICRUDDao<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    T findOne(int id);
    List<T> findAll();
}

