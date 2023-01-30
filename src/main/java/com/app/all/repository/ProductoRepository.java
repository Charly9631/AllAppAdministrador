package com.app.all.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.all.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	//@Query("select p from PRODUCTOS p where p.nombre like %?1%")
	public List<Producto> findByNombreLikeIgnoreCase(String nombre);
}
