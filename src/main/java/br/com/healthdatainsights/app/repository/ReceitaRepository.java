package br.com.healthdatainsights.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.healthdatainsights.app.entity.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
