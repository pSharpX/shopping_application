/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dto.CategoriaDto;
import pe.edu.cibertec.mapper.CategoriaMapper;
import pe.edu.cibertec.repositorio.CategoriaRepositorio;
import pe.edu.cibertec.servicio.CategoriaServicio;

import java.util.List;

/**
 *
 * @author Java-LM
 */
@Service
@Transactional(transactionManager = "defaultTransactionManager")
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public CategoriaDto buscar(Long id) {
        return categoriaMapper.map(categoriaRepositorio.buscar(id));
    }

    @Override
    public List<CategoriaDto> obtenerTodos() {
        return categoriaMapper.mapToListOf(categoriaRepositorio.obtenerTodos());
    }

    @Override
    public void crear(CategoriaDto object) {
        categoriaRepositorio.crear(categoriaMapper.map(object));
    }

    @Override
    public void actualizar(CategoriaDto object) {
        categoriaRepositorio.actualizar(categoriaMapper.map(object));
    }

    @Override
    public void eliminar(CategoriaDto object) {
        categoriaRepositorio.eliminar(categoriaMapper.map(object));
    }
}
