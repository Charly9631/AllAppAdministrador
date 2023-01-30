package com.app.all.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.all.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	//@Query("select c from Clientes c where c.nombre like %?1%")
	public List<Cliente> findByNombreLikeIgnoreCase(String nombr);
	
}
