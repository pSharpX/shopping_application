/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio;

import java.util.List;

/**
 *
 * @author Java-LM
 * @param <T>
 */
public interface ServicioBase<T> {
    T buscar(Long id);
    List<T> obtenerTodos();    
    void crear(T object);
    void actualizar(T object);
    void eliminar(T object);
    default void eliminar(Long id){
        eliminar(buscar(id));
    }
}
