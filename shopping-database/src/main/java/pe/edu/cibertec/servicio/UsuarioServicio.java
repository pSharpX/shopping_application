/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio;

import pe.edu.cibertec.dto.UsuarioDto;

/**
 *
 * @author Java-LM
 */
public interface UsuarioServicio extends ServicioBase<UsuarioDto> {    
    UsuarioDto buscar(String username, String contraseña);
    default boolean existe(String username, String contraseña){
        return (buscar(username, contraseña) != null);
    }
}
