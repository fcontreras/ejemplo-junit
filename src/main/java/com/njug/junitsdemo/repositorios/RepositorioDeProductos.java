package com.njug.junitsdemo.repositorios;

import com.njug.junitsdemo.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioDeProductos extends CrudRepository<Producto, Integer> {
}
