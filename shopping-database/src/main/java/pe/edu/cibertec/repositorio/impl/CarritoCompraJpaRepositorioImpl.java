/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.repositorio.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dominio.CarritoCompra;
import pe.edu.cibertec.repositorio.CarritoCompraRepositorio;

/**
 *
 * @author Java-LM
 */
@Repository
public class CarritoCompraJpaRepositorioImpl implements CarritoCompraRepositorio{

    @PersistenceContext(unitName = "defaultPersistenceUnit")
    private EntityManager em;

    private static final String SELECT_CARRITO_POR_USUARIO = 
            "SELECT c FROM CarritoCompra c WHERE c.usuario.id = :idUsuario ORDER BY c.fechaCompra DESC";

    @Override
    public List<CarritoCompra> buscarPorUsuario(Long idUsuario) {
        TypedQuery<CarritoCompra> query = this.em
                .createQuery(SELECT_CARRITO_POR_USUARIO, CarritoCompra.class)
                .setParameter("idUsuario", idUsuario);
        return query.getResultList();
    }

    @Override
    public CarritoCompra buscar(Long id) {
        return null;
    }

    @Override
    public List<CarritoCompra> obtenerTodos() {
        return null;
    }

    @Override
    public void crear(CarritoCompra object) {

    }

    @Override
    public void actualizar(CarritoCompra object) {

    }

    @Override
    public void eliminar(CarritoCompra object) {

    }
}
