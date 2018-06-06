/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.dominio.CarritoCompra;
import pe.edu.cibertec.dto.CarritoCompraDto;
import pe.edu.cibertec.mapper.CarritoCompraMapper;
import pe.edu.cibertec.mapper.DetalleCarritoMapper;

/**
 *
 * @author Java-LM
 */
@Component
public class CarritoCompraMapperDefaultImpl  implements CarritoCompraMapper{

    @Autowired
    private DetalleCarritoMapper detalleCarritoMapper;

    @Override
    public CarritoCompraDto map(CarritoCompra object) {
        CarritoCompraDto carritoCompraDto = new CarritoCompraDto();
        carritoCompraDto.setId(object.getId());
        carritoCompraDto.setFechaCreacion(object.getFechaCreacion());
        carritoCompraDto.setFechaCompra(object.getFechaCompra());
        carritoCompraDto.setActivo(object.isActivo());
        carritoCompraDto.setDireccionEnvio(object.getDireccionEnvio());
        carritoCompraDto.setTotal(object.getTotal().doubleValue());
        carritoCompraDto.setUsuario(object.getUsuario().getNombre());
        carritoCompraDto.setDetalleCarrito(detalleCarritoMapper.mapToListOf(object.getDetalleCarrito()));
        return carritoCompraDto;
    }

    @Override
    public CarritoCompra map(CarritoCompraDto object) {
        CarritoCompra carritoCompra = new CarritoCompra();
        return carritoCompra;
    }
    
}
