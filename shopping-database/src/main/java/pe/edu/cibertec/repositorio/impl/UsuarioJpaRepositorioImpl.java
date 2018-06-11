/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.repositorio.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.dominio.Usuario;
import pe.edu.cibertec.repositorio.UsuarioRepositorio;

import java.util.List;

/**
 *
 * @author Java-LM
 */
@Repository
public class UsuarioJpaRepositorioImpl
        implements UsuarioRepositorio {

    @PersistenceContext(unitName = "defaultPersistenceUnit")
    private EntityManager em;

    @Override
    public Usuario buscar(Long id) {
        return this.em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return null;
    }

    @Override
    public void crear(Usuario usuario) {
        this.em.persist(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        this.em.merge(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        this.em.remove(usuario);
    }

	@Override
	public Usuario buscar(String username, String contraseña) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq
                .select(usuario)
                .where(cb.and(cb.equal(usuario.get("nombre"), username), cb.equal(usuario.get("apellido"), contraseña)))
                .orderBy(cb.asc(usuario.get("nombre")));
        TypedQuery<Usuario> query = this.em.createQuery(cq);
        return query.getSingleResult();
	}

}
