/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mapper.impl;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dominio.DetalleCarrito;
import pe.edu.cibertec.dto.DetalleCarritoDto;
import pe.edu.cibertec.mapper.DetalleCarritoMapper;

import java.math.BigDecimal;

/**
 *
 * @author Java-LM
 */
@Component
public class DetalleCarritoMapperDefaultImpl  implements DetalleCarritoMapper {

    @Override
    public DetalleCarritoDto map(DetalleCarrito object) {
        DetalleCarritoDto detalleCarritoDto = new DetalleCarritoDto();
        detalleCarritoDto.setId(object.getId());
        detalleCarritoDto.setProductoId(object.getProducto().getId());
        detalleCarritoDto.setProducto(object.getProducto().getNombre());
        detalleCarritoDto.setCategoria(object.getProducto().getCategoria().getNombre());
        detalleCarritoDto.setCantidad(object.getCantidad());
        detalleCarritoDto.setPrecioUnitario(object.getPrecioUnitario().doubleValue());
        return detalleCarritoDto;
    }

    @Override
    public DetalleCarrito map(DetalleCarritoDto object) {
        DetalleCarrito detalleCarrito = new DetalleCarrito();
        detalleCarrito.setId(object.getId());
        detalleCarrito.setCantidad(object.getCantidad());
        detalleCarrito.setPrecioUnitario(new BigDecimal(object.getPrecioUnitario()));
        return detalleCarrito;
    }
    
}
