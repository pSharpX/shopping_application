/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dto.ProductoDto;
import pe.edu.cibertec.mapper.ProductoMapper;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.servicio.ProductoServicio;

/**
 *
 * @author Java-LM
 */
@Service
@Transactional(transactionManager = "defaultTransactionManager")
public class ProductoServicioImpl implements ProductoServicio {
    
    @Autowired
    private ProductoRepositorio productoRepositorio;    
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductoDto> obtenerPorCategoria(Long idCategoria) {
        return productoMapper.mapToListOf(productoRepositorio.obtenerPorCategoria(idCategoria));
    }

    @Override
    public List<ProductoDto> obtenerPorCategoriaCriteriaApi(Long idCategoria) {
        return productoMapper.mapToListOf(productoRepositorio.obtenerPorCategoriaCriteriaApi(idCategoria));
    }

    @Override
    public ProductoDto buscar(Long id) {
        return productoMapper.map(productoRepositorio.buscar(id));
    }

    @Override
    public List<ProductoDto> obtenerTodos() {
        return productoMapper.mapToListOf(productoRepositorio.obtenerTodos());
    }

    @Override
    public void crear(ProductoDto producto) {
        productoRepositorio.crear(productoMapper.map(producto));
    }

    @Override
    public void actualizar(ProductoDto producto) {
        productoRepositorio.actualizar(productoMapper.map(producto));
    }

    @Override
    public void eliminar(ProductoDto producto) {
        productoRepositorio.eliminar(productoMapper.map(producto));
    }
    
}
