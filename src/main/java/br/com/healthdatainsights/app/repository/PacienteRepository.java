package br.com.healthdatainsights.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.healthdatainsights.app.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
