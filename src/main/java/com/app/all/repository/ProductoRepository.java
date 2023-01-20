package com.app.all.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.all.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
