package pe.edu.cibertec.repositorio;

import java.util.List;

/**
 * Created by CHRISTIAN on 22/05/2018.
 */
public interface RepositorioBase<T> {
    T buscar(Long id);
    List<T> obtenerTodos();
    void crear(T object);
    void actualizar(T object);
    void eliminar(T object);
    default void eliminar(Long id){
        eliminar(buscar(id));
    }
}
