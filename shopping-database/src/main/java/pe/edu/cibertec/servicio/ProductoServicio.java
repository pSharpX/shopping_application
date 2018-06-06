/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio;

import java.util.List;
import pe.edu.cibertec.dto.ProductoDto;

/**
 *
 * @author Java-LM
 */
public interface ProductoServicio extends ServicioBase<ProductoDto> {    
    List<ProductoDto> obtenerPorCategoria(Long idCategoria);
    List<ProductoDto> obtenerPorCategoriaCriteriaApi(Long idCategoria);
}
