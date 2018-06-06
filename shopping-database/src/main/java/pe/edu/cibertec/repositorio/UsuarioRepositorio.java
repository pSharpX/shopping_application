/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.repositorio;

import pe.edu.cibertec.dominio.Usuario;

/**
 *
 * @author Java-LM
 */
public interface UsuarioRepositorio extends RepositorioBase<Usuario> {
    Usuario buscar(String username, String contraseña);
}
