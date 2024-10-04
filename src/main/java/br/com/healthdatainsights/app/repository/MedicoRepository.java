package br.com.healthdatainsights.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.healthdatainsights.app.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
