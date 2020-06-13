package com.njug.junitsdemo.repositorios;

import com.njug.junitsdemo.modelos.CategoriaDeProductos;
import com.njug.junitsdemo.modelos.Impuesto;
import com.njug.junitsdemo.modelos.Localidad;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositorioDeImpuestos extends CrudRepository<Impuesto, Integer> {

    Optional<Impuesto> findByLocalidadAndCategoria(Localidad localidad, CategoriaDeProductos categoria);

}
