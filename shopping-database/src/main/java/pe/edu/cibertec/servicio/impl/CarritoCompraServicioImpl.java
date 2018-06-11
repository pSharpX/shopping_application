/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.cibertec.aplicacion.annotations.BusinessService;
import pe.edu.cibertec.dto.CarritoCompraDto;
import pe.edu.cibertec.mapper.CarritoCompraMapper;
import pe.edu.cibertec.repositorio.CarritoCompraRepositorio;
import pe.edu.cibertec.servicio.CarritoCompraServicio;

import java.util.List;

/**
 *
 * @author Java-LM
 */
@BusinessService
public class CarritoCompraServicioImpl implements CarritoCompraServicio {

    @Autowired
    private CarritoCompraRepositorio carritoRepositorio;
    @Autowired
    private CarritoCompraMapper carritoMapper;

    @Override
    public CarritoCompraDto buscar(Long id) {
        return carritoMapper.map(carritoRepositorio.buscar(id));
    }

    @Override
    public List<CarritoCompraDto> obtenerTodos() {
        return carritoMapper.mapToListOf(carritoRepositorio.obtenerTodos());
    }

    @Override
    public void crear(CarritoCompraDto object) {
        carritoRepositorio.crear(carritoMapper.map(object));
    }

    @Override
    public void actualizar(CarritoCompraDto object) {
        carritoRepositorio.actualizar(carritoMapper.map(object));
    }

    @Override
    public void eliminar(CarritoCompraDto object) {
        carritoRepositorio.eliminar(carritoMapper.map(object));
    }

    @Override
    public List<CarritoCompraDto> buscarPorUsuario(Long idUsuario) {
        return carritoMapper.mapToListOf(carritoRepositorio.buscarPorUsuario(idUsuario));
    }
}
