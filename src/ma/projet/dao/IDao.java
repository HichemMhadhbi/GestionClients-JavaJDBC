/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.dao;

import java.util.List;

/**
 *
 * @author MSI
 */
public interface IDao<T> {
    boolean create(T o);
    boolean delete(int id);
    boolean update(int id, T o);
    T findById(int id);
    List<T> findAll();
}
