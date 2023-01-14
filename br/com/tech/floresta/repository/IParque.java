package br.com.tech.floresta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tech.floresta.model.Parque;

@Repository
public interface IParque extends JpaRepository<Parque, Integer>{

}
