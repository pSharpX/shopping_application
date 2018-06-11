/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.cibertec.aplicacion.annotations.BusinessService;
import pe.edu.cibertec.dto.DetalleCarritoDto;
import pe.edu.cibertec.mapper.DetalleCarritoMapper;
import pe.edu.cibertec.repositorio.DetalleCarritoRepositorio;
import pe.edu.cibertec.servicio.DetalleCarritoServicio;

import java.util.List;

/**
 *
 * @author Java-LM
 */
@BusinessService
public class DetalleCarritoServicioImpl implements DetalleCarritoServicio {

    @Autowired
    private DetalleCarritoRepositorio detalleCarritoRepositorio;
    @Autowired
    private DetalleCarritoMapper detalleCarritoMapper;

    @Override
    public DetalleCarritoDto buscar(Long id) {
        return detalleCarritoMapper.map(detalleCarritoRepositorio.buscar(id));
    }

    @Override
    public List<DetalleCarritoDto> obtenerTodos() {
        return detalleCarritoMapper.mapToListOf(detalleCarritoRepositorio.obtenerTodos());
    }

    @Override
    public void crear(DetalleCarritoDto object) {
        detalleCarritoRepositorio.crear(detalleCarritoMapper.map(object));
    }

    @Override
    public void actualizar(DetalleCarritoDto object) {
        detalleCarritoRepositorio.actualizar(detalleCarritoMapper.map(object));
    }

    @Override
    public List<DetalleCarritoDto> buscarPorProducto(Long idProducto) {
        return detalleCarritoMapper.mapToListOf(detalleCarritoRepositorio.buscarPorProducto(idProducto));
    }

    @Override
    public void eliminar(DetalleCarritoDto object) {
        detalleCarritoRepositorio.eliminar(detalleCarritoMapper.map(object));
    }

    @Override
    public List<DetalleCarritoDto> buscarPorCarrito(Long idCarrito) {
        return detalleCarritoMapper.mapToListOf(detalleCarritoRepositorio.buscarPorCarrito(idCarrito));
    }
}
