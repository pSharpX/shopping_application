/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio;

import pe.edu.cibertec.dto.DetalleCarritoDto;

import java.util.List;

/**
 *
 * @author Java-LM
 */
public interface DetalleCarritoServicio extends ServicioBase<DetalleCarritoDto> {
    List<DetalleCarritoDto> buscarPorProducto(Long idProducto);
    List<DetalleCarritoDto> buscarPorCarrito(Long idCarrito);
}
