/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.servicio.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.cibertec.aplicacion.annotations.BusinessService;
import pe.edu.cibertec.dto.UsuarioDto;
import pe.edu.cibertec.mapper.UsuarioMapper;
import pe.edu.cibertec.repositorio.UsuarioRepositorio;
import pe.edu.cibertec.servicio.UsuarioServicio;

/**
 *
 * @author Java-LM
 */
@BusinessService
public class UsuarioServicioImpl implements UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;    
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto buscar(String username, String contraseña) {
        return usuarioMapper.map(usuarioRepositorio.buscar(username, contraseña));
    }

    @Override
    public UsuarioDto buscar(Long id) {
        return usuarioMapper.map(usuarioRepositorio.buscar(id));
    }

    @Override
    public List<UsuarioDto> obtenerTodos() {
        return usuarioMapper.mapToListOf(usuarioRepositorio.obtenerTodos());
    }

    @Override
    public void crear(UsuarioDto object) {
        usuarioRepositorio.crear(usuarioMapper.map(object));
    }

    @Override
    public void actualizar(UsuarioDto object) {
        usuarioRepositorio.actualizar(usuarioMapper.map(object));
    }

    @Override
    public void eliminar(UsuarioDto object) {
        usuarioRepositorio.eliminar(usuarioMapper.map(object));
    }
}
