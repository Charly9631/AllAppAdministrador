package com.app.all.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.all.model.Contado;

@Repository
public interface ContadoRepository extends JpaRepository<Contado, Integer>{

}
