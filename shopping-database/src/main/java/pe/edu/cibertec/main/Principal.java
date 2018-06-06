/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pe.edu.cibertec.configuracion.AppConfig;
import pe.edu.cibertec.dto.ProductoDto;
import pe.edu.cibertec.dto.UsuarioDto;
import pe.edu.cibertec.servicio.CarritoCompraServicio;
import pe.edu.cibertec.servicio.CategoriaServicio;
import pe.edu.cibertec.servicio.ProductoServicio;
import pe.edu.cibertec.servicio.UsuarioServicio;

/**
 *
 * @author Java-LM
 */
public class Principal {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductoServicio productoServicio = ctx.getBean(ProductoServicio.class);
        productoServicio.obtenerTodos().forEach(p -> {
            System.out.printf("Producto: %s, Categoria: %s\n", p.getNombre(), p.getCategoria());
        });
        
        CategoriaServicio categoriaServicio = ctx.getBean(CategoriaServicio.class);
        categoriaServicio.obtenerTodos().forEach(c -> {
            System.out.printf("Categoria: %s\n", c.getNombre());
        });

        UsuarioServicio usuarioServicio = ctx.getBean(UsuarioServicio.class);
        UsuarioDto usuario = usuarioServicio.buscar(1L);

        if (usuario != null) {
            System.out.printf("Usuario: %d %s %s %d\n", usuario.getId(), usuario.getNombre(), usuario.getApellido(),
                    usuario.getEdad());
        }

        // Usuario nuevo = new Usuario();
        // nuevo.setNombre("Carlos");
        // nuevo.setApellido("Perez");
        // usuarioRepositorio.crear(nuevo);        
        productoServicio.obtenerTodos().forEach(p -> {
            System.out.printf("Producto: %s, Categoria: %s\n", p.getNombre(), p.getCategoria());
        });
        ProductoDto producto = productoServicio.buscar(1l);

        if (producto != null) {
            System.out.printf("Producto: %s - Categoria: %s\n", producto.getNombre(), producto.getCategoria());
        }
        CarritoCompraServicio carritoCompraServicio = ctx.getBean(CarritoCompraServicio.class);
        carritoCompraServicio.buscarPorUsuario(1L).forEach(c -> {
            System.out.printf("Carrito: %d - Usuario: %s\n", c.getId(), c.getUsuario());
            System.out.println("----------------------------------------");

            /*c.getDetalleCarrito().forEach(dc -> {
                System.out.printf("Producto: %s - Categoria: %s - Cantidad: %d - Precio: %s\n",
                        dc.getProducto().getNombre(), dc.getProducto().getCategoria().getNombre(), dc.getCantidad(),
                        dc.getPrecioUnitario());
            });*/
        });
        productoServicio.obtenerPorCategoriaCriteriaApi(1L).forEach(p -> {
            System.out.printf("Producto: %s - Categoria: %s\n", p.getNombre(), p.getCategoria());
        });        
    }
}
