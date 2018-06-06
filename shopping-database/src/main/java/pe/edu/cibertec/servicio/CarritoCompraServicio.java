/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio;

import pe.edu.cibertec.dto.CarritoCompraDto;
import pe.edu.cibertec.dto.UsuarioDto;

import java.util.List;

/**
 *
 * @author Java-LM
 */
public interface CarritoCompraServicio extends ServicioBase<CarritoCompraDto> {
    List<CarritoCompraDto> buscarPorUsuario(Long idUsuario);
}
