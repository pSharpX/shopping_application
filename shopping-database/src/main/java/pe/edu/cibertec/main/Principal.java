/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pe.edu.cibertec.configuracion.AppConfig;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dominio.Usuario;
import pe.edu.cibertec.repositorio.CarritoCompraRepositorio;
import pe.edu.cibertec.repositorio.CategoriaRepositorio;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.repositorio.UsuarioRepositorio;
import pe.edu.cibertec.repositorio.impl.CarritoCompraJpaRepositorioImpl;
import pe.edu.cibertec.repositorio.impl.CategoriaJpaRepositorioImpl;
import pe.edu.cibertec.repositorio.impl.ProductoJpaRepositorioImpl;
import pe.edu.cibertec.repositorio.impl.UsuarioJpaRepositorioImpl;

/**
 *
 * @author Java-LM
 */
public class Principal {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductoRepositorio productoRepositorio = ctx.getBean(ProductoJpaRepositorioImpl.class);
        productoRepositorio.obtenerTodos().forEach(p -> {
            System.out.printf("Producto: %s, Categoria: %s\n", p.getNombre(), p.getCategoria().getNombre());
        });
        
        CategoriaRepositorio categoriaRepositorio = ctx.getBean(CategoriaJpaRepositorioImpl.class);
        categoriaRepositorio.obtenerTodos().forEach(c -> {
            System.out.printf("Categoria: %s\n", c.getNombre());
        });

        UsuarioRepositorio usuarioRepositorio = ctx.getBean(UsuarioJpaRepositorioImpl.class);
        Usuario usuario = usuarioRepositorio.buscar(1L);

        if (usuario != null) {
            System.out.printf("Usuario: %d %s %s %d\n", usuario.getId(), usuario.getNombre(), usuario.getApellido(),
                    usuario.getEdad());
        }

        // Usuario nuevo = new Usuario();
        // nuevo.setNombre("Carlos");
        // nuevo.setApellido("Perez");
        // usuarioRepositorio.crear(nuevo);        
        productoRepositorio.obtenerTodos().forEach(p -> {
            System.out.printf("Producto: %s, Categoria: %s\n", p.getNombre(), p.getCategoria().getNombre());
        });
        Producto producto = productoRepositorio.buscar(1l);

        if (producto != null) {
            System.out.printf("Producto: %s - Categoria: %s\n", producto.getNombre(), producto.getCategoria().getNombre());
        }
        CarritoCompraRepositorio carritoRepositorio = ctx.getBean(CarritoCompraJpaRepositorioImpl.class);
        carritoRepositorio.buscarPorUsuario(1L).forEach(c -> {
            System.out.printf("Carrito: %d - Usuario: %s\n", c.getId(), c.getUsuario().getApellido());
            System.out.println("----------------------------------------");

            /*c.getDetalleCarrito().forEach(dc -> {
                System.out.printf("Producto: %s - Categoria: %s - Cantidad: %d - Precio: %s\n",
                        dc.getProducto().getNombre(), dc.getProducto().getCategoria().getNombre(), dc.getCantidad(),
                        dc.getPrecioUnitario());
            });*/
        });
        productoRepositorio.obtenerPorCategoriaCriteriaApi(1L).forEach(p -> {
            System.out.printf("Producto: %s - Categoria: %s\n", p.getNombre(), p.getCategoria().getNombre());
        });        
    }
}
