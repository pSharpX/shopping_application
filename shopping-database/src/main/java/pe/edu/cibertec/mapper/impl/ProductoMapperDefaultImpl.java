/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mapper.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dto.ProductoDto;
import pe.edu.cibertec.mapper.ProductoMapper;

/**
 *
 * @author Java-LM
 */
@Component
public class ProductoMapperDefaultImpl implements ProductoMapper {

    @Override
    public ProductoDto map(Producto producto) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
        productoDto.setNombre(producto.getNombre());
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setPrecio(producto.getPrecio().doubleValue());
        productoDto.setImagen(producto.getImagen());
        productoDto.setCategoriaId(producto.getCategoria().getId());
        productoDto.setCategoria(producto.getCategoria().getNombre());
        return productoDto;
    }

    @Override
    public Producto map(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(new BigDecimal(productoDto.getPrecio()));
        producto.setImagen(productoDto.getImagen());        
        //producto.setCategoria(productoDto.getCategoria().getNombre());
        return producto;
    }
    
}
