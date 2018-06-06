/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mapper.impl;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dominio.Categoria;
import pe.edu.cibertec.dto.CategoriaDto;
import pe.edu.cibertec.mapper.CategoriaMapper;

/**
 *
 * @author Java-LM
 */
@Component
public class CategoriaMapperDefaultImpl implements CategoriaMapper {

    @Override
    public CategoriaDto map(Categoria object) {
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(object.getId());
        categoriaDto.setNombre(object.getNombre());
        return categoriaDto;
    }

    @Override
    public Categoria map(CategoriaDto object) {
        Categoria categoria = new Categoria();
        categoria.setId(object.getId());
        categoria.setNombre(object.getNombre());
        return categoria;
    }
    
}
